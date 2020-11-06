package com.lee.learn.Part3;

import static com.lee.learn.Part3.ReferenceCountingGC._1M;

public class Test {
	public static void main(String[] args) {
//		testAllocation();//对象优先在Eden分配
//		testPertenureSizeThreshold();//大对象直接进入老年代
//		testTenuringThreshold();//长期存活的对象将进入老年代
//		testTenuringThreshold2();//动态对象年龄判定
		testHandlePromotion();//空间分配担保
	}

	/**
	 * JVM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
	 */
	public static void testAllocation() {
		byte[] allocation1, allocation2, allocation3, allocation4;
		allocation1 = new byte[2 * ReferenceCountingGC._1M];
		allocation2 = new byte[2 * ReferenceCountingGC._1M];
		allocation3 = new byte[2 * ReferenceCountingGC._1M];
		// 堆内存设置20M且不可扩展，10M分配给Eden，10M给老年代
		// 前三个对象都存活，Eden空间已经使用了6M，剩余空间不足分配给allocation4，此时出现一次Minor GC
		// 垃圾收集器期间又发现已有3个2MB大小对象无法放入Survivor空间，只好通过分配担保机制提前转移到老年代中
		//allocation4 = new byte[4 * ReferenceCountingGC._1M];
		// 程序结束Eden占用4M，Survivor空闲，老年代占用6M
	}


	/**
	 * JVM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
	 * -XX:PretenureSizeThreshold=3145728
	 * <p>
	 * PretenureSizeThreshold仅对Serial和ParNew的新生代收集器有效
	 * -XX:+UseParNewGC
	 */
	public static void testPertenureSizeThreshold() {
		byte[] allocation;
		allocation = new byte[4 * _1M];
	}

	/**
	 * JVM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
	 * -XX:MaxTenuringThreshold=1
	 * -XX:+PrintTenuringDistribution
	 */
	public static void testTenuringThreshold() {
		byte[] allocation1, allocation2, allocation3;
		allocation1 = new byte[ReferenceCountingGC._1M / 4];
		allocation2 = new byte[4 * ReferenceCountingGC._1M];
		allocation3 = new byte[4 * ReferenceCountingGC._1M];
		allocation3 = null;
		allocation3 = new byte[4 * ReferenceCountingGC._1M];


		/**
		 * MaxTenuringThreshold=1
		 *
		 * [GC (Allocation Failure) [ParNew
		 * Desired survivor size 524288 bytes, new threshold 1 (max 1)
		 * - age   1:     965032 bytes,     965032 total
		 * : 6688K->963K(9216K), 0.0019355 secs] 6688K->5059K(19456K), 0.0019683 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
		 * [GC (Allocation Failure) [ParNew
		 * Desired survivor size 524288 bytes, new threshold 1 (max 1)
		 * : 5059K->0K(9216K), 0.0004775 secs] 9155K->5049K(19456K), 0.0005032 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
		 * Heap
		 *  par new generation   total 9216K, used 4178K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
		 *   eden space 8192K,  51% used [0x00000000fec00000, 0x00000000ff014930, 0x00000000ff400000)
		 *   from space 1024K,   0% used [0x00000000ff400000, 0x00000000ff400000, 0x00000000ff500000)
		 *   to   space 1024K,   0% used [0x00000000ff500000, 0x00000000ff500000, 0x00000000ff600000)
		 *  tenured generation   total 10240K, used 5049K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
		 *    the space 10240K,  49% used [0x00000000ff600000, 0x00000000ffaee530, 0x00000000ffaee600, 0x0000000100000000)
		 *  Metaspace       used 3453K, capacity 4496K, committed 4864K, reserved 1056768K
		 *   class space    used 378K, capacity 388K, committed 512K, reserved 1048576K
		 */
		/**
		 * MaxTenuringThreshold=15
		 *
		 * [GC (Allocation Failure) [ParNew
		 * Desired survivor size 524288 bytes, new threshold 1 (max 15)
		 * - age   1:     939200 bytes,     939200 total
		 * : 6688K->937K(9216K), 0.0021971 secs] 6688K->5033K(19456K), 0.0022297 secs] [Times: user=0.05 sys=0.00, real=0.00 secs]
		 * [GC (Allocation Failure) [ParNew
		 * Desired survivor size 524288 bytes, new threshold 15 (max 15)
		 * - age   1:        736 bytes,        736 total
		 * : 5117K->515K(9216K), 0.0004988 secs] 9213K->5530K(19456K), 0.0005148 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
		 * Heap
		 *  par new generation   total 9216K, used 4749K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
		 *   eden space 8192K,  51% used [0x00000000fec00000, 0x00000000ff022810, 0x00000000ff400000)
		 *   from space 1024K,  50% used [0x00000000ff400000, 0x00000000ff480f00, 0x00000000ff500000)
		 *   to   space 1024K,   0% used [0x00000000ff500000, 0x00000000ff500000, 0x00000000ff600000)
		 *  tenured generation   total 10240K, used 5015K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
		 *    the space 10240K,  48% used [0x00000000ff600000, 0x00000000ffae5c78, 0x00000000ffae5e00, 0x0000000100000000)
		 *  Metaspace       used 3441K, capacity 4496K, committed 4864K, reserved 1056768K
		 *   class space    used 376K, capacity 388K, committed 512K, reserved 1048576K
		 */
	}

	/**
	 * JVM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
	 * -XX:MaxTenuringThreshold=15
	 * -XX:+PrintTenuringDistribution
	 */
	public static void testTenuringThreshold2() {
		byte[] allocation1, allocation2, allocation3, allocation4;
		allocation1 = new byte[ReferenceCountingGC._1M / 4];
		allocation2 = new byte[ReferenceCountingGC._1M / 4];
		allocation3 = new byte[4 * ReferenceCountingGC._1M];
		allocation4 = new byte[4 * ReferenceCountingGC._1M];
		allocation4 = null;
		allocation4 = new byte[4 * ReferenceCountingGC._1M];
	}

	/**
	 * JVM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
	 * -XX:HandlePromotionFailure=false
	 */
	public static void testHandlePromotion() {
		byte[] allocation1, allocation2, allocation3, allocation4, allocation5, allocation6, allocation7;
		allocation1 = new byte[2 * ReferenceCountingGC._1M];
		allocation2 = new byte[2 * ReferenceCountingGC._1M];
		allocation3 = new byte[2 * ReferenceCountingGC._1M];
		allocation1 = null;
		allocation4 = new byte[2 * ReferenceCountingGC._1M];
		allocation5 = new byte[2 * ReferenceCountingGC._1M];
		allocation6 = new byte[2 * ReferenceCountingGC._1M];
		allocation4 = null;
		allocation5 = null;
		allocation6 = null;
		allocation7 = new byte[2 * ReferenceCountingGC._1M];
	}
}
