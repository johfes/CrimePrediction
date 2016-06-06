package biz.fesenmeyer;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

public class FollowingArrestListener implements UpdateListener {

	@Override
	public void update(EventBean[] arg0, EventBean[] arg1) {
		System.out.println("Vorerst fnden in dieser Gegend voraussichtlich \nkeine weiteren gleichartigen Straftaten statt.");
		Main.setLoop(false);
	}

}
