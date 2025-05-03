import java.net.*;
import java.io.*;

public class Client {
    private static final String SERVER = "127.0.0.1";
    private static final int PORT = 8080;

    public static void main(String[] args){
        try(Socket socket = new Socket(SERVER, PORT);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in))
        ) {
            System.out.println("Connesso al server Faro.");
            System.out.println("Comandi disponibili:");
            System.out.println("SEARCH_COMUNE <nome_comune>");
            System.out.println("SEARCH_POSITION <longitudine> <latitudine>");
            System.out.println("CTRL+C per uscire");

            String userInput;
            while ((userInput = console.readLine()) != null) {
                output.println(userInput);
                String response;
                while ((response = input.readLine()) != null && !response.isEmpty()) {
                    System.out.println(response);
                    if (!input.ready()) break;
                }
            }
        } catch (IOException e) {
            System.err.println("Errore di connessione: " + e.getMessage());
        }
    }
}


