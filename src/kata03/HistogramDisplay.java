package kata03;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;


public class HistogramDisplay extends ApplicationFrame{
    private final Histogram<String> histogram;
    
    public HistogramDisplay(Histogram<String> histogram){
        super("HISTOGRAM");
        this.histogram = histogram;
        this.setContentPane(createPanel());
        this.pack();
    }
    
    public void execute(){
        setVisible(true);
    }
    
    private JPanel createPanel(){
        ChartPanel chartpanel = new ChartPanel(createChart(createDataSet()));
        chartpanel.setPreferredSize(new Dimension(500,400));
        
        return chartpanel;
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataset){
        JFreeChart chart = ChartFactory.createBarChart("Histogram JFreeChart",
                                                        "Dominios email",
                                                        "Nº de emails",
                                                        dataset,
                                                        PlotOrientation.VERTICAL,
                                                        false,
                                                        false,
                                                        rootPaneCheckingEnabled);
        
        return chart;
    }
    
    private DefaultCategoryDataset createDataSet(){
        DefaultCategoryDataset dataset =  new DefaultCategoryDataset();
        
        for (String key : histogram.ketSet()) {
            dataset.addValue(histogram.get(key), "", key);
        }
        
        /*dataset.addValue(300, "", "ulpgc.es");
        dataset.addValue(300, "", "dis.ulpgc.es");
        dataset.addValue(700, "", "gmail.com");
        */
        return dataset;
    }
}
