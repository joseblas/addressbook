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
    public static final String DD_MM_YYYY = "dd/MM/yyyy";

    protected static SimpleDateFormat sdf = new SimpleDateFormat(DD_MM_YYYY);

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

    public static Person createPerson(String name, String gender, String dob){
        Person p = new Person();
        p.setName(name);
        try {
            Gender parsedGender = Gender.valueOf(gender.trim());
            p.setGender(parsedGender);
        }catch (IllegalArgumentException pe){
            //default gender
            p.setGender(Gender.Male);
        }
        try {
            p.setDob(sdf.parse(dob));
        } catch (ParseException e) {
            //default date
            p.setDob(new Date());
        }
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
