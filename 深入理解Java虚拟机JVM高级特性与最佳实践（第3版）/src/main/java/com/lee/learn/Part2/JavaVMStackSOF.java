package com.lee.learn.Part2;

/**
 * HotSpot不区分虚拟机栈与本地方法栈，都使用 -Xss设置大小
 * 1）如果线程请求的栈深度大于虚拟机允许的最大深度，将抛出StackOverflowError
 * 2）如果虚拟机栈内存允许动态扩展，当扩展时无法申请到足够内存，将抛出OutOfMemoryError
 *
 */
public class JavaVMStackSOF {
	// java.lang.StackOverflowError
	// 栈深度大于允许深度导致将抛出StackOverflowError
	static class StackDeep {
		private int stackLength = 1;

		public void stackLeak() {
			stackLength++;
			stackLeak();
		}

		public static void main(String[] args) {
			StackDeep deep = new StackDeep();
			try {
				deep.stackLeak();
			} catch (Throwable e) {
				System.out.println("stack length " + deep.stackLength);
				throw e;
			}
		}
	}
	//java.lang.StackOverflowError
	// HotSpot虚拟机不支持栈的动态扩展，所以除非在创建线程时无法获得足够内存而出现的将抛出OutOfMemoryError异常，否则在线程运行时是不会扩展而导致内存溢出的
	static class StackMemorry {
		private static int stackLength = 1;

		public void stackLeak() {
			stackLength++;
			stackLeak();
		}

		public static void main(String[] args) {
			try {
				test();
			} catch (Error e) {
				System.out.println("stack length " + stackLength);
				throw e;
			}

		}

		public static void test() {
			long unused1, unused2, unused3, unused4, unused5, unused6, unused7, unused8, unused9, unused10,
					unused11, unused12, unused13, unused14, unused15, unused16, unused17, unused18, unused19, unused20,
					unused21, unused22, unused23, unused24, unused25, unused26, unused27, unused28, unused29, unused30,
					unused31, unused32, unused33, unused34, unused35, unused36, unused37, unused38, unused39, unused40,
					unused41, unused42, unused43, unused44, unused45, unused46, unused47, unused48, unused49, unused50,
					unused51, unused52, unused53, unused54, unused55, unused56, unused57, unused58, unused59, unused60,
					unused61, unused62, unused63, unused64, unused65, unused66, unused67, unused68, unused69, unused70,
					unused71, unused72, unused73, unused74, unused75, unused76, unused77, unused78, unused79, unused80,
					unused81, unused82, unused83, unused84, unused85, unused86, unused87, unused88, unused89, unused90,
					unused91, unused92, unused93, unused94, unused95, unused96, unused97, unused98, unused99, unused100;
			stackLength++;
			test();
			unused1 = unused2 = unused3 = unused4 = unused5 = unused6 = unused7 = unused8 = unused9 = unused10 =
					unused11 = unused12 = unused13 = unused14 = unused15 = unused16 = unused17 = unused18 = unused19 = unused20 =
							unused21 = unused22 = unused23 = unused24 = unused25 = unused26 = unused27 = unused28 = unused29 = unused30 =
									unused31 = unused32 = unused33 = unused34 = unused35 = unused36 = unused37 = unused38 = unused39 = unused40 =
											unused41 = unused42 = unused43 = unused44 = unused45 = unused46 = unused47 = unused48 = unused49 = unused50 =
													unused51 = unused52 = unused53 = unused54 = unused55 = unused56 = unused57 = unused58 = unused59 = unused60 =
															unused61 = unused62 = unused63 = unused64 = unused65 = unused66 = unused67 = unused68 = unused69 = unused70 =
																	unused71 = unused72 = unused73 = unused74 = unused75 = unused76 = unused77 = unused78 = unused79 = unused80 =
																			unused81 = unused82 = unused83 = unused84 = unused85 = unused86 = unused87 = unused88 = unused89 = unused90 =
																					unused91 = unused92 = unused93 = unused94 = unused95 = unused96 = unused97 = unused98 = unused99 = unused100 = 0;
		}
	}
}
