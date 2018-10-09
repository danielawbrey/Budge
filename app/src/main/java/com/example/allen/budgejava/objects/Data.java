package com.example.allen.budgejava.objects;

import java.time.LocalDateTime;
import java.util.Date;

public class Data {

    private LocalDateTime date;
    private float amount;
    private String type;

    public Data() {
        this.date = null;
        this.amount = 0.0f;
        this.type = null;
    }

    public Data(LocalDateTime date, float amount, String type) {
        this.date = date;
        this.amount = amount;
        this.type = type;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public float getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setType(String type) {
        this.type = type;
    }
}
