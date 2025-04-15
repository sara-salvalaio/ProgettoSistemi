import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Thread{
    private Socket socket;
    public ClientHandler(Socket Socket) {
        this.socket = socket;
    }

    public void run() {
        try(
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true)){
            String inputLine;
            while((inputLine = br.readLine()) != null){
                String response = handleRequest(inputLine);
                pw.println(response);
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    private String handleRequest(String request) {
        String[] parts = request.split(" ");
        if(parts.length == 0) return "ERROR";

        switch(parts[0]){
            case "SEARCH_COMUNE":
            if(parts.length < 2) return "ERROR: comune mancante";
            return serachByComune(request.substring("SEARCH_COMUNE".length()));

            case "SEARCH_POSITION":

        }
        return request;
    }

    private String serachByComune(String substring) {
        return null;
    }


}
