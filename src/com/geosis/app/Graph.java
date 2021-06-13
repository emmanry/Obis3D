package com.geosis.app;

import com.geosis.api.loader.LoaderZoneSpecies;
import com.geosis.api.object.ZoneSpecies;
import com.geosis.api.response.ApiZoneSpeciesResponse;
import javafx.scene.Node;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;

public class Graph {

    private static final LineChart.Series series = new LineChart.Series<>();
    private static NumberAxis xAxis = new NumberAxis(0, 0, 5);
    private static NumberAxis yAxis = new NumberAxis(0, 0, 0);
    private static AreaChart chart = new AreaChart(xAxis, yAxis);
    private static int minY = 0;
    private static int maxY = 0;
    private static int tickUnit = 0;


    /**
     * Initialisation des valeurs de Y pour avoir une échelle adapter
     */
    public static void initGraph(){

        minY = 0;
        maxY = 0;

    }

    /**
     * Crée un nouveau point sur un graphe créé pour
     * @see #createGraph(Pane, String, int, int, int, int, XYChart.Series)
     * @param parent
     * @param loaderZoneSpecies
     * @param name
     * @param currentYear
     */
    public static void createPoint(Pane parent, LoaderZoneSpecies loaderZoneSpecies, String name, int currentYear, int yearStart, int yearEnd){

        ApiZoneSpeciesResponse apiZoneSpeciesResponse = loaderZoneSpecies.getZoneSpeciesByTime(name, currentYear, currentYear);

        int value = 0;
        for (ZoneSpecies zoneSpecies : apiZoneSpeciesResponse.getData()) {
            value += zoneSpecies.getNbSignals();
        }
        if (value > maxY) {
            maxY = value;
        }
        if (value < minY) {
            minY = value;
        }

        final LineChart.Data data = new LineChart.Data(currentYear, value);
        series.getData().add(data);

        createGraph(parent, name, yearStart, yearEnd, minY, maxY, series);

    }

    /**
     * Crée le graphique
     * @see #createGraph(Pane, String, int, int, int, int, XYChart.Series)
     * @param parent
     * @param name
     * @param yearStart
     * @param yearEnd
     * @param minY
     * @param maxY
     * @param series
     */
    public static void createGraph(Pane parent, String name, int yearStart, int yearEnd, int minY, int maxY, XYChart.Series series) {

        // supprimer le graphe d'avant s'il y en a un
        if (parent.getChildren().get(parent.getChildren().size() - 1) instanceof AreaChart) {
            parent.getChildren().remove(parent.getChildren().size() - 1);
        }

        // Création des séries.
        final int minX = yearStart;
        final int maxX = yearEnd;

        // Création du graphique.
        xAxis.setLowerBound(yearStart);
        xAxis.setUpperBound(yearEnd);
        xAxis.setLabel("Year");

        yAxis.setLabel("Number of signalements");
        tickUnit = (maxY  -minY) / 8;
        yAxis.setLowerBound(minY);
        yAxis.setUpperBound(maxY);
        yAxis.setTickUnit(tickUnit);

        chart.setTitle(name);
        chart.setLegendVisible(false);
        chart.setMaxHeight(290);

        chart.getData().setAll(series);

        chart.getStylesheets().add("com.geosis.app.styleSheet.css");

        parent.getChildren().add(chart);

    }

}
