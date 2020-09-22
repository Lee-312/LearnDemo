package com.lee.nio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

public class MappedIO {
	public static final int numOfInts = 4000000;
	public static final int numOfUbffInts = 200000;

	private abstract static class Tester {
		private String name;

		public Tester(String name) {
			this.name = name;
		}

		public void runTest() {
			try {
				System.out.print(name + ":");
				long time = System.nanoTime();
				test();
				double d = System.nanoTime() - time;
				System.out.format("%.2f\n", d / 1.0e9);
			} catch (IOException e) {
				throw new RuntimeException();
			}
		}

		public abstract void test() throws IOException;
	}


	private static Tester[] tests = {
			new Tester("Stream Write") {
				@Override
				public void test() throws IOException {
					//未加BufferedOutputStream时 32.16，加后变0.26
					DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File("temp.tmp"))));
					for (int i = 0; i < numOfInts; i++) {
						dos.writeInt(i);
					}
					dos.close();
				}
			},
			new Tester("Mapped Write") {
				@Override
				public void test() throws IOException {
					FileChannel fc = new RandomAccessFile("temp.tmp", "rw").getChannel();
					IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();
					for (int i = 0; i < numOfInts; i++) {
						ib.put(i);
					}
					fc.close();
				}
			},
			new Tester("Stream Read") {
				@Override
				public void test() throws IOException {
					DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(new File("temp.tmp"))));
					for (int i = 0; i < numOfInts; i++) {
						dis.readInt();
					}
					dis.close();
				}
			},
			new Tester("Mapped Read") {
				@Override
				public void test() throws IOException {
					FileChannel fc = new RandomAccessFile("temp.tmp", "r").getChannel();
					IntBuffer ib = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size()).asIntBuffer();
					while (ib.hasRemaining()) {
						ib.get();
					}
					fc.close();
				}
			},
			new Tester("Stream Read/Write") {
				@Override
				public void test() throws IOException {
					RandomAccessFile raf = new RandomAccessFile("temp.tmp", "rw");
					raf.writeInt(1);
					for (int i = 0; i < numOfUbffInts; i++) {
						raf.seek(raf.length() - 4);
						raf.writeInt(raf.readInt());
					}
					raf.close();
				}
			},
			new Tester("Mapped Read/Write") {
				@Override
				public void test() throws IOException {
					FileChannel fc = new RandomAccessFile("temp.tmp", "rw").getChannel();
					IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();
					ib.put(0);
					for (int i = 1; i < numOfUbffInts; i++) {
						ib.put(ib.get(i - 1));
					}
					fc.close();
				}
			}
	};

	public static void main(String[] args) {
		for (Tester test : tests) {
			test.runTest();
		}
	}


}
