package org.joseblas.addressbook.reader;

import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class CsvReaderTest {


        @Test
        public void readsRecords(){
            CsvReader csvReader = createCsvReader();
            List records = csvReader.readRecords();
            assertEquals("There are 5 people", 5, records.size());

        }



    public CsvReader createCsvReader() {
        try {
            Path path = Paths.get("src/test/resources", "samples.csv");
            Reader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));
            return new CsvReader(reader);

        } catch (IOException e) {
            throw new UncheckedIOException(e);

        }
    }
}