package com.example.allen.budgejava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;

public class Home extends AppCompatActivity {

    private float[] spent = {100, 200, 300};
    private String[] categories = {"Entertainment", "Groceries", "Transport"};
    PieChart pie;

///testing beep boop

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        pie = (PieChart) findViewById(R.id.idPieChart);

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
            yVar.add(new PieEntry(yVar[i] , i));
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
        Legend legend = pieChart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART);

        //create pie data object
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();
    }
}
