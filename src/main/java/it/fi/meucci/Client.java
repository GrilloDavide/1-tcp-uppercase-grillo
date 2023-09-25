package it.fi.meucci;


import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main( String[] args ) throws IOException {
        
        Scanner inputTastiera = new Scanner(System.in);
                
        System.out.println( " Connessione effettuataada" );
      
        Socket mioSocket = new Socket( InetAddress.getLocalHost() , 52453);
      
        DataOutputStream outServer = new DataOutputStream(mioSocket.getOutputStream());
        Scanner inServer = new Scanner (new InputStreamReader(mioSocket.getInputStream()));
        
        String stringa = inputTastiera.nextLine();
        outServer.writeBytes(stringa+"\n");
        System.out.println(inServer.nextLine());
        System.out.println(inServer.nextLine());
        mioSocket.close();
    }
}