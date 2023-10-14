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
    public static void main( String[] args ) {

        try {
            System.out.println("Il client è partito!");
            Socket s = new Socket("localhost", 3000);

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            System.out.println(in.readLine());

            Scanner scanner = new Scanner(System.in);

            int risposta;
            do {
                System.out.print("Inserisci un numero: ");
                int numero = scanner.nextInt();
                out.writeBytes(String.valueOf(numero) + '\n');

                risposta = Integer.parseInt(in.readLine());
                
                if (risposta == 1) 
                    System.out.println("Il numero e' troppo piccolo");
                else if (risposta == 2)
                    System.out.println("Il numero e' troppo grande");

            } while (risposta != 3);

            System.out.println("Bravo hai indovinato");

            s.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("C'è stato un errore nella fase di connessione");
            System.exit(1);
        }

    }
}
