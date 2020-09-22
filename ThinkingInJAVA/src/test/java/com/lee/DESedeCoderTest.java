package com.lee;

public class DESedeCoderTest {
	public static void main(String[] args) throws Exception {
		String inputStr = "DESede";
		byte[] inputData = inputStr.getBytes();
		System.err.println("原文:\t" + inputStr);
		// 初始化密钥
		byte[] key = DESedeCoder.initKey();
		System.out.println(key.length);
		System.out.println(new String(key,"UTF-8"));
		//System.err.println("密钥:\t" + Base64.encodeBase64String(key));
		// 加密
		inputData = DESedeCoder.encrypt(inputData, key);
		//System.err.println("加密后:\t" + Base64.encodeBase64String(inputData));
		// 解密
		byte[] outputData = DESedeCoder.decrypt(inputData, key);
		String outputStr = new String(outputData);
		System.err.println("解密后:\t" + outputStr);
	}

}
