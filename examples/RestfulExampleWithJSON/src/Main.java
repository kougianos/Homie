import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import model.User;
import model.UserWrapper;


public class Main {
	
	public static void main(String[] args)
	{
		User user = new User();
		user.setId(100);
		
		UserWrapper wrap = new UserWrapper();
		
		User[] users = new User[10];
		for (int i=0; i<10; i++)
		{
			users[i] = user;
		}
		wrap.setUsers(users);
		ObjectMapper mapper = new ObjectMapper();
		//mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		try {
			//mapper.writeValue(System.out, users);
			//mapper.writeValue(System.out, wrap);
			mapper.writeValue(System.out, user);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*String jsonObj = "{\"User\":{\"username\" : \"ihamod\",\"id\" : 10,\"firstName\" : null,\"lastName\" : null,"
				+ "\"password\" : null}}";
		try {
			User user1 = mapper.readValue(jsonObj, User.class);
			System.out.println(user1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}

}
