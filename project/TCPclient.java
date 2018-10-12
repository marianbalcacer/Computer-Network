import java.io.*;
import java.net.*;
import java.util.*;
 
public class TCPclient
{
    @SuppressWarnings("resource")
	public static void main(String[] args) throws IOException
    {
        InetAddress ip = InetAddress.getLocalHost();
        int port = 4222;
        Scanner sc = new Scanner(System.in);
 
        
        Socket so = new Socket(ip, port);
 
        DataInputStream Is = new DataInputStream(so.getInputStream());
        DataOutputStream Os = new DataOutputStream(so.getOutputStream());
 
        while (true)
        {
            System.out.println("Input an Arithmetic Equation: ");
            
            String in = sc.nextLine();
 
            if (in.equals("End"))
                break;
 
            
            Os.writeUTF(in);
 
            String ans = Is.readUTF();
            System.out.println("Result = " + ans);
        }
    }
}
