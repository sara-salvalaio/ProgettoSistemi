
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private static List<String[]> csvData = new ArrayList<>();
    public static final int PORT = 1050; // porta al di fuori del range 1-1024 !

    public static void main(String[] args) throws IOException {
        loadCSV("mappa-dei-fari-in-italia.csv");

        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.format("Server in ascolto su: %s%n",
                    server.getLocalSocketAddress());

            // Il server accetta e serve un client alla volta
            while (true) {
                try (Socket client = server.accept()) {
                    String rem = client.getRemoteSocketAddress().toString();
                    System.out.format("Client (remoto): %s%n", rem);
                    comunica(client);
                } catch (IOException e) {
                    System.err.println(String.format("Errore durante la comunicazione con il client: %s", e.getMessage()));

                }
            }
        } catch (IOException e) {
            System.err.println(String.format("Errore server: %s", e.getMessage()));
        }
    }

    private static void comunica(Socket sck) throws IOException {
        ObjectInputStream in = new ObjectInputStream(sck.getInputStream());
        System.out.println("In attesa di ricevere informazioni dal client...");
        ParametriCSV ric = null;
        try {
        // Deserializzazione: ricevo una sequenza di byte e
        // la trasformo in un oggetto
            ric = (ParametriCSV) in.readObject();
        } catch (ClassNotFoundException e) {
            throw new IOException("Tipo di ricerca non supportata.");
        }
        System.out.format("Ricevuta dal client la ricerca: cognome = '%s' nome = '%s'%n", ric.cognome, ric.nome);
        Risultato ris = elabora(ric);
        ObjectOutputStream out = new ObjectOutputStream(sck.getOutputStream());
        out.writeObject(ris);
        System.out.println("Inviato al client il risultato della ricerca");
    }
    private static Risultato elabora(ParametriCSV r) {
        Risultato ris;
        boolean trovato;
        trovato = r.cognome.toUpperCase().equals("ROSSI") &&
                r.nome.toUpperCase().equals("MARIO");
        if (trovato == true) {
            ris = new Risultato("Rossi", "Mario", 10012, 1598.50);
        }
        else {
            ris = null;
        }
        return ris;
    }


        private static void loadCSV (String s){
        }


    }
