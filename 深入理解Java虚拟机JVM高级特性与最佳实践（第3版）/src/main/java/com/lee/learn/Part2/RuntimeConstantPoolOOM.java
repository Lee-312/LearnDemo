package com.lee.learn.Part2;

import java.util.HashSet;
import java.util.Set;


/**
 * 运行时常量池是方法区的一部分，
 * JDK6以前通过设置-XX:PermSize和-XX:MaxPermSize限制永久代大小，即可限制常量池容量。如果运行时常量池溢出，抛出OutOfMemoryError异常后面跟随提示PermGen space
 * JDK6之后常量池移入堆内存中，需要使用-Xmx设置最大堆，才能发现溢出
 *
 * -XX:MaxMetspaceSize:设置元空间最大值，默认-1不受限制
 * -XX:MetspaceSize:指定元空间的初始大小，单位字节。达到该值就会触发垃圾收集进行类型卸载，同时收集器会对该值进行调整
 * -XX:MinMetspaceFreeRatio:作用是垃圾收集后控制最小的元空间剩余容量的百分比
 */
public class RuntimeConstantPoolOOM {
	public static void main(String[] args) {
		//java.lang.OutOfMemoryError: Java heap space
		Set<String> set = new HashSet<>();
		short i = 0;
		while (true) {
			set.add(String.valueOf(i++).intern());
		}

/*
		// 运行如下代码，
		// JDK6获得 false fasle
		// JDK7获得 true false(true->java字符串位于sun.misc.Version中进行过常量池的初始化了)
		String str1 = new StringBuffer("计算机").append("软件").toString();
		System.out.println(str1.intern() == str1);
		String str2 = new StringBuffer("ja").append("va").toString();
		System.out.println(str2.intern() == str2);
		*/
	}
}
