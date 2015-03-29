package org.joseblas.addressbook.service;

import org.joseblas.addressbook.model.Gender;
import org.joseblas.addressbook.model.Person;

import java.util.Optional;

/**
 * Created by joseblas on 29/3/15.
 */
public interface AddressBookService {

    public Long countByGender(Gender gender);

    public Optional<Person> getOldestPerson();


}
