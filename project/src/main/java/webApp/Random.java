package webApp;

import java.security.SecureRandom;


public class Random {

	public static int RANDOM_RANGE=1000;
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

	
	public static int getRandomNumber(){
		return new Random().nextInt(RANDOM_RANGE);
	}
	
	private int nextInt(int rANDOM_RANGE2) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static String getRandomString(int len){
		  SecureRandom rnd = new SecureRandom();
		   StringBuilder sb = new StringBuilder( len );
		   for( int i = 0; i < len; i++ ) 
		      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		   return sb.toString();
	}
	
	public static String getRandomPassword(int len){
		  SecureRandom rnd = new SecureRandom();
		   StringBuilder sb = new StringBuilder( len );
		   for( int i = 0; i < len; i++ ) 
		      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		   return sb.toString();
	}
	
	
}