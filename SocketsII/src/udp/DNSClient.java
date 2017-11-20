package udp;
import java.io.*;
import java.net.*;

public class DNSClient {
	public static void main(String args[]) throws Exception
	{
		BufferedReader inFromUser =
				new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket clientSocket = new DatagramSocket();
		InetAddress IPAddress = InetAddress.getByName("127.0.0.1");
		byte[] sendData = new byte[1024];
		byte[] receiveData = new byte[1024];
		System.out.println("Informe ip/domínio:\n");
		String query = inFromUser.readLine();
		sendData = query.getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
		clientSocket.send(sendPacket);
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		clientSocket.receive(receivePacket);
		String response = new String(receivePacket.getData());
		System.out.println("Resposta:" + response);
		clientSocket.close();
	}
}
