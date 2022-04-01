import org.zeromq.SocketType;
import org.zeromq.ZMQ;
import org.zeromq.ZContext;
import zmq.socket.clientserver.Server;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class ZmqServer
{
    public static void main(String[] args) {
        try(ZContext context = new ZContext()){
            ZMQ.Socket socket = context.createSocket(SocketType.PUSH);
            socket.bind("tcp://127.0.0.1:5555");

            String str = "Hello this is Umang Sharma";
            byte[] b = str.getBytes();
          //  String response = Arrays.toString(b);


              /*  for(i = 0; i<=100; i++){
                    socket.send(String.valueOf(i));
                    Thread.sleep(5000);
                }*/

            while (true) {

                socket.send(b);
                Thread.sleep(5000);
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }
    }