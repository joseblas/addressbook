package org.joseblas.addressbook.reader;

import org.joseblas.addressbook.model.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.util.List;
import java.util.stream.Collectors;

public class CsvReader {
    private static final String SEPARATOR = ",";

    private final Reader source;

    public CsvReader(Reader source) {
        this.source = source;
    }

    public List<Person> readRecords(){
        try (BufferedReader reader = new BufferedReader(source)) {
            return reader.lines()
                    .map(line -> line.split(SEPARATOR))
                    .map(splitted -> Person.createPerson(splitted[0],
                                                         splitted[1],
                                                         splitted[2]))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
