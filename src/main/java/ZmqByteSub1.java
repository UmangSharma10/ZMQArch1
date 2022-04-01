import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

import java.nio.charset.StandardCharsets;

public class ZmqByteSub1 {
    public static void main(String[] args) {
        try (ZContext context = new ZContext()){
            ZMQ.Socket socket = context.createSocket(SocketType.SUB);
            socket.connect("tcp://127.0.0.1:5555");

            socket.subscribe("V");
            while (true) {
                //String response = socket.recvStr();
                byte[] bytes = socket.recv(0);
                //  response.toString();
                //String s = new String(response);
                System.out.println("Server " + new String(bytes, ZMQ.CHARSET));
            }

        }
        catch (Exception E){
            System.out.println(E);
        }
    }
}
