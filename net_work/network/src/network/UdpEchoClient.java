package network;
import java.io.IOException;
import java.net.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Scanner;

public class UdpEchoClient {
    private DatagramSocket socket=null;
    private String serverIp=null;
    private int serverPort=0;
    public UdpEchoClient(String serverIp,int serverPort) throws SocketException {
        socket=new DatagramSocket();
        this.serverIp=serverIp;
        this.serverPort=serverPort;
    }
    public void start() throws IOException {
        System.out.println("客户端启动!");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String request = scanner.next();
            if (request.equals("exit")) {
                System.out.println("goodbye");
                break;
            }
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(), request.getBytes().length, InetAddress.getByName(serverIp), serverPort);
            socket.send(requestPacket);
            DatagramPacket responsePacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(responsePacket);
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println(response);
        }
    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient client=new UdpEchoClient("127.0.0.1",9090);
        client.start();
    }

}
