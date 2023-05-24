package org.example.service;

import org.example.model.Data;

import java.util.List;

public interface CSVService {
    List<Data> readFromCSV();
    List<Data> sortDescendingNames(List<Data> dataList);
    List<Data> filterListByCode(List<Data> dataList);
}
