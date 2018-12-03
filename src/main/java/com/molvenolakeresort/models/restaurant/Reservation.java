package com.molvenolakeresort.models.restaurant;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.molvenolakeresort.models.restaurant.enums.Course;
import com.molvenolakeresort.models.restaurant.temp.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Reservation {

    private @Id
    @GeneratedValue
    Long id;
    private Integer amountOfPeople;
    @OneToOne(cascade = CascadeType.ALL)
    private User user;
    private LocalDate date;
    private LocalTime time;
    private Course course;

    //TODO: Relation is incorrect? Adding to database does not work atm.
    @OneToMany(mappedBy = "id", fetch = FetchType.EAGER)//(cascade = {CascadeType.ALL, CascadeType.ALL})
    private List<Table> tables;

    public Reservation() {
    }

    public Reservation(User user, LocalDate date, LocalTime time, Course course, List<Table> tables) {
        this.user = user;
        this.date = date;
        this.time = time;
        this.course = course;
        this.tables = tables;
    }

    public User getUser() {
        return user;
    }

    public List<Table> getTables() {
        return tables;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public Course getCourse() {
        return course;
    }

    public Long getId() {
        return id;
    }

    public Integer getAmountOfPeople() {
        return amountOfPeople;
    }
}
