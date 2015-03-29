package org.joseblas.addressbook.reader;

import org.joseblas.addressbook.TestBase;
import org.joseblas.addressbook.model.Person;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;

public class CsvReaderTest extends TestBase {

        @Test
        public void readsRecords(){
            CsvReader csvReader = createCsvReader();
            List<Person> records = csvReader.readRecords();
            assertEquals("There are 5 people", 5, records.size());
        }




}