package org.joseblas.addressbook.service.impl;

import org.joseblas.addressbook.TestBase;
import org.joseblas.addressbook.model.Gender;
import org.joseblas.addressbook.model.Person;
import org.joseblas.addressbook.service.AddressBookService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static junit.framework.Assert.assertEquals;

public class AddressBookServiceImplTest extends TestBase {

    private AddressBookService addressbook;

    @Before
    public void setUp() throws Exception {
        addressbook = new AddressBookServiceImpl(createCsvReader().readRecords());

    }

    @Test
    public void countByGenderFemaleTest(){
        assertEquals("Two females", 2L, addressbook.countByGender(Gender.Female).longValue());
    }

    @Test
    public void countByGenderMaleTest(){
        assertEquals("Three males", 3L, addressbook.countByGender(Gender.Male).longValue());
    }


    @Test
    public void getOlder(){
        Optional<Person> person = addressbook.getOldestPerson();
        Assert.assertTrue("There are data", person.isPresent());
        Assert.assertEquals("Is Wes Jackson", "Wes Jackson", person.get().getName());
    }

    @Test
    public void howOlderIsBillThanPaul(){
        Person bill = addressbook.get("Bill McKnight").get();
        Person paul = addressbook.get("Paul Robinson").get();
        assertEquals("The diff is 2862", 2862, bill.daysOlderThan(paul));
    }
}