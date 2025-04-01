import java.io.Serializable;

public class ParametriCSV implements Serializable {
    private String regione;
    private String provincia;
    private String comune;
    private int longitudine;
    private int latitudine;

    public ParametriCSV(String regione, String provincia, String comune, int longitudine, int latitudine) {
        this.regione = regione;
        this.provincia = provincia;
        this.comune = comune;
        this.longitudine = longitudine;
        this.latitudine = latitudine;
    }
}
