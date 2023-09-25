package it.fi.meucci;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server 
{
    public static void main( String[] args ) throws IOException
    {
        Scanner inputTastiera = new Scanner(System.in);

        System.out.println( " Server attivo" );

        Socket client;

        ServerSocket server = new ServerSocket(52453);

        System.out.println( " Server in attesa di un client " );
        client = server.accept();

        System.out.println( client.getInetAddress() + " Si è connesso");
        DataOutputStream outClient = new DataOutputStream(client.getOutputStream());
        Scanner inClient = new Scanner (new InputStreamReader(client.getInputStream()));
        
        String stringa = inClient.nextLine();
        outClient.writeBytes(stringa.toUpperCase()+", Ricevuto"+"\n");
        

        outClient.writeBytes("Chiudo "+"\n");
        System.out.println("Termine connessione");
        client.close();



    }
}
