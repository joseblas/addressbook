package org.joseblas.addressbook;

import org.joseblas.addressbook.reader.CsvReader;

import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestBase {
    public CsvReader createCsvReader() {
        try {
            Path path = Paths.get("src/test/resources", "samples.csv");
            Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            return new CsvReader(reader);

        } catch (IOException e) {
            throw new UncheckedIOException(e);

        }
    }
}
