package nu.te4.beans;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import nu.te4.entities.Machines;
import nu.te4.entities.Users;
import nu.te4.sessionbeans.MachinesFacade;
import nu.te4.sessionbeans.UsersFacade;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author olalindsten
 */
@Named
@SessionScoped
public class MachineBean implements Serializable {

    private int price, MUser_id, id;
    private String name, description, brand, image, date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMUser_id() {
        return MUser_id;
    }

    public void setMUser_id(int MUser_id) {
        this.MUser_id = MUser_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @EJB
    MachinesFacade machinesFacade;

    @EJB
    UsersFacade usersFacade;

    public List<Machines> getMachines() {
        return machinesFacade.findAll();
    }

    public String saveMachine() {

        Machines machine = new Machines(null, name, description, brand, price, image, date);
        Users user = usersFacade.find(MUser_id);
        machine.setMUser(user);
        machinesFacade.create(machine);

        return "myPage";
    }

    public String removeMachine() {
            
    Machines machine = machinesFacade.find(id);
    machinesFacade.remove(machine);
        
    return "myPage";
    }
}
