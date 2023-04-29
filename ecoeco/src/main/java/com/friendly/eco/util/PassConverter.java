package com.friendly.eco.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*import com.edu.springshop.exception.HashException;
*/
//평문을 해시값으로 변경(이때 개발자는 알고리즘을 선택할 수 있다.)
public class PassConverter {
	
	public static String convertHash(String text) {
		StringBuilder sb=new StringBuilder();
		
		try {
			MessageDigest digest=MessageDigest.getInstance("SHA-256");
			
			//일반스트링 쪼개기
			byte[] hash=digest.digest(text.getBytes("UTF-8"));
			
			for(int i=0;i<hash.length;i++) {
				String hex=Integer.toHexString(0xff&hash[i]);
				
				//System.out.println(hex);
				if(hex.length()==1) sb.append("0");//한자리 수는 두자리로
				sb.append(hex);
			}
			//System.out.println(sb.toString().length());
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			//예외를 알기 위해서 전환이 이루어져야함
			/* throw new HashException("암호화에 실패", e); */
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			/* throw new HashException("암호화에 실패", e); */
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String hash=convertHash("apple");
		System.out.println(hash.length());
	}
}
