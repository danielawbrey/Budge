package com.example.allen.budgejava;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.allen.budgejava.objects.Data;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Home extends AppCompatActivity {

    //private float[] spent = {100, 200, 300};
    //private String[] categories = {"Entertainment", "Groceries", "Transport"};
    PieChart pie;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Data data1 = new Data();
        data1.setAmount(11.02f);
        data1.setType("Entertainment");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime current = LocalDateTime.now();
        dtf.format(current);
        data1.setDate(current);

        Data data2 = new Data();
        data2.setAmount(14.56f);
        data2.setType("Dining");
        dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        current = LocalDateTime.now();
        dtf.format(current);
        data2.setDate(current);

        pie = (PieChart) findViewById(R.id.idPieChart);
        Description des = new Description();
        des.setText("Money Spent");

        pie.setDescription(des);
        pie.setRotationEnabled(true);
        pie.setUsePercentValues(true);
        pie.setHoleColor(Color.WHITE);
        pie.setCenterTextColor(Color.BLACK);
        pie.setHoleRadius(25f);
        pie.setTransparentCircleAlpha(0);
        pie.setCenterText("Super Cool Chart");
        pie.setCenterTextSize(10);
        pie.setDrawEntryLabels(true);
        pie.setEntryLabelTextSize(20);


        ArrayList<PieEntry> yVar = new ArrayList<>();
        ArrayList<String> xVar = new ArrayList<>();

        yVar.add(new PieEntry(data1.getAmount(), 1));
        yVar.add(new PieEntry(data2.getAmount(), 2));

        xVar.add(data1.getType());
        xVar.add(data2.getType());

        //create the data set
        PieDataSet pieDataSet = new PieDataSet(yVar, "Budget");
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueTextSize(12);

        //add colors to data set
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.GRAY);
        colors.add(Color.BLUE);
        colors.add(Color.RED);
        colors.add(Color.GREEN);
        colors.add(Color.CYAN);
        colors.add(Color.YELLOW);
        colors.add(Color.MAGENTA);

        pieDataSet.setColors(colors);

        //add legend to chart
        Legend legend = pie.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART);

        //create pie data object
        PieData pieData = new PieData(pieDataSet);
        pie.setData(pieData);
        pie.invalidate();

    }
}
