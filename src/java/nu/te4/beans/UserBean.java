package nu.te4.beans;

import bycrypttest.BCrypt;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import nu.te4.entities.Users;
import nu.te4.sessionbeans.UsersFacade;

@Named
@SessionScoped
public class UserBean implements Serializable {

    private String username, password;

    public UsersFacade getUsersFacade() {
        return usersFacade;
    }

    public void setUsersFacade(UsersFacade usersFacade) {
        this.usersFacade = usersFacade;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @EJB
    UsersFacade usersFacade;

    public List<Users> getUsers() {

        return usersFacade.findAll();

    }

   /* public String register() {

        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        Users users = new Users(null, username, hashedPassword);
        usersFacade.create(users);
        return "home";
    } */    

    public String logIn() throws InterruptedException {
        System.out.println("logIn!");
        System.out.println("Username: "+username);
        System.out.println("Password: "+password);
        //usersFacade.findAll();
        Users user = usersFacade.find(1);
        System.out.println("Username:"+user.getUsername());
        System.out.println("Hash:"+user.getPassword());
        
        if(BCrypt.checkpw(password, user.getPassword()) && username.equals("test")){
                Thread.sleep(2000);
                 return "myPage";
        }else{
                return "index";
        }
   
    }

}
