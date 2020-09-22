package com.lee.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

import org.junit.Test;


public class ByteBufferTest {

	private static final int BSIZE = 1024;

	public static void main(String[] args) throws IOException {
		String file = "C:\\Users\\lee\\Desktop\\1.txt";

		//创建通道的三种方式
		FileChannel channel = new FileOutputStream(file).getChannel();
		channel.write(ByteBuffer.wrap("Some text ".getBytes()));
		channel.close();


		channel = new RandomAccessFile(file, "rw").getChannel();
		channel.position(channel.size());
		channel.write(ByteBuffer.wrap("Some more".getBytes()));
		channel.close();


		channel = new FileInputStream(file).getChannel();
		ByteBuffer byteBuffer = ByteBuffer.allocate(BSIZE);
		channel.read(byteBuffer);
		byteBuffer.flip();
		while (byteBuffer.hasRemaining()) {
			System.out.print((char) byteBuffer.get());
		}
	}

	/**
	 * filp()用于准备
	 *
	 * @throws IOException
	 */
	@Test
	public void CopyFile() throws IOException {
		FileChannel in = new FileInputStream("").getChannel(),
				out = new FileOutputStream("").getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
		while (in.read(buffer) != -1) {
			buffer.flip();
			out.write(buffer);
			buffer.clear();
		}
	}


	/**
	 * 将一个通道和另一个通道直接相连
	 *
	 * @throws IOException
	 */
	@Test
	public void ChannelToChannel() throws IOException {
		FileChannel in = new FileInputStream("").getChannel(),
				out = new FileOutputStream("").getChannel();
		in.transferFrom(out, 0, in.size());
	}

	@Test
	public void getData() {
		int Bsize = 1024;
		ByteBuffer buffer = ByteBuffer.allocate(Bsize);
		int i = 0;
		while (i++ < buffer.limit()) {
			if (buffer.get() != 0) {
				System.out.println("nonzero");
			}
		}
		System.out.println("i =" + i);
		buffer.rewind();
		buffer.asCharBuffer().put("Howdy!");
		char c;
		while ((c = buffer.getChar()) != 0) {
			System.out.print(c + "");
		}

		buffer.rewind();
		buffer.asShortBuffer().put((short) 471142);
		System.out.println(buffer.getShort());

		buffer.rewind();
		buffer.asIntBuffer().put(99471142);
		System.out.println(buffer.getInt());

		buffer.rewind();
		buffer.asLongBuffer().put(99471142);
		System.out.println(buffer.getLong());

		buffer.rewind();
		buffer.asFloatBuffer().put(99471142);
		System.out.println(buffer.getFloat());

		buffer.rewind();
		buffer.asDoubleBuffer().put(99471142);
		System.out.println(buffer.getDouble());
		buffer.rewind();

	}

	@Test
	public void LargeMappedFiles() throws IOException {
		int length = 0x8FFFFFF;
		MappedByteBuffer map = new RandomAccessFile("C:\\Users\\lee\\Desktop\\1.txt", "rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0, length);
		for (int i = 0; i < length; i++) {
			map.put((byte) 'x');
		}
		System.out.println("Finished writing");

		for (int i = length / 2; i < length / 2 + 6; i++) {
			System.out.println((char) map.get(i));
		}

	}

}
