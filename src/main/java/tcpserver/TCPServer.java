package tcpserver;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(4444);

		Socket socket = serverSocket.accept();

		InputStream in = socket.getInputStream();
		OutputStream out = new FileOutputStream("C:\\eclipse\\image1.jpg");

		byte[] bytes = new byte[16 * 1024];

		int count;
		while ((count = in.read(bytes)) > 0) {
			out.write(bytes, 0, count);
		}

		out.close();
		in.close();
		socket.close();
		serverSocket.close();
	}
}
