package com.lee.nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

public class FileLocking {
	public static void main(String[] args) throws IOException, InterruptedException {
		FileOutputStream out = new FileOutputStream("file.txt");
		FileLock lock = out.getChannel().tryLock();
		if (lock != null) {
			System.out.println("Locked file");
			TimeUnit.MILLISECONDS.sleep(100);
			lock.release();
			System.out.println(" released Lock");
		}

		out.close();

	}

}
