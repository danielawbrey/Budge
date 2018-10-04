package com.example.allen.budgejava;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import java.util.ArrayList;

public class Home extends AppCompatActivity {

    private float[] spent = {100, 200, 300};
    private String[] categories = {"Entertainment", "Groceries", "Transport"};
    PieChart pie;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        pie = (PieChart) findViewById(R.id.chart);
       // pie.setDescription("Sales by employee (In Thousands $) ");
        pie.setRotationEnabled(true);
        //pie.setUsePercentValues(true);
        //pie.setHoleColor(Color.BLUE);
        //pie.setCenterTextColor(Color.BLACK);
        pie.setHoleRadius(25f);
        pie.setTransparentCircleAlpha(0);
        pie.setCenterText("Super Cool Chart");
        pie.setCenterTextSize(10);
        //pie.setDrawEntryLabels(true);
        //pie.setEntryLabelTextSize(20);


        addDataSet();

        pie.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                int pos1 = e.toString().indexOf("(sum): ");
                String sales = e.toString().substring(pos1 + 7);

                for(int i = 0; i < spent.length; i++){
                    if(spent[i] == Float.parseFloat(sales)){
                        pos1 = i;
                        break;
                    }
                }
                String employee = categories [pos1 + 1];
                Toast.makeText(Home.this, "Employee " + employee + "\n" + "Sales: $" + sales + "K", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected() {

            }
        });




    }

    private void addDataSet()
    {
        ArrayList<PieEntry> yVar = new ArrayList<>();
        ArrayList<String> xVar = new ArrayList<>();

        for(int i = 0; i < spent.length; i++){
            yVar.add(new PieEntry(spent[i], i));
        }

        for(int i = 1; i < categories.length; i++){
            xVar.add(categories[i]);
        }

        //create the data set
        PieDataSet pieDataSet = new PieDataSet(yVar, "Employee Sales");
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
