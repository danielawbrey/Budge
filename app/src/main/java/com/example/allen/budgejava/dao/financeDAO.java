package com.example.allen.budgejava.dao;

import com.example.allen.budgejava.objects.Data;

import java.util.List;
import java.util.Optional;

public interface financeDAO<T> {
    List<T> getAll();
    Data get(int dataIndex);
    void save(Data data);
}
