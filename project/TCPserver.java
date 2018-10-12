
import java.io.*;
import java.net.*;
import java.util.*;
 
public class TCPserver
{
    @SuppressWarnings("resource")
	public static void main(String args[]) throws IOException
    {
 
        // Step 1: Establish the socket connection.
        ServerSocket ss = new ServerSocket(4222);
        Socket so = ss.accept();
 
        // Step 2: Processing the request.
        DataInputStream Is = new DataInputStream(so.getInputStream());
        DataOutputStream Os = new DataOutputStream(so.getOutputStream());
 
        while (true)
        {
            String input = Is.readUTF();
 
            if(input.equals("End"))
                break;
 
            System.out.println("Equation received: " + input);
            int result;
 
            StringTokenizer st = new StringTokenizer(input);
 
            int no1 = Integer.parseInt(st.nextToken());
            String oper = st.nextToken();
            int no2 = Integer.parseInt(st.nextToken());
 
            if (oper.equals("+"))
            {
                result = no1 + no2;
            }
 
            else if (oper.equals("-"))
            {
                result = no1 - no2;
            }
            else if (oper.equals("*"))
            {
                result = no1 * no2;
            }
            else
            {
                result = no1 / no2;
            }
            System.out.println("Sending result");
           
 
            // send the result back to the client.
            Os.writeUTF(Integer.toString(result));
            System.out.println(result);
        }
    }
}

