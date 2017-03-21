package DistributedSystems;


import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Nikhil on 3/21/2017 2:54 AM.
 */
public class UDSEchoServer implements Runnable {

    static String SERVER_SOCKET_PATH = "./socket";
    Socket socket;

    UDSEchoServer(Socket socket) {
        this.socket = socket;
    }

    public static void main(String[] args) throws Exception {
        try {
            File socketFile = new File(SERVER_SOCKET_PATH);

            //AFUNIXServerSocket server = AFUNIXServerSocket.newInstance();
            //server.bind(new AFUNIXSocketAddress(socketFile));

            /*while (true) {
                Socket socket = server.accept();
                new Thread(new UDSEchoServer(socket)).start();
            }*/
        } catch (Exception e) {
        }
    }

    public void run() {
        try {
            InputStream is = this.socket.getInputStream();

            String s;
            byte[] buf = new byte[10000];
            int read;
            while ((read = is.read(buf)) != -1) {
                OutputStream os = this.socket.getOutputStream();
                os.write(buf, 0, read);
                os.flush();
            }
            this.socket.close();
        } catch (Exception e) {
        }
    }
}


/*
Example request 1:

Client 1:
Hello World
END
Example response 1:

Client 1:
Hello World
Example request 2:

Client 2:
This is line 1
This is line 2
END
Example response 2:

Client 2:
This is line 1
This is line 2
 */