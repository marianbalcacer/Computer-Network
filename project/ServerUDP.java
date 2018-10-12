
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.StringTokenizer;
 
public class ServerUDP
{
    public static void main(String[] args) throws Exception
    {
        DatagramSocket ds = new DatagramSocket(1652);
        byte[] buf = null;
        DatagramPacket DpReceive = null;
        DatagramPacket DpSend = null;
        while (true)
        {
            buf = new byte[1024];
            DpReceive = new DatagramPacket(buf, buf.length);
            ds.receive(DpReceive);
 
            String inp = new String(buf, 0, buf.length);
            inp=inp.trim();
            System.out.println("Equation Received: " + inp);
            if (inp.equals("End Calculation Please"))
            {
            int result;
            StringTokenizer st = new StringTokenizer(inp);
            int ipt1 = Integer.parseInt(st.nextToken());
            String operation = st.nextToken();
            int ipt2 = Integer.parseInt(st.nextToken());
            
            if (operation.equals(" + "))
                result = ipt1 + ipt2;
 
            else if (operation.equals(" - "))
                result = ipt1 - ipt2;
 
            else if (operation.equals(" * "))
                result = ipt1 * ipt2;
 
            else
                result = ipt1 / ipt2;
            String res = Integer.toString(result);
 
            
            buf = res.getBytes();
 
            int num = DpReceive.getPort();
 
            DpSend = new DatagramPacket(buf, buf.length,
                          InetAddress.getLocalHost(), num);
            ds.send(DpSend);
        }
    }
}
}