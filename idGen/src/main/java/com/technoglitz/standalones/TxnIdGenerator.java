package com.technoglitz.standalones;

import java.io.ByteArrayOutputStream;
import java.util.Random;

public class TxnIdGenerator {

	
	private static Random basicRandom =  new Random();;
	
	private final static byte[] HEX_DIGITS = {
			(byte) '0', (byte) '1', (byte) '2', (byte) '3', (byte) '4', (byte) '5', (byte) '6', (byte) '7', 
			(byte) '8', (byte) '9', (byte) 'A', (byte) 'B', (byte) 'C', (byte) 'D', (byte) 'E', (byte) 'F' 
		   };
		
	/**
	 * @param length
	 * @return
	 */
	public static String generateRandom(int length){
		byte[] bs = new byte[length];
		basicRandom.nextBytes(bs);
		return new String(encodeHex(bs));
	}
	
	/**
	 * @param data
	 * @return
	 */
	private static byte[] encodeHex(final byte[] data) {
		ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		for (int i = 0; i < data.length; i++) {
			int v = data[i] & 0xff;
			bOut.write(HEX_DIGITS[(v >>> 4)]);
			bOut.write(HEX_DIGITS[v & 0xf]);
		}
		return bOut.toByteArray();
	}
	
	
}
