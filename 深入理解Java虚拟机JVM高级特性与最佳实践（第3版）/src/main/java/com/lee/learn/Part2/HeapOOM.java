package com.lee.learn.Part2;

import java.util.ArrayList;
import java.util.List;

/**
 * Java堆溢出，堆用于创建对象，
 * 只要不断的创建对象，并且保证GC Roots到对象间有可达路径来避免垃圾回收机制清理这些对象，
 * 那么随着对象数量的增加，总容量触及最大堆的容量限制后就会产生内存溢出异常
 *
 * 设置堆大小为20MB，不可扩展 -Xms20m -Xmx20m（将最小堆与最大堆参数设置一样可以避免堆自动扩展）
 * -XX:+HeapDumpOnOutOfMemoryError 用于出现内存溢出时Dump出内存堆转储快照（通过jvisualvm工具查看分析生成的hprof文件）
 */
public class HeapOOM {

	static class OOMObject { }
	public static void main(String[] args) {
		//java.lang.OutOfMemoryError: Java heap space
		List<OOMObject> list = new ArrayList<>();
		while (true) {
			list.add(new OOMObject());
		}
	}
}
