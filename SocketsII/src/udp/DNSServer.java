package udp;
import java.io.*;
import java.net.*;

public class DNSServer{
	public static void main(String args[]) throws Exception
	{
		System.out.println("DNS a ouvir...");
		DatagramSocket serverSocket = new DatagramSocket(9876);
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
		String response="";
		while(true)
		{
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			serverSocket.receive(receivePacket);
			String query = new String(receivePacket.getData());
			InetAddress IPAddress = receivePacket.getAddress();
			System.out.println("Recebeu: "+query);
			int port = receivePacket.getPort();
			String q = query.trim();
			if(q.equals("google.com.br")){
				response="172.217.30.3";
			}else if(q.equals("youtube.com")){
					response="172.217.30.14";
			}else if(q.equals("172.217.30.3")){
					response="google.com.br";
			}else if(q.equals("172.217.30.14")){
				response="youtube.com";
			}
			sendData = response.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
			serverSocket.send(sendPacket);
		}
	}
}
