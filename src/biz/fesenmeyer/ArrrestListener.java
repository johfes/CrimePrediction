package biz.fesenmeyer;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

public class ArrrestListener implements UpdateListener {

	@Override
	public void update(EventBean[] arg0, EventBean[] arg1) {
		System.out.println("Verhaftung registriert: "+
							arg0[0].getUnderlying());

	}

}
