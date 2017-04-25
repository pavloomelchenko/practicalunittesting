package com.mycompany.put.other;

import java.math.BigInteger;
import java.security.MessageDigest;

public class SecurityService {
	/**
	 * MD5 generator of given string
	 * 
	 * @param password
	 * @return md5 as string
	 */
	public String md5(String password) {

		try {
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.reset();
			m.update(password.getBytes());
			byte[] digest = m.digest();
			BigInteger bigInt = new BigInteger(1, digest);
			String hashtext = bigInt.toString(16);
			// Now we need to zero pad it if you actually want the full 32
			// chars.
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
