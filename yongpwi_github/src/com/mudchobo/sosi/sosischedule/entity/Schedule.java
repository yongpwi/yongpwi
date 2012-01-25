package com.mudchobo.sosi.sosischedule.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

@Entity
public class Schedule implements Serializable{
    private static final long serialVersionUID = -8676837674549793653L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key key; 
    
    private String program;
    
    @ManyToOne(fetch=FetchType.LAZY)
    private Sosi sosi;
    
    public Sosi getSosi() {
        return sosi;
    }

    public void setSosi(Sosi sosi) {
        this.sosi = sosi;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }
    
    
    public String getKeyString() {
        return KeyFactory.keyToString(key);
    }
    
    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }
    
    public Schedule() {
    }

    public Schedule(String program, Sosi sosi) {
        this.program = program;
        this.sosi = sosi;
    }
}