package biz.fesenmeyer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;

public class Main {
	private static EPRuntime cepRT;
	private static boolean loop = true;
	private static String location;
	private static String crimeType;
	
	public static EPRuntime getCepRT() {
		return cepRT;
	}

	public static void setLoop(boolean loop) {
		Main.loop = loop;
	}

	public static void main(String[] args) {
		initCEP();
	    BufferedReader br = new BufferedReader
	    					(new InputStreamReader(System.in));
	    try {
	    System.out.print("Welcher Ort soll überwacht werden?");
		location = br.readLine();
		System.out.println("Welche Straftat soll überwacht werden?");
		crimeType = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		for(int i=0; loop; i++){
			EventGenerator.generateCrime(location, crimeType);
			EventGenerator.generateArrest(location, crimeType);
		}
	}
	
	public static void initCEP(){
	    Configuration cepConfig = new Configuration();
	    // register objects the engine will have to handle
	    cepConfig.addEventType("Crime",
	    		Crime.class.getName());
	    cepConfig.addEventType("Arrest",
	    		Arrest.class.getName());
		// setup the engine
		EPServiceProvider cep = EPServiceProviderManager.
									getProvider("CEPEngine",cepConfig);
		cepRT = cep.getEPRuntime();
		//  register EPL statements
		EPAdministrator cepAdm = cep.getEPAdministrator();
		
		EPStatement cepStatement1 = cepAdm.createEPL("select * from " +
				"Arrest.win:length(1)");
		EPStatement cepStatement2 = cepAdm.createEPL("select * from " +
				"Crime.win:length(1)");
		EPStatement cepStatement3 = cepAdm.createEPL("select * from " +
				"pattern [Crime -> Arrest]");

		cepStatement1.addListener(new ArrrestListener());
		cepStatement2.addListener(new CrimeListener());
		cepStatement3.addListener(new FollowingArrestListener());
	}
}

