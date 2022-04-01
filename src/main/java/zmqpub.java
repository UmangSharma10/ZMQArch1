import java.util.Random;

import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;
import org.zeromq.ZMQ.Socket;


//  Pathological publisher
//  Sends out 1,000 topics and then one random update per second
public class zmqpub
{
    public static void main(String[] args) {
        try(ZContext context = new ZContext()){
            ZMQ.Socket socket = context.createSocket(SocketType.PUB);
            socket.bind("tcp://127.0.0.1:5555");

            for(int i=0;i<100;i++)
            {
                socket.send("A" + "umang is here ");
                socket.send("AAB" + "Umang is here and well");
                Thread.sleep(3000);
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
