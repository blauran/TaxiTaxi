package com.taxiService.taxi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Observable;

@Entity
public class TaxiCar extends Observable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalTime requestTime;
    private int waitTime;
    private boolean available;
    private float tarif;
    @ManyToOne
    private User taxiCompany;
    @OneToOne
    private User client;

    public TaxiCar(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalTime getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(LocalTime requestTime) {
        this.requestTime = requestTime;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
        setChanged();
        notifyObservers(available);
    }

    public User getCompany() {
        return taxiCompany;
    }

    public void setCompany(User company) {
        this.taxiCompany = company;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public float getTarif() {
        return tarif;
    }

    public void setTarif() {
       this.tarif = PriceFactory.getPrice(requestTime).price();
    }

    @Override
    public String toString() {
        return "TaxiCar{" +
                "id=" + id +
                ", requestTime=" + requestTime +
                ", waitTime=" + waitTime +
                ", available=" + available +
                ", tarif=" + tarif +
                ", company=" + taxiCompany +
                ", client=" + client +
                '}';
    }
}
