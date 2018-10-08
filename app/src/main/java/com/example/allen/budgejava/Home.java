package com.example.allen.budgejava;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Home extends AppCompatActivity {

    private float[] spent = {100, 200, 300};
    private String[] categories = {"Entertainment", "Groceries", "Transport"};
    PieChart pie;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Data data1 = new Data();
        data1.setAmount(11.02);
        data1.setType("Entertainment");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime current = LocalDateTime.now();
        dtf.format(current);
        data1.setDate(current);

        Data data2 = new Data();
        data2.setAmount(14.56);
        data2.setType("Dining");
        dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        current = LocalDateTime.now();
        dtf.format(current);
        data2.setDate(current);

        //pie = (PieChart) findViewById(R.id);

        /*
        pieChart.setDescription("Sales by employee (In Thousands $) ");
        pieChart.setRotationEnabled(true);
        //pieChart.setUsePercentValues(true);
        //pieChart.setHoleColor(Color.BLUE);
        //pieChart.setCenterTextColor(Color.BLACK);
        pieChart.setHoleRadius(25f);
        pieChart.setTransparentCircleAlpha(0);
        pieChart.setCenterText("Super Cool Chart");
        pieChart.setCenterTextSize(10);
        //pieChart.setDrawEntryLabels(true);
        //pieChart.setEntryLabelTextSize(20);
        */

        addDataSet();

    }

    private void addDataSet()
    {
        ArrayList<PieEntry> yVar = new ArrayList<>();
        ArrayList<String> xVar = new ArrayList<>();

        for(int i = 0; i < spent.length; i++){
            //yVar.add(new PieEntry(yVar[i] , i));
        }

        for(int i = 1; i < categories.length; i++){
            xVar.add(categories[i]);
        }

        //create the data set
        PieDataSet pieDataSet = new PieDataSet(yVar, "Employee Sales");
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueTextSize(12);

        //add colors to dataset
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
        //Legend legend = pieChart.getLegend();
        //legend.setForm(Legend.LegendForm.CIRCLE);
        //legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART);

        //create pie data object
        //PieData pieData = new PieData(pieDataSet);
        //pieChart.setData(pieData);
        //pieChart.invalidate();
    }
}
