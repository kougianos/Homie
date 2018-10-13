/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package export;

import dao.MessageDAOImpl;
import dao.RoomDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;
import entities.Bed;
import entities.Facilities;
import entities.Message;
import entities.Role;
import entities.Room;
import entities.Rules;
import entities.Space;
import entities.User;
import entities.UserRentsRoom;
import export.model.BedModel;
import export.model.BedWrapper;
import export.model.FacilitiesModel;
import export.model.MessageModel;
import export.model.RoleModel;
import export.model.RoomModel;
import export.model.RulesModel;
import export.model.SpaceModel;
import export.model.UserModel;
import export.model.UserRentsRoomModel;
import export.model.UserWrapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

/**
 *
 * @author kougi
 */
@WebServlet(name = "ExportServlet", urlPatterns = {"/export"})
public class ExportServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/xml"); // Tell browser what content type the response body represents, so that it can associate it with e.g. MS Excel, if necessary.
        response.setHeader("Content-Disposition", "attachment; filename=database.xml"); // Force "Save As" dialogue.
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            UserDAOImpl d = new UserDAOImpl();
            RoomDAOImpl rd = new RoomDAOImpl();
            

            Root root = new Root();

            // *****************************************************
            //                     EXPORT USERS
            // *****************************************************
            List<User> users = d.export();

            UserModel[] usermodels = new UserModel[users.size()];

            int i = 0;
            for (User u : users) {
                
                UserModel model = new UserModel();

                model.setUsername(u.getUsername());
                model.setPassword(u.getPassword());
                model.setName(u.getName());
                model.setSurname(u.getSurname());
                model.setEmail(u.getEmail());
                model.setPhone(u.getPhone());
                model.setPhoto(u.getPhoto());
                model.setActive(u.getActive());

                RoleModel[] roles = new RoleModel[u.getRoleList().size()];

                int j = 0;
                for (Role r : u.getRoleList()) {
                    RoleModel rmodel = new RoleModel();
                    rmodel.setDescription(r.getType());

                    roles[j++] = rmodel;
                }

                model.getRoleWrapper().setRoles(roles);
                               
                
                MessageModel[] messages = new MessageModel[u.getMessageList().size()];

                j = 0;
                for (Message m : u.getMessageList()) {
                    MessageModel mmodel = new MessageModel();
                   
                    mmodel.setDate(m.getDate());
                    mmodel.setMessagetext(m.getMessagetext());
                    mmodel.setWriter(m.getUser1().getUsername());
                   

                    messages[j++] = mmodel;
                }

                model.getMessageWrapper().setMessages(messages);
                
                
                
                
               
                //if (!(u.getUsername()).equals (usermodels[i].getUsername() )){
                usermodels[i++] = model;
            //}
            }

            root.getWrapper().setUsers(usermodels);

            // *****************************************************
            //                    EXPORT ROOMS            
            // *****************************************************
            List<Room> rooms = rd.export();

            RoomModel[] roommodels = new RoomModel[rooms.size()];

            i = 0;
            for (Room r : rooms) {
                RoomModel model = new RoomModel();

                model.setIdroom(r.getIdroom());
                model.setArea(r.getArea());
                model.setAvailableFrom(r.getAvailableFrom());
                model.setAvailableTill(r.getAvailableTill());
                model.setPeopleNumber(r.getPeopleNumber());
                model.setPrice(r.getPrice());
                model.setPlusPersonPrice(r.getPlusPersonPrice());
                
                
                 BedModel[] beds = new BedModel[r.getBedList().size()];

                int j = 0;
                for (Bed b : r.getBedList()) {
                    BedModel bmodel = new BedModel();
                    bmodel.setType(b.getType());
                    bmodel.setNumber(b.getNumber());

                    beds[j++] = bmodel;
                }

                model.getBedWrapper().setBeds(beds);
                
                               

                // ---------------------------------------- JOIN OWNER
                User owner = r.getUserList().get(0);

                UserModel ownermodel = new UserModel();

                ownermodel.setUsername(owner.getUsername());
                //ownermodel.setPassword(owner.getPassword());
                ownermodel.setName(owner.getName());
                ownermodel.setSurname(owner.getSurname());
                //ownermodel.setEmail(owner.getEmail());
                //ownermodel.setPhone(owner.getPhone());
                //ownermodel.setPhoto(owner.getPhoto());
                //ownermodel.setActive(owner.getActive());

                model.setOwner(ownermodel);

                // ---------------------------------------- JOIN RENTERS
                UserWrapper rentersWrapper = new UserWrapper();
                UserModel [] renters_model = new UserModel[r.getUserRentsRoomList().size()];
                
                 j=0;
                
                for (UserRentsRoom urr : r.getUserRentsRoomList()) {
                    User renter = urr.getUsername();
                    //UserRentsRoomModel userrentsroommodel = new UserRentsRoomModel();
                    //userrentsroommodel.setRate(urr.getRate());
                   

                    UserModel rentermodel = new UserModel();

                    rentermodel.setUsername(renter.getUsername());
                    //rentermodel.setPassword(renter.getPassword());
                    rentermodel.setName(renter.getName());
                    rentermodel.setSurname(renter.getSurname());
                    //rentermodel.setEmail(renter.getEmail());
                    //rentermodel.setPhone(renter.getPhone());
                    //rentermodel.setPhoto(renter.getPhoto());
                    //rentermodel.setActive(renter.getActive());

                    renters_model[j++] = rentermodel;
                    
                }
                
                rentersWrapper.setUsers(renters_model);
                model.setRenters(rentersWrapper);
                
                
                
                // ---------------------------------------- JOIN FACILITIES
                Facilities facility = r.getFacilitiesList().get(0);
                FacilitiesModel facilitiesmodel = new FacilitiesModel();
                
                facilitiesmodel.setAirCondition(facility.getAirCondition());
                facilitiesmodel.setElevator(facility.getElevator());
                facilitiesmodel.setOven(facility.getOven());
                facilitiesmodel.setParking(facility.getParking());
                facilitiesmodel.setTv(facility.getTv());
                facilitiesmodel.setWifi(facility.getWifi());
                
                model.setFacilities(facilitiesmodel);
                
                // ---------------------------------------- JOIN RULES
                Rules rule = r.getRulesList().get(0);
                RulesModel rulesmodel = new RulesModel();
                
                rulesmodel.setEvents(rule.getEvents());
                rulesmodel.setMinDays(rule.getMinDays());
                rulesmodel.setPets(rule.getPets());
                rulesmodel.setSmoking(rule.getSmoking());
                
                
                model.setRules(rulesmodel);
                
                // ---------------------------------------- JOIN SPACES
                Space space = r.getSpaceList().get(0);
                SpaceModel spacemodel = new SpaceModel();
                
                spacemodel.setBathroom(space.getBathroom());
                spacemodel.setBedroom(space.getBedroom());
                spacemodel.setKitchen(space.getKitchen());
                spacemodel.setLivingRoom(space.getLivingRoom());
                
                
                
                model.setSpace(spacemodel);
                
                roommodels[i++] = model;
               
            }
            
           

            root.getRoomWrapper().setRooms(roommodels);
            
            
            // *****************************************************
            //                    Marshalling
            // *****************************************************
            try {
//                response.getWriter().write(csvAsString);

                JAXBContext jaxbContext = JAXBContext.newInstance(Root.class);
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                jaxbMarshaller.marshal(root, out);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }

    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}