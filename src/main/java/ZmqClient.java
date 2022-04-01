import org.zeromq.SocketType;
import org.zeromq.ZMQ;
import org.zeromq.ZContext;

import java.nio.charset.StandardCharsets;

public class ZmqClient
{
    public static void main(String[] args) {


try(ZContext context = new ZContext()){
    ZMQ.Socket socket = context.createSocket(SocketType.PULL);
    socket.connect("tcp://127.0.0.1:5555");


    while (true) {

        String response = socket.recvStr();
        byte[] bytes = response.getBytes();
        String s = new String(bytes, StandardCharsets.UTF_8);

        System.out.println("Server " + s);
    }



}catch (Exception e){
    System.out.println(e);
}
}
}
