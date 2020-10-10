package com.lee.JAVA编程思想.Part12_通过异常处理错误;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;

public class InputFile {
	private BufferedReader in;

	public InputFile(String fileName) throws Exception {
		try {
			in = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("Counld not open -> " + fileName);
			throw e;
		} catch (Exception e) {
			try {
				in.close();
			} catch (IOException e2) {
				System.out.println("in.close() unsuccessful");
			}
			throw e;
		} finally {

		}
	}

	public String getLine() {
		String s;
		try {
			s = in.readLine();
		} catch (IOException e) {
			throw new RuntimeException("readLine() failed");
		}
		return s;
	}

	public void dispose() {
		try {
			in.close();
			System.out.println("dispose() success");
		} catch (IOException e) {
			throw new RuntimeException("dispose() failed");
		}
	}


}
