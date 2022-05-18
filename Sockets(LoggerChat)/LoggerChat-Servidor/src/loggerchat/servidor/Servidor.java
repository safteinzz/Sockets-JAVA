//servidor agrega hora y lo muestra por su output ([hora:minuto]nombre: texto)\n
package loggerchat.servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author SaFteiNZz
 */
public class Servidor implements Runnable{

    Socket multiSocket;
    
    Servidor(Socket aux){
        this.multiSocket = aux;
    }
    
    public static final int puerto = 9797;
    
    
    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(puerto);
        
        while(true) {
            Socket aux = servidor.accept();
            new Thread(new Servidor(aux)).start();
        }
    }
    
    @Override
    public void run(){
        try {
            InputStream entrada = multiSocket.getInputStream();
            BufferedReader lector = new BufferedReader( new InputStreamReader( entrada ) );
            System.out.println(lector.readLine());
            lector.close();
            multiSocket.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
    } 
}
