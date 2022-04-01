import java.util.Random;

import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;
import org.zeromq.ZMQ.Socket;

//  Pathological subscriber
//  Subscribes to one random topic and prints received messages
public class ZmqSub
{
    public static void main(String[] args) {


        try(ZContext context = new ZContext()){
            ZMQ.Socket socket = context.createSocket(SocketType.SUB);
            socket.connect("tcp://127.0.0.1:5555");

            socket.subscribe("B");
            while (true) {
                String response = socket.recvStr();

                System.out.println("Server " + response);
            }



        }catch (Exception e){
            System.out.println(e);
        }
    }
}