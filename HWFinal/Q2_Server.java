/*
 * By: Jim Pamplona
 * 
 * Revise the server program in Question-1 using threads to allow multiple
 * clients.
 * 
 * Use Q1_Client and Q2_Client to test this revised server.
 */

package HWFinal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.BindException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Q2_Server {

    public static void main(String[] args) {
        int port = 8000;
        DataInputStream in;
        DataOutputStream out;
        ServerSocket server;
        Socket socket;
        int numClients = 0;
        try {
            server = new ServerSocket(port);
            while (true) {
                numClients++;

                socket = server.accept();
                Thread thread = new Thread();
                thread.start();

                InetAddress inetAddress = socket.getInetAddress();
                System.out.println("Client " + numClients + " has connected with the address: "
                        + inetAddress.getHostAddress() + "\n");
                        
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());

                System.out.println("Received weight and height. \n");
                double weightInKilograms = in.readDouble();
                double heightInMeters = in.readDouble();
                System.out.println("Weight (kg): " + weightInKilograms);
                System.out.println("Height (m): \n" + heightInMeters);

                System.out.println("Calculating BMI...");
                double BMI = weightInKilograms / (heightInMeters * heightInMeters);
                System.out.println("BMI calculated. Sent to client.");

                out.writeDouble(BMI);
            }
        } catch (BindException e) {
            System.out.println("Address in use.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
