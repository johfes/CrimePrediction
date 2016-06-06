package biz.fesenmeyer;

import java.util.Random;

public class EventGenerator {
	
	public static void generateCrime(String location){
		Crime crime = new Crime(location);
		Main.getCepRT().sendEvent(crime);
	}
	
	public static void generateArrest(String location){
		if(generateRandomInt(1, 10)> 8){
			Arrest arrest = new Arrest(location);
			Main.getCepRT().sendEvent(arrest);
		}
	}
	
	public static int generateRandomInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
}
