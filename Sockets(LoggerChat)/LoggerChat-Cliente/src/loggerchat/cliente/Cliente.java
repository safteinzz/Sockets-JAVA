//clientes entrada de texto infinita, enviar entrada de texto y nombre del cliente al servidor
package loggerchat.cliente;

import java.util.Scanner;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SaFteiNZz
 */
public class Cliente {
   
    private static String getHora() {
        GregorianCalendar calendario = new GregorianCalendar();
        Date date = calendario.getTime();
        DateFormat hora = DateFormat.getTimeInstance( DateFormat. SHORT );
        return hora.format( date );
    }
    
    public static void main(String[] args) throws UnknownHostException, IOException {
        String username;
        
        Scanner scanner = new Scanner(System.in);
        
        
        System.out.println("Elige nombre de usuario:");
        username = scanner.nextLine();   
        while(true){   
            Socket socket = new Socket( "127.0.0.1", 9797);
            PrintWriter escritor = new PrintWriter(socket.getOutputStream());
            System.out.println("Introduce mensaje: ");
            String entradaCliente = scanner.nextLine(); 
            escritor.println("[" + getHora() + "] " + username + ": " + entradaCliente);
            escritor.close();
        }
    }   
}
