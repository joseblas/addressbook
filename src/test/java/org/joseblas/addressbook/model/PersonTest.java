package org.joseblas.addressbook.model;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class PersonTest {

    @Test
    public void testDaysOlderThan() throws Exception {
        Person rosa = Person.createPerson("Rosa", Gender.Female, "03/07/1980");
        Person tabo = Person.createPerson("Tabo", Gender.Female, "16/04/1978");
        assertEquals("The diff is XXX", 809, tabo.daysOlderThan(rosa));
    }

    @Test
    public void testDaysOlderThanInFeb() throws Exception {
        Person rosa = Person.createPerson("Rosa", Gender.Female, "01/03/1981");
        Person tabo = Person.createPerson("Tabo", Gender.Female, "01/02/1981");
        assertEquals("The diff is XXX", 28, tabo.daysOlderThan(rosa));
    }

    @Test
    public void testDaysOlderThanInFebWith29Days() throws Exception {
        Person rosa = Person.createPerson("Rosa", Gender.Female, "01/03/2000");
        Person tabo = Person.createPerson("Tabo", Gender.Female, "01/02/2000");
        assertEquals("The diff is XXX", 29, tabo.daysOlderThan(rosa));
    }
}