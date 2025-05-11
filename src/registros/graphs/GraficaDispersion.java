package registros.graphs;

import edlineal.ListaDinNumerica;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;

public class GraficaDispersion extends JFrame {

    public GraficaDispersion(ListaDinNumerica x,
                             ListaDinNumerica y,
                             String title,
                             String labelX,
                             String labelY
    ){
        // Creamos una serie de puntos
        XYSeries serie = new XYSeries("Casa");

        // Popular la usando la lista
        popularSerie(serie, x, y);

        // Conjunto de datos. Asi dice el framework
        XYSeriesCollection series = new XYSeriesCollection();
        series.addSeries(serie);

        // Creamos el grafico
        JFreeChart dispersionGraph = ChartFactory.createScatterPlot(
                title,
                labelX,
                labelY,
                series,
                PlotOrientation.VERTICAL,
                true,                    // Mostrar leyenda
                true,                    // Mostrar tooltips
                false                    // URLs
        );

        // Mostrar en un panel
        ChartPanel panel = new ChartPanel(dispersionGraph);
        setContentPane(panel);
    }

    // Este metodo agrega los valores de "x" y "y" a la serie de datos
    private void popularSerie(XYSeries serie, ListaDinNumerica x, ListaDinNumerica y){
        double valX;
        double valY;

        x.iniciaIterador();
        y.iniciaIterador();
        while (x.iteradorValido()){
            valX = (double) x.obtenerIterador();
            valY = (double) y.obtenerIterador();

            serie.add(valX, valY);

            x.moverIterador();
            y.moverIterador();
        }
    }

}
