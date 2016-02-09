package org.springfield.lou.application.myeuscreen.mail;

public class EuscreenContestEmail extends AbstractMessage {
	public EuscreenContestEmail(String names, String sender, String url, String summery) {
		super();
		this.setRecipient("contest@euscreen.eu");
		this.setCCRecipient("r.rozendal@noterik.nl");
		this.setSubject("EUscreen contest submission");
		this.setSender(sender);
		StringBuilder stringbuilder = new StringBuilder();
		stringbuilder.append("<p>User names: " + names + ",</p>");
		stringbuilder.append("<br />");
		stringbuilder.append("<p>User email: " + sender + "</p>");
		stringbuilder.append("<br />");
		stringbuilder.append("<p>Url: " + url + "</p>");
		stringbuilder.append("<br />");
		stringbuilder.append("<p>Summery: " + summery + "</p>");
		stringbuilder.append("<br />");
		stringbuilder.append("<p>With kind regards, </p>");
		stringbuilder.append("<p>The EUscreen team</p>");

		
		this.setBody(stringbuilder.toString());
	}

}
