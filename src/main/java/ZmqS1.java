import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

public class ZmqS1 {
    public static void main(String[] args) {
        try(ZContext context = new ZContext()){
            ZMQ.Socket socket = context.createSocket(SocketType.PULL);
            socket.connect("tcp://127.0.0.1:5555");


            while (true) {
                String response = socket.recvStr();
                System.out.println("Client " + response);
            }



        }catch (Exception e){
            System.out.println(e);
        }
    }
    }

