/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Yefri13092023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;

public class MyClient {
    public static void main(String args[]) {
        try {
            Socket client = new Socket(InetAddress.getLocalHost(), 1234);
            InputStream clientIn = client.getInputStream();
            OutputStream clientOut = client.getOutputStream();
            PrintWriter pw = new PrintWriter(clientOut, true);
            BufferedReader br = new BufferedReader(new InputStreamReader(clientIn));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            // Perulangan tak terbatas untuk menerima input dari pengguna
            while (true) {
                System.out.println("Type a message for the server (or 'exit' to quit): ");
                String userInput = stdIn.readLine();

                // Jika pengguna memasukkan 'exit', keluar dari perulangan
                if (userInput.equalsIgnoreCase("exit")) {
                    break;
                }

                // Kirim pesan ke server
                pw.println(userInput);

                // Tampilkan pesan dari server
                String serverMessage = br.readLine();
                System.out.println("Server message: " + serverMessage);
            }

            // Tutup semua sumber daya
            pw.close();
            br.close();
            client.close();
        } catch (ConnectException ce) {
            System.out.println("Cannot connect to the server.");
        } catch (IOException ie) {
            System.out.println("I/O Error.");
        }
    }
}
