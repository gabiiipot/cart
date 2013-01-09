package com.gaby.tutorial.javaee.ejb;

import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(mappedName="jms/Queue")
public class SimpleMessageBean implements MessageListener {
	
	private static final Logger logger = Logger.getLogger(SimpleMessageBean.class.getName());
	
	@Resource
	MessageDrivenContext messageDrivenContext;

	public void onMessage(Message inMessage) {
	    TextMessage msg = null;

	    try {
	        if (inMessage instanceof TextMessage) {
	            msg = (TextMessage) inMessage;
	            logger.info("MESSAGE BEAN: Message received: " +
	                msg.getText());
	        } else {
	            logger.warning("Message of wrong type: " +
	                inMessage.getClass().getName());
	        }
	    } catch (JMSException e) {
	        e.printStackTrace();
	        messageDrivenContext.setRollbackOnly();
	    } catch (Throwable te) {
	        te.printStackTrace();
	    }
	}

}
