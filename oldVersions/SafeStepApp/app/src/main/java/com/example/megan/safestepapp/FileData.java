package com.example.megan.safestepapp;
import android.graphics.Color;

import org.achartengine.model.XYSeries;

import java.io.IOException;
import java.util.ArrayList;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;


public class FileData {

    public static void main(String[] args) throws IOException{

        String file_name = "/home/megan/AndroidStudioProjects/SafeStepApp/app/src/main/java/com/example/megan/safestepapp/data.txt";

        try {
            ReadFile file = new ReadFile(file_name);
            String[] aryLines = file.OpenFile();

            int i;
            ArrayList<dataPoint> pointsList = new ArrayList<dataPoint>();
            for (i=0; i<aryLines.length; i++) {
                String[] parts = aryLines[i].split(" ");
                String x = parts[0];
                String y = parts[1];
                int xCoord = Integer.parseInt(x);
                int yCoord = Integer.parseInt(y);
                dataPoint point = new dataPoint(xCoord,yCoord);
                //system.out.println(aryLines[i]);
            }
            XYSeries series = new XYSeries("Some Points, Nigga");
            for(int counter = 0; counter < pointsList.size(); counter++){
                series.add(pointsList.get(counter).x, pointsList.get(counter).y);

            // Now we create the renderer
            XYSeriesRenderer renderer = new XYSeriesRenderer();
            renderer.setLineWidth(2);
            renderer.setColor(Color.RED);

            // we add point markers
            renderer.setPointStyle(PointStyle.CIRCLE);

            XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();
            mRenderer.addSeriesRenderer(renderer);

            mRenderer.setYAxisMax(35);
            mRenderer.setYAxisMin(0);
            mRenderer.setShowGrid(true); // we show the grid

            GraphicalView chartView = ChartFactory.getLineChartView(getActivity(), dataset, mRenderer);}

            chartLyt.addView(chartView,0);



        }
        catch (IOException e) {
            System.out.println( e.getMessage() );
        }



    }

}