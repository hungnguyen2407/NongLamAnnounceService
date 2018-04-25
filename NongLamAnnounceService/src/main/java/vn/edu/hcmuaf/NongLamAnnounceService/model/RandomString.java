package vn.edu.hcmuaf.NongLamAnnounceService.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomString {
	/**
	 * Phương thức trả về 1 chuỗi ngẫu nhiên
	 * 
	 * @param length
	 *            đội dài của chuỗi
	 * @return String
	 */
	public static String randomString(int length) {
		List<Character> list = new ArrayList<Character>();
		Random rd = new Random();
		
		for(int i = 0; i < 26; i++){
			list.add((char) (65 + i));
			list.add((char) (97 + i));
		}
		
		String result = "";
		for(int i = 0; i < length; i++){
			result += list.get(rd.nextInt(list.size()));
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(randomString(8));
	}
}
