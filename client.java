import java.net.Socket;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.UnknownHostException;

class client{

    public static void main(String args[])
    { 
        if(args.length == 0){
            System.out.println("usage: java client <port>");
            System.exit(1);
        }
        
        int port = isParseInt(args[0]);
        if(port == -1){
            System.out.println("usage: java client <port>");
            System.out.println("<port>: integer");
            System.exit(1);
        }
        
        try{
            //IP is hard coded
            //port is user entry
            Socket socket = new Socket("169.524.174.4", port);
            InputStream inputStream = socket.getInputStream();
            
            ByteArrayOutputStream byteArrayOutputStream = 
                new ByteArrayOutputStream(1024);
            byte[] buffer = new byte[1024];

            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1){
                byteArrayOutputStream.write(buffer, 0, bytesRead);
            }
                
            socket.close();
        
            System.out.println(byteArrayOutputStream.toString("UTF-8"));
            
        }catch(UnknownHostException e){
            System.out.println(e.toString());
        }catch(IOException e){
            System.out.println(e.toString());
        }

    }


    private static int isParseInt(String str){
        
        int num = -1;
        try{
             num = Integer.parseInt(str);
        } catch (NumberFormatException e) {
        }
        
        return num;
    }
    
}
