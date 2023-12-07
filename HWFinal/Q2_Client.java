/*
 * By: Jim Pamplona
 * 
 * Revise the server program in Question-1 using threads to allow multiple
 * clients.
 * 
 * THIS CLASS IS TO TEST MULTIPLE CLIENTS IN ONE SERVER
 * Use this along with Q1_Client to test the Server class.
 */

package HWFinal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

public class Q2_Client {
    static double BMI;
    static double weightInKilograms = 73;
    static double heightInMeters = 1.7;
    public static void main(String[] args) throws IOException {
        
         int port = 8000;
        String host = "localhost";
        DataInputStream in;
        DataOutputStream out;
        Socket socket;

        try {
    
        socket = new Socket(host, port);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());

        System.out.println("Sending weight and height...\n");
        out.writeDouble(weightInKilograms);
        out.writeDouble(heightInMeters);

        System.out.println("Received BMI!");
        System.out.println("BMI: " + in.readDouble());

        socket.close();
        } catch (ConnectException e) {
            System.out.println("Another client is already connected.");
        }
        catch(IOException e) {
            System.out.println("Could not connect to server.");
        }
    }
}