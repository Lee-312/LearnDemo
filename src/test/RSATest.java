import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import cn.hutool.crypto.asymmetric.AsymmetricCrypto;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.json.JSONObject;
import sun.misc.BASE64Decoder;

public class RSATest {

	private static final String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCwDHX1xpf192PrGq3X2/yeUYkq" +
			"VfowZKgTOWWc/HtxKWOz78cs5uO07ZfcaNt6v8TH7L9NMbOYKp7fJLHYPhhKXwtO" +
			"Vig4ZP7bEl068186L98/Uy7lgqBr3B3JuS6IDLODoZqWbyMvEHyvACbXCqR6/j8P" +
			"jXF303kDjOomjsjd1QIDAQAB";
	private static final String PRIVATE_KEY = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBALAMdfXGl/X3Y+sa" +
			"rdfb/J5RiSpV+jBkqBM5ZZz8e3EpY7Pvxyzm47Ttl9xo23q/xMfsv00xs5gqnt8k" +
			"sdg+GEpfC05WKDhk/tsSXTrzXzov3z9TLuWCoGvcHcm5LogMs4OhmpZvIy8QfK8A" +
			"JtcKpHr+Pw+NcXfTeQOM6iaOyN3VAgMBAAECgYEApVPua1OHXfxoH2A8phz3zg4w" +
			"TEvV2yCMHxGl9Zm+q3T9JvwlBmwGp+EA3oKyq0HwoPgaZ3oneN19uX0Sb0tRLufJ" +
			"xpCeHgjAZX0tYtc/cEVz88ozH62uP16PqMpkW+0TAED9peJcVZ1YaJkM4yMrBStB" +
			"flFMjWwYJxTxRf8iwLkCQQDa82LNrf1IKdSy7xrD3BmekeF5p5qwaZ7HUE/fjLk4" +
			"PVDhsAwJoIGyQuhjWo3/Qgm6t05yN4EhzUY4jTMRyKKvAkEAzdafdnSprTTM4c9X" +
			"XN27MnTiiW32I46vz8z84/e//+IIG0rSI65zqR8Sd5sgsFlqOYt1QkfJa2CSm2W7" +
			"aIh4uwJAGy2Q+yT4xqdinp9tfBhrGbLUASzb18AUlHsUnxQxvZhm3MzkgaFp1/3U" +
			"KNkJvUCuQn4Uf7sCDXcUm1pzl2aHQwJARD5D4CINnz9CLhtv+3oH9lKKSMYMNP25" +
			"jEuKDIq3PT7TMTk9MldEQW3r0Xu8+rqqXSm/Vpo2TUNXV+4ClEWqwQJBAJi9Xk3p" +
			"WBfo0oPiowbnqTvgkUjHR9CbFUAQEM5VaWClc+3/1LYhRyk4WbrH222f18TkUjlz" +
			"YCc7OiSOnqcR8ZE=";

	public static void main(String[] args) throws Exception {
		/*AsymmetricCrypto asymmetricCrypto = new AsymmetricCrypto(
				"RSA",
				getRSAPrivateKeyBybase64("私钥解密"),
				getRSAPublidKeyBybase64("公钥加密"));*/

		RSA rsa = new RSA(PRIVATE_KEY, PUBLIC_KEY);

		JSONObject data = new JSONObject();
		data.put("userId", "111000");
		data.put("resId", "qeuyi1487--sxzioiu");
		data.put("timeStamp", System.currentTimeMillis());

		String s1 = rsa.encryptBase64(data.toString(), KeyType.PublicKey);
		System.out.println(s1);

		String s = rsa.decryptStr(s1, KeyType.PrivateKey);
		System.out.println(s);

	}

	/**
	 * @param
	 * @return
	 * @desc: 将字符串转换成RSAPublicKey类型
	 * @date 2020-6-12 11:03:05
	 */
	public static RSAPublicKey getRSAPublidKeyBybase64(String base64s) throws Exception {
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec((new BASE64Decoder()).decodeBuffer(base64s));
		RSAPublicKey publicKey = null;
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		try {
			publicKey = (RSAPublicKey) keyFactory.generatePublic(keySpec);
		} catch (InvalidKeySpecException var4) {

		}
		return publicKey;
	}

	/**
	 * @param
	 * @return
	 * @desc: 将字符串转换成RSAPrivateKey类型
	 * @date 2020-6-12 11:03:01
	 */
	public static RSAPrivateKey getRSAPrivateKeyBybase64(String base64s) throws Exception {
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec((new BASE64Decoder()).decodeBuffer(base64s));
		RSAPrivateKey privateKey = null;
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		try {
			privateKey = (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
		} catch (InvalidKeySpecException var4) {
		}
		return privateKey;
	}
}
