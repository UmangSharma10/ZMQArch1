import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class ZmqBytePub1 {
    public static void main(String[] args) {
        try(ZContext context = new ZContext()){
            ZMQ.Socket socket = context.createSocket(SocketType.PUB);
            socket.bind("tcp://127.0.0.1:5555");
            String str = "ABC" +"Hello Wasssupppppp";
            String str1 = "V" + "Hii Vivek";
            byte[] bytes = str.getBytes();
            byte[] bytes1=str1.getBytes();

            while (true){
                socket.send(bytes1);
                socket.send( bytes);

                Thread.sleep(1000);
            }



        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
