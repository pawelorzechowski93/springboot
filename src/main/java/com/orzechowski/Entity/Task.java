package com.orzechowski.Entity;

import javax.persistence.*;

@Entity
@Table(name = "task")

/**
 * Created by user on 29.11.2016.
 */
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private  String name;
    private String descryption;
    private String start_date;
    private String end_date;


    public Task(int id, String name, String descryption, String start_date, String end_date) {
        this.id = id;
        this.name = name;
        this.descryption = descryption;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public Task(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescryption() {
        return descryption;
    }

    public void setDescryption(String descryption) {
        this.descryption = descryption;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }
}
