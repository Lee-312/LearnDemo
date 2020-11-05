package com.lee.learn.Part3;

/**
 * Java虚拟机不是使用引用计数法来判断对象是否存活的
 * 测试引用计数法，gc1和gc2互相引用，会不会被GC
 */
public class ReferenceCountingGC {
	public Object instaince = null;
	private static final int _1M = 1024 * 1024;
	// 这个成员变量作用是占用点内存，以便GC日志看清是否有回收过
	private byte[] bigSize = new byte[2 * _1M];

	public static void main(String[] args) {
		ReferenceCountingGC gc1 = new ReferenceCountingGC();
		ReferenceCountingGC gc2 = new ReferenceCountingGC();
		gc1.instaince = gc2;
		gc2.instaince = gc1;

		gc1 = null;
		gc2 = null;
		// 显示GC信息：-XX:+PrintGCDetails
		System.gc();
	}

}
