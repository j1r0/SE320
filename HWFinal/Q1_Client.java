/*
 * By: Jim Pamplona
 * 
 * Write a server program and a client program. The client sends the weight
 * and height for a person to the server. The server computes BMI (Body Mass Index) and
 * sends back to the client a string that reports the BMI. You can use the following formula
 * for computing BMI:
 * 
 * bmi = weightInKilograms / (heightInMeters * heightInMeters)
 */

package HWFinal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

public class Q1_Client {
    static double BMI;
    static double weightInKilograms = 65;
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