package TCPServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpEchoServer {
    private ServerSocket serverSocket=null;
    public TcpEchoServer(int port) throws IOException {
serverSocket=new ServerSocket(port);
    }
    public void start() throws IOException {
        System.out.println("启动服务器");
        ExecutorService threadPool= Executors.newCachedThreadPool();
        while (true){
            Socket clientSocket=serverSocket.accept();
            threadPool.submit(()->{
                processConnection(clientSocket);
            });
        }
    }
    private void processConnection(Socket clientSocket){
        System.out.printf("[%s:%d] 客户端上线!\n", clientSocket.getInetAddress().toString(), clientSocket.getPort());
        try(InputStream inputStream=clientSocket.getInputStream(); OutputStream outputStream=clientSocket.getOutputStream()){
            while (true){
                Scanner scanner=new Scanner(inputStream);
                String request=scanner.next();
               String response= process(request);
                PrintWriter printWriter=new PrintWriter(outputStream);
                printWriter.println(response);
                printWriter.flush();
                System.out.printf("[%s:%d] req: %s; resp: %s \n", clientSocket.getInetAddress().toString(), clientSocket.getPort(),
                        request, response);
            }
        }
    catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private String process(String request){
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer server=new TcpEchoServer(9090);
        server.start();
    }
}
