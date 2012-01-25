package com.mudchobo.sosi.sosischedule.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.google.appengine.api.datastore.Key;

@Entity
public class Sosi implements Serializable {
    private static final long serialVersionUID = 5448408922872112420L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Key key;
    
    private String sosiName;
    
    @OneToMany(mappedBy="sosi", cascade=CascadeType.ALL)
    private List<Schedule> scheduleList = new ArrayList<Schedule>();

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public List<Schedule> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }

    public String getSosiName() {
        return sosiName;
    }

    public void setSosiName(String sosiName) {
        this.sosiName = sosiName;
    }

    public Sosi() {
        
    }
    
    public Sosi(Key key, String sosiName) {
        super();
        this.key = key;
        this.sosiName = sosiName;
    }
}