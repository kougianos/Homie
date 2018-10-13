package rest;

import java.security.Key;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


import annotations.Secured;

import javax.ws.rs.core.UriBuilder;

import db.UserDB;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import model.LoginInfo;
import model.User;

@Path("/users")
public class UserEndpoint {

	@Secured
	@POST
	@Consumes({ "application/json" })
	public Response create(final User user) {
		entities.User userd = new entities.User();
		userd.setFirstName(user.getFirstName());
		userd.setLastName(user.getLastName());
		userd.setUsername(user.getUsername());
		userd.setPassword(user.getPassword());
		UserDB userDao = new UserDB();
		int id = userDao.insertUser(userd);
		return Response.created(
				UriBuilder.fromResource(UserEndpoint.class)
						.path(String.valueOf(id)).build()).build();
	}
	
	@POST
	@Path("/login")
	@Consumes({"application/json"})
	@Produces({"text/plain"})
	public Response login(final LoginInfo loginInfo) {
		UserDB userDao = new UserDB();
		entities.User userd = userDao.find(loginInfo.getUsername(), loginInfo.getPassword());
		if (userd != null) {
			String token = issueToken(loginInfo.getUsername());
			return Response.ok(token, "text/plain").build();
		}
		else {
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}
	}
	
	private String issueToken(String username) {
		Key key = utilities.KeyHolder.key;
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		long expMillis = nowMillis + 300000L;
        Date exp = new Date(expMillis);
		String jws = Jwts.builder()
				  .setSubject(username)
				  .setIssuedAt(now)
				  .signWith(SignatureAlgorithm.HS512, key)
				  .setExpiration(exp)
				  .compact();
		return jws;
    }

	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces({"application/json"})
	public Response findById(@PathParam("id") final Integer id) {
		UserDB userDao = new UserDB();
		entities.User userd = userDao.getById(id);
		User user = null;
		if (userd != null) {
			user = new User();
			user.setId(userd.getId());
			user.setLastName(userd.getLastName());
			user.setFirstName(userd.getFirstName());
			user.setPassword(userd.getPassword());
			user.setUsername(userd.getUsername());
		}
		if (user == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(user).build();
	}

	@GET
	@Produces({ "application/json" })
	public List<User> listAll() {
		UserDB userDao = new UserDB();
		List<entities.User> usersd = userDao.getUsers();
		List<User> users = null;
		if (usersd != null && usersd.size()>0)
		{
			users = new ArrayList<User>();
			for (entities.User userd : usersd)
			{
				User user = new User();
				user.setId(userd.getId());
				user.setLastName(userd.getLastName());
				user.setFirstName(userd.getFirstName());
				user.setPassword(userd.getPassword());
				user.setUsername(userd.getUsername());
				users.add(user);
			}
		}
		
		
		return users;
	}


	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") final Long id) {
		//TODO: process the user matching by the given id 
		return Response.noContent().build();
	}

}
