package org.springfield.lou.application.myeuscreen.mail;

public interface Message {
	public String getSubject();
	public String getRecipient();
	public String getSender();
	public String getBody();
	public String getCCRecipient();
}
