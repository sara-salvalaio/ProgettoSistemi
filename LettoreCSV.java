import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LettoreCSV {
    ArrayList<String> file = new ArrayList<>();
    public LettoreCSV(){
        leggiFile();

    }

    public void leggiFile(){
        try(BufferedReader br = new BufferedReader(new FileReader("ProgettoSistemi "))) {
            String linea;
            while((linea = br.readLine()) != null){
                String[] dataFeatures = linea.split(";");
                ParametriCSV parametriCSV = new ParametriCSV();
                ParametriCSV.
            }
        } catch(IOException e){
            e.printStackTrace();
        }

    }
}
