package com.dev.backend.Entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToOne
    @JoinColumn(name="reciver_id")
    private Users reciver;

    @ManyToOne
    @JoinColumn(name="sender_id")
    private Users sender;

    private String description;


    private boolean deleteSender;

    private boolean deleteReceiver;

    public Message(){}


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Users getReciver() {
        return reciver;
    }

    public void setReciver(Users reciver) {
        this.reciver = reciver;
    }

    public Users getSender() {
        return sender;
    }

    public void setSender(Users sender) {
        this.sender = sender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDeleteSender() {
        return deleteSender;
    }

    public void setDeleteSender(boolean deleteSender) {
        this.deleteSender = deleteSender;
    }

    public boolean isDeleteReceiver() {
        return deleteReceiver;
    }

    public void setDeleteReceiver(boolean deleteReceiver) {
        this.deleteReceiver = deleteReceiver;
    }
}
