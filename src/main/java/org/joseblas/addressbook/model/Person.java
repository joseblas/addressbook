package org.joseblas.addressbook.model;

import org.joda.time.DateTime;
import org.joda.time.Days;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by joseblas on 29/3/15.
 */
public class Person {
    protected static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private String name;
    private Gender gender;
    private Date dob;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int daysOlderThan(Person other){
        return Days.daysBetween(new DateTime(getDob()), new DateTime(other.getDob())).getDays();
    }

    public static Person createPerson(String name, Gender gender, String dob) throws ParseException {
        Person p = new Person();
        p.setName(name);
        p.setGender(gender);
        p.setDob(sdf.parse(dob));
        return p;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", dob=" + dob +
                '}';
    }

}
