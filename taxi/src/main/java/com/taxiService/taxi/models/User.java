package com.taxiService.taxi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.usertype.UserType;

import javax.persistence.*;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

@Entity
public class User implements Observer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true, length = 50)
    private String username;
    private String password;
    private String name;
    @OneToMany(mappedBy = "taxiCompany")
    private List<TaxiCar> taxiCompanyCars;
    @OneToMany(mappedBy = "taxiCompany")
    private List<Request> taxiCompanyRequests;
    @OneToMany(mappedBy = "client")
    private List<Request> clientRequests;
    @OneToOne(mappedBy = "client")
    private TaxiCar taxi;
    private Role role;

    public User(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public List<TaxiCar> getTaxiCompanyAvailableCars() {
        return taxiCompanyCars;
    }

    public void setTaxiCompanyAvailableCars(List<TaxiCar> taxiCompanyAvailableCars) {
        this.taxiCompanyCars = taxiCompanyAvailableCars;
    }

    @JsonIgnore
    public List<Request> getTaxiCompanyRequests() {
        return taxiCompanyRequests;
    }

    public void setTaxiCompanyRequests(List<Request> taxiCompanyRequests) {
        this.taxiCompanyRequests = taxiCompanyRequests;
    }

    @JsonIgnore
    public List<Request> getClientRequests() {
        return clientRequests;
    }

    public void setClientRequests(List<Request> clientRequests) {
        this.clientRequests = clientRequests;
    }

    @JsonIgnore
    public TaxiCar getTaxi() {
        return taxi;
    }

    public void setTaxi(TaxiCar taxi) {
        this.taxi = taxi;
    }

    @JsonIgnore
    public List<TaxiCar> getTaxiCompanyCars() {
        return taxiCompanyCars;
    }

    public void setTaxiCompanyCars(List<TaxiCar> taxiCompanyCars) {
        this.taxiCompanyCars = taxiCompanyCars;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", taxiCompanyAvailableCars=" + taxiCompanyCars +
                ", taxiCompanyRequests=" + taxiCompanyRequests +
                ", request=" + clientRequests +
                '}';
    }


    @Override
    public void update(Observable o, Object arg) {
        if(!taxi.isAvailable()){
            System.out.println("Taxi nu este valabil");
        }


    }
}
