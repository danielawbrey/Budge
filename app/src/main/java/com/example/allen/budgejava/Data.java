package com.example.allen.budgejava;

import java.time.LocalDateTime;
import java.util.Date;

public class Data {

    private LocalDateTime date;
    private double amount;
    private String type;

    Data() {
        this.date = null;
        this.amount = 0.0;
        this.type = null;
    }

    Data(LocalDateTime date, double amount, String type) {
        this.date = date;
        this.amount = amount;
        this.type = type;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setType(String type) {
        this.type = type;
    }
}
