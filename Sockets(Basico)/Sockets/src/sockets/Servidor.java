/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

import java.io.IOException;
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
public class Servidor implements Runnable {
    
    Socket multiSocket;
    
    Servidor(Socket aux){
        this.multiSocket = aux;
    }
    
    public static final int puerto = 9797;
    
    private static String darHora() {
        GregorianCalendar calendario = new GregorianCalendar();
        Date date = calendario.getTime();
        DateFormat hora = DateFormat.getTimeInstance( DateFormat. SHORT );
        return hora.format( date );
    }
    
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
            PrintWriter escritor = new PrintWriter(multiSocket.getOutputStream());
            escritor.println(darHora());
            escritor.close();
            multiSocket.close(); 
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
}
