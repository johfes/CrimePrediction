package biz.fesenmeyer;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

public class CrimeListener implements UpdateListener {

	@Override
	public void update(EventBean[] arg0, EventBean[] arg1) {
		System.out.println("Straftat registriert: "+ arg0[0].getUnderlying());
	}

}
