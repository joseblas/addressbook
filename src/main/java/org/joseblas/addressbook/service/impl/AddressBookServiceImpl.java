package org.joseblas.addressbook.service.impl;

import org.joseblas.addressbook.model.Gender;
import org.joseblas.addressbook.model.Person;
import org.joseblas.addressbook.service.AddressBookService;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public class AddressBookServiceImpl implements AddressBookService {

    private List<Person> addressbook;

    public AddressBookServiceImpl(List<Person> addressbook) throws ParseException {
        this.addressbook = addressbook;
    }

    @Override
    public Long countByGender(Gender gender) {
        return addressbook.stream().filter(p -> gender.equals(p.getGender())).count();
    }

    @Override
    public Optional<Person> getOldestPerson() {
        return addressbook.stream().min((p1, p2) -> p1.getDob().compareTo(p2.getDob()));
    }

    @Override
    public void reload(List<Person> newdata) {
        this.addressbook = newdata;
    }

    @Override
    public Optional<Person> get(String name) {
        return addressbook.stream().filter(p -> name.equals(p.getName())).findFirst();
    }
}
