package com.taxiService.taxi.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Request{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime requestTime;
    private String details;
    @ManyToOne
    private User client;
    @ManyToOne
    private User taxiCompany;

    public Request(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(LocalDateTime requestTime) {
        this.requestTime = requestTime;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public User getTaxiCompany() {
        return taxiCompany;
    }

    public void setTaxiCompany(User taxiCompany) {
        this.taxiCompany = taxiCompany;
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", requestTime=" + requestTime +
                ", details='" + details + '\'' +
                ", client=" + client +
                ", taxiCompany=" + taxiCompany +
                '}';
    }
}
