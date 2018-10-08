package com.example.allen.budgejava.dao;

import com.example.allen.budgejava.objects.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class financeDAOImpl implements financeDAO {

    private List<Data> dataFiananceList = new ArrayList<>();

    @Override
    public List<Data> getAll() {
        return dataFiananceList;
    }

    @Override
    public Data get(int dataIndex) {
        return dataFiananceList.get(dataIndex);
    }

    @Override
    public void save(Data data) {
        dataFiananceList.add(data);
    }
}
