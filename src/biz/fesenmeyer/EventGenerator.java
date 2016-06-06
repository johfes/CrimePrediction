package biz.fesenmeyer;

import java.util.Random;

public class EventGenerator {
	
	public static void generateCrime(String location, String type){
		Crime crime = new Crime(location, type);
		Main.getCepRT().sendEvent(crime);
	}
	
	public static void generateArrest(String location, String crimeType){
		if(generateRandomInt(1, 10)> 8){
			Arrest arrest = new Arrest(location, crimeType);
			Main.getCepRT().sendEvent(arrest);
		}
	}
	
	public static int generateRandomInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
}
