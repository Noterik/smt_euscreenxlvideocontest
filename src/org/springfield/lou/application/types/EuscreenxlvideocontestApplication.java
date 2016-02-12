package org.springfield.lou.application.types;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springfield.fs.FSList;
import org.springfield.fs.FSListManager;
import org.springfield.fs.FsNode;
import org.springfield.lou.application.Html5Application;
import org.springfield.lou.application.myeuscreen.mail.EuscreenContestEmail;
import org.springfield.lou.application.myeuscreen.mail.Mailer;
import org.springfield.lou.euscreen.config.Config;
import org.springfield.lou.euscreen.config.ConfigEnvironment;
import org.springfield.lou.euscreen.config.SettingNotExistException;
import org.springfield.lou.homer.LazyHomer;
import org.springfield.lou.screen.Screen;

public class EuscreenxlvideocontestApplication extends Html5Application{

	private Config config;
	private Mailer mailer;
	
 	public EuscreenxlvideocontestApplication(String id) {
		super(id); 
		System.out.println("WHooo i am awake");
		this.addReferid("mobilenav", "/euscreenxlelements/mobilenav");
		this.addReferid("header", "/euscreenxlelements/header");
		this.addReferid("footer", "/euscreenxlelements/footer");
		this.addReferid("terms", "/euscreenxlelements/terms");
		this.addReferid("linkinterceptor", "/euscreenxlelements/linkinterceptor");
		this.addReferid("analytics", "/euscreenxlelements/analytics");
		this.addReferid("config", "/euscreenxlelements/config");
		this.addReferid("urltransformer", "/euscreenxlelements/urltransformer");
		
		this.addReferidCSS("fontawesome", "/euscreenxlelements/fontawesome");
		this.addReferidCSS("bootstrap", "/euscreenxlelements/bootstrap");
		this.addReferidCSS("theme", "/euscreenxlelements/theme");
		this.addReferidCSS("genericadditions", "/euscreenxlelements/generic");
		this.addReferidCSS("all", "/euscreenxlelements/all");
		this.addReferidCSS("terms", "/euscreenxlelements/terms");
		
		try{
		
			if(this.inDevelMode()){
				config = new Config(ConfigEnvironment.PROD);
			}else{
				config = new Config();
			}
			
		}catch(SettingNotExistException snee){
			snee.printStackTrace();
		}
		
		try {
			this.mailer = new Mailer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 	
 	public void actionSendcontestemail(Screen s, String ob) {
 		System.out.println("actionSendContestEmail(" + ob + ")");
 		JSONObject object = (JSONObject) JSONValue.parse(ob);
		mailer.sendMessage(new EuscreenContestEmail(object.get("name").toString(), object.get("email").toString(), object.get("url").toString(), object.get("summary").toString()));

        
        
 	}
 	
 	private boolean inDevelMode() {
    	return LazyHomer.inDeveloperMode();
    }
 	
 	public void initializeScreen(Screen s){
 		s.putMsg("header", "", "setActivePage(videocontest)");
 		if(!this.inDevelMode()){
			s.putMsg("linkinterceptor", "", "interceptLinks()");
		} else {
			s.removeContent("linkinterceptor");
		}
 		
 		try {
 			this.loadContent(s, "config", "config");
 	 		this.loadContent(s, "urltransformer", "urltransformer");
			s.putMsg("config", "", "update(" + config.getSettingsJSON() + ")");
		} catch (SettingNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 	}
 	
 	public String getFavicon() {
        return "/eddie/apps/euscreenxlelements/img/favicon.png";
    }
 	
 	
 	public String getMetaHeaders(HttpServletRequest request) {
 		String metaString = "<meta property=\"og:title\" content=\"Video Competition | My favourite EUscreen video\"/>";
		metaString += "<meta property=\"og:site_name\" content=\"EUscreenXL\" />";
		metaString += "<meta property=\"og:type\" content=\"website\" />";
		metaString += "<meta property=\"og:url\" content=\"http://euscreen.eu/contest.html\" />";
		metaString += "<meta property=\"og:description\" content=\"EUscreen has more than 60 000 items accessible online. Let us know which video is your favourite. The 12 best suggestions will form our next Video Collection & each win a 30 EUR Amazon gift-card. Good luck!\" />";
		metaString += "<meta property=\"og:image\" content=\"http://euscreen.eu/eddie/apps/euscreenxlelements/img/content/contestpage/contest%20facebook.jpg\" />";

		metaString += "<meta name=\"twitter:card\" content=\"summary_large_image\">";
		metaString += "<meta name=\"twitter:site\" content=\"@EUscreenXL\">";
		metaString += "<meta name=\"twitter:creator\" content=\"@Euscreen\">";
		metaString += "<meta name=\"twitter:title\" content=\"Video Competition | My favourite EUscreen video\">";
		metaString += "<meta name=\"twitter:description\" content=\"EUscreen has more than 60 000 items accessible online. Let us know which video is your favourite. The 12 best suggestions will form our next Video Collection & each win a 30 EUR Amazon gift-card. Good luck!\">";
		metaString += "<meta name=\"twitter:image\" content=\"http://euscreen.eu/eddie/apps/euscreenxlelements/img/content/contestpage/contest%20facebook.jpg\">";
		return metaString;
	}

}
