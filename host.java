import java.net.ServerSocket;
import java.net.Socket;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.IOException;

class host
{
    public static void main(String srgs[])
    {   
        try{
            ServerSocket serverSocket = new ServerSocket(0);
            System.out.println("I'm waiting here: "+serverSocket.getLocalPort());            
            //port fix
            
            Socket socket = serverSocket.accept();
            System.out.println("from " + 
                socket.getInetAddress() + ":" + socket.getPort());
            
            OutputStream outputStream = socket.getOutputStream();
            PrintStream printStream = new PrintStream(outputStream);
            
            //picture
            printStream.print("Hello Raspberry Pi");
            printStream.close();
            
            socket.close();
        }catch(IOException e){
            System.out.println(e.toString());
        }
        
    }
}
