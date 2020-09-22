package com.lee.socket;

import java.io.InputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

import org.junit.Test;

public class SocketTest {

	public static void main(String[] args) {
		try (Socket e = new Socket("time-A.timefreq.bldrdoc.gov",13);) {
			InputStream inputStream = e.getInputStream();
			Scanner sc = new Scanner(inputStream);
			while (sc.hasNext()){
				System.out.println(sc.nextLine());
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}


	@Test
	public void t1(){
		try (Socket e = new Socket();) {
			// new Socket("time-A.timefreq.bldrdoc.gov",13) 该构造方法会无限期阻塞，直到连接到主机为止
			e.connect(new InetSocketAddress("time-A.timefreq.bldrdoc.gov",13),5000);
			InputStream inputStream = e.getInputStream();
			Scanner sc = new Scanner(inputStream);
			while (sc.hasNext()){
				System.out.println(sc.nextLine());
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}


	@Test
	public void t2(){
		try (Socket e = new Socket();) {
			InetAddress[] all = InetAddress.getAllByName("time-A.timefreq.bldrdoc.gov");
			for (InetAddress a : all) {
				System.out.println(a);
			}
			System.out.println(InetAddress.getLocalHost());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
