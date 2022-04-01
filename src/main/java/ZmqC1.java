import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

import java.util.concurrent.TimeUnit;

public class ZmqC1 {
    public static void main(String[] args) {
        try(ZContext context = new ZContext()){
            ZMQ.Socket socket = context.createSocket(SocketType.PUSH);
            socket.bind("tcp://127.0.0.1:5555");



            while (true) {
                String response = "Hello, world!";
                socket.send(response);
                Thread.sleep(5000);
            }



        }catch (Exception e){
            System.out.println(e);
        }
    }
}

