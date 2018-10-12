

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
 
public class ClientUDP
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        DatagramSocket ds = new DatagramSocket();
        InetAddress ip = InetAddress.getLocalHost();
        byte buf[] = null;
 
        while (true)
        {
            System.out.println("Enter operation below: ");
            String inp = sc.nextLine();
            buf = new byte[1024];
            buf = inp.getBytes();
            DatagramPacket DpSend =new DatagramPacket(buf, buf.length, ip, 1652);
            ds.send(DpSend);
            if (inp.equals("End Calculations please"))
                break;
            buf = new byte[1024];
            DatagramPacket DpReceive =new DatagramPacket(buf, buf.length);
            ds.receive(DpReceive);
           String  result = (new String(buf,0,buf.length));
 
            System.out.println("Result is:  = " +new String(buf,0,buf.length));
            
        
            
        }
    }
}