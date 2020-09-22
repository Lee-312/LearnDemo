package com.lee.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
	public static void main(String[] args) {
		try (ServerSocket socket = new ServerSocket(8190);) {
			Socket accept = socket.accept();
			InputStream inputStream = accept.getInputStream();
			OutputStream outputStream = accept.getOutputStream();

			Scanner in = new Scanner(inputStream);
			PrintWriter writer = new PrintWriter(outputStream, true);//autoFlush
			writer.println("Hello !!!");

			boolean stop = false;
			while (!stop && in.hasNext()) {
				writer.println("Echo：" + in.nextLine());
				if (in.nextLine().trim().equals("stop")) {
					stop = true;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
