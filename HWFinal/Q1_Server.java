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
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;


public class Q1_Server {
    
    public static void main(String[] args) {
        int port = 8000;
        DataInputStream in;
        DataOutputStream out;
        ServerSocket server;
        Socket socket;
        try {
            server = new ServerSocket(port);
            socket = server.accept();

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            System.out.println("Received weight and height.\n");
            double weightInKilograms = in.readDouble();
            double heightInMeters = in.readDouble();
            System.out.println("Weight (kg): \n" + weightInKilograms);
            System.out.println("Height (m): \n" + heightInMeters);

            System.out.println("Calculating BMI...\n");
            double BMI = weightInKilograms / (heightInMeters * heightInMeters);
            System.out.println("BMI calculated. Sent to client.");

            out.writeDouble(BMI);
            server.close();
        } catch (BindException e) {
            System.out.println("Address in use.");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
}

