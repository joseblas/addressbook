package org.joseblas.addressbook.service;

import org.joseblas.addressbook.model.Gender;
import org.joseblas.addressbook.model.Person;

import java.util.List;
import java.util.Optional;

public interface AddressBookService {

    public Long countByGender(Gender gender);

    public Optional<Person> getOldestPerson();

    public void reload(List<Person> newdata);

}
