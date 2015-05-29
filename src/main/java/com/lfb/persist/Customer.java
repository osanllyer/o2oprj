package com.lfb.persist;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String firstname;
    private String lastname;

    protected Customer() {}

    public Customer(String firstName, String lastName) {
        this.firstname = firstName;
        this.lastname = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstname='%s', lastname='%s']",
                id, firstname, lastname);
    }

}