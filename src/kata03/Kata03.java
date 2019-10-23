package kata03;

public class Kata03 {
    public static void main(String[] args) {
        Histogram<String> histogram = new Histogram<>();
        histogram.increment("gmail.com");
        histogram.increment("ulpgc.es");
        histogram.increment("gmail.com");
        histogram.increment("dis.ulpgc.es");
        histogram.increment("gmail.com");
        histogram.increment("dis.ulpgc.es");
        
        HistogramDisplay histogramdisplay = new HistogramDisplay(histogram);
        histogramdisplay.execute();
    }
    
}
