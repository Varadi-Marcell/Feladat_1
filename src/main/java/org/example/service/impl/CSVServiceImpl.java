package org.example.service.impl;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import org.example.model.Data;
import org.example.service.CSVService;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CSVServiceImpl implements CSVService {
    private final List<Data> dataList;

    public CSVServiceImpl(List<Data> dataList) {
        this.dataList = dataList;
    }

    public List<Data> readFromCSV() {
        try (
                Reader reader = Files.newBufferedReader(Paths.get("data.csv"));
                CSVReader csvReader = new CSVReaderBuilder(reader)
                        .withSkipLines(1)
                        .build();
        ) {

            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                Data data = new Data();
                data.setId(Long.parseLong(nextRecord[0]));
                data.setName(nextRecord[1]);
                data.setCode(Integer.parseInt(nextRecord[2]));
                dataList.add(data);
            }
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return dataList;
    }

    @Override
    public List<Data> sortDescendingNames(List<Data> list) {
       return list.stream().sorted(Comparator.comparing(Data::getName)).collect(Collectors.toList());
    }

    @Override
    public List<Data> filterListByCode(List<Data> dataList) {
        return dataList.stream().filter(data -> data.getCode() >= 2 && data.getCode()<=6).collect(Collectors.toList());
    }
}
