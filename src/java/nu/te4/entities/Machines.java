/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author olalindsten
 */
@Entity
@Table(name = "machines")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Machines.findAll", query = "SELECT m FROM Machines m"),
    @NamedQuery(name = "Machines.findById", query = "SELECT m FROM Machines m WHERE m.id = :id"),
    @NamedQuery(name = "Machines.findByName", query = "SELECT m FROM Machines m WHERE m.name = :name"),
    @NamedQuery(name = "Machines.findByDescription", query = "SELECT m FROM Machines m WHERE m.description = :description"),
    @NamedQuery(name = "Machines.findByBrand", query = "SELECT m FROM Machines m WHERE m.brand = :brand"),
    @NamedQuery(name = "Machines.findByPrice", query = "SELECT m FROM Machines m WHERE m.price = :price"),
    @NamedQuery(name = "Machines.findByImage", query = "SELECT m FROM Machines m WHERE m.image = :image"),
    @NamedQuery(name = "Machines.findByDate", query = "SELECT m FROM Machines m WHERE m.date = :date")})
public class Machines implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "brand")
    private String brand;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private int price;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "image")
    private String image;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "date")
    private String date;
    @JoinColumn(name = "mUser", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private Users mUser;

    public Machines() {
    }

    public Machines(Integer id) {
        this.id = id;
    }

    public Machines(Integer id, String name, String description, String brand, int price, String image, String date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.price = price;
        this.image = image;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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

    public Users getMUser() {
        return mUser;
    }

    public void setMUser(Users mUser) {
        this.mUser = mUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Machines)) {
            return false;
        }
        Machines other = (Machines) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "nu.te4.entities.Machines[ id=" + id + " ]";
    }

}
