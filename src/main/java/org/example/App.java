package org.example;

import com.opencsv.exceptions.CsvException;
import org.example.service.CSVService;
import org.example.service.impl.CSVServiceImpl;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, CsvException {
        CSVService csvService = new CSVServiceImpl(new ArrayList<>());

        //Kiíratás
//        csvService.readFromCSV().forEach(System.out::println);

        //Nevek Csökkenő sorrendben
//        csvService.sortDescendingNames(csvService.readFromCSV()).forEach(System.out::println);

        //Kódok szűrése
//        csvService.filterListByCode(csvService.readFromCSV()).forEach(System.out::println);

    }
}
