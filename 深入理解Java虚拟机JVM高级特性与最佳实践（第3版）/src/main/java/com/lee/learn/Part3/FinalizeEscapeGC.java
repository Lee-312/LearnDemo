package com.lee.learn.Part3;

/**
 * finalize方法的自救测试
 */
public class FinalizeEscapeGC {
	public static FinalizeEscapeGC SAVE_HOOK = null;


	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("finalize method executed");
		FinalizeEscapeGC.SAVE_HOOK = this;
	}

	public void isAlive() {
		System.out.println("yes , I am still alive ");
	}

	/**
	 * 第一次成功，第二次失败是因为任何一个对象的finalize方法都只会被系统自动调用异常
	 * 如果对象面临下一次回收，它的finalize方法不会被再次执行，因此第二次失败了
	 *
	 * 使用fianlize方法运行代价高昂，不确定性大，无法保证各个对象的调用顺序，官方明确声明为不推荐用法
	 * finalize方法能做的工作，使用try-fially或其他方式都能做得更好、更及时
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		SAVE_HOOK = new FinalizeEscapeGC();
		// 第一次成功拯救自己
		SAVE_HOOK = null;
		System.gc();
		// 因为Finalize方法优先度很低，暂停0.5s，等它响应
		Thread.sleep(500);
		if (SAVE_HOOK != null) {
			SAVE_HOOK.isAlive();
		}else {
			System.out.println("no, I am dead :(");
		}

		// 第二次拯救失败
		SAVE_HOOK = null;
		System.gc();
		Thread.sleep(500);
		if (SAVE_HOOK != null) {
			SAVE_HOOK.isAlive();
		}else {
			System.out.println("no, I am dead :(");
		}
	}


}
