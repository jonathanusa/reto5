package com.example.demo.entities.dto;

import com.example.demo.entities.Client;


public class TopClients {
    private int total;
    private Client client;

    public TopClients(int total, Client client){
        this.total=total;
        this.client=client;
    }


    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
