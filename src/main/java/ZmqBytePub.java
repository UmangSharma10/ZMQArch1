import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

import java.util.Arrays;

public class ZmqBytePub {
    public static void main(String[] args) {
        try(ZContext context = new ZContext()){
            ZMQ.Socket socket = context.createSocket(SocketType.PUB);
            socket.bind("tcp://127.0.0.1:5555");
            String str = "A" +"Hello Wasssupppppp";
            byte[] bytes = str.getBytes();

            while (true){
               socket.send( bytes);

               Thread.sleep(1000);
            }



        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
