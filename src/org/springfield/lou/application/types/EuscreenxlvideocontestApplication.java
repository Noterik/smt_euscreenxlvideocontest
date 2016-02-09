package org.springfield.lou.application.types;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
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

}
