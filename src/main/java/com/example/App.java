package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try{
            System.out.println( "Il client e' partito!" );
            Socket s = new Socket("localhost", 3000);

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            Scanner scanner = new Scanner(System.in);

            int nRicevuto;
            out.writeBytes(scanner.nextLine() + "\n");

            do{
                nRicevuto = Integer.parseInt(in.readLine());
                if(nRicevuto == 1)
                    System.out.println("Il numero e' troppo piccolo");
                else if(nRicevuto == 2)
                    System.out.println("Il numero e' troppo grande");
                out.writeBytes(scanner.nextLine() + "\n");
            }while(nRicevuto!=3);

        } catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("C'e' stato un errore nella fase di connessione");
            System.exit(1);
        }
    }
}
