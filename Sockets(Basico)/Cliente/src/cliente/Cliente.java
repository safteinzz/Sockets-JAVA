/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader ;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SaFteiNZz
 */
public class Cliente
{
    
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket s = new Socket( "127.0.0.1", 9797);
        InputStream entrada = s.getInputStream();
        BufferedReader lector = new BufferedReader( new InputStreamReader( entrada ) );
        System.out.println(lector.readLine());
        lector.close();
        s.close();
        
        
        Scanner scanner = new Scanner(System.in);                
        System.out.println("Presiona enter para cerrar");
        String cerrar = scanner.nextLine();  
    }
}
