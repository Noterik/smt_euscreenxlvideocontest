var Template = function () {
    Component.apply(this, arguments);
	
    this.container = $('.videocontest');
  	
    this.$facebookButton = this.container.find('#button-facebook');
    this.$twitterButton = this.container.find('#button-twitter');
    this.$googleButton = this.container.find('#button-google');
    this.$urlInput = this.container.find("#url-input");

    this.$twitterButton.SocialSharing({ type : 'twitter', url : document.location, text : "Test" });
    this.$facebookButton.SocialSharing({ type : 'facebook', url : document.location, text : "Test" });
    this.$googleButton.SocialSharing({ type : 'google', url : document.location, text : "Test" });
    this.$urlInput.val(document.location);
    
    // regex for email validation
    function validateEmail(email) {
        var re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        return re.test(email);
    }
    	
    //regex for Url validation
    function validateUrl(textval) {
        var urlregex = /^(https?|ftp):\/\/([a-zA-Z0-9.-]+(:[a-zA-Z0-9.&%$-]+)*@)*((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9][0-9]?)(\.(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])){3}|([a-zA-Z0-9-]+\.)*[a-zA-Z0-9-]+\.(com|edu|gov|int|mil|net|org|biz|arpa|info|name|pro|aero|coop|museum|[a-zA-Z]{2}))(:[0-9]+)*(\/($|[a-zA-Z0-9.,?'\\+&%$#=~_-]+))*$/;
        return urlregex.test(textval);
    }

    $( "#submit-btn" ).click(function() {
    		var check = true;

	        var valueName = jQuery("[name='name']").get(0).value;
	        var valueEmail = jQuery("[name='email']").get(0).value;
	        var valueUrl = jQuery("[name='Url']").get(0).value;
	        var valueSumary = jQuery("[name='sumary']").get(0).value;
    	
    		if (valueName == "" || valueName == undefined) {
    			check = false;
    			jQuery("[name='name']").css({"border": "2px solid #F64747",});
    			jQuery("[name='name']").attr("placeholder", "Please put your Name and Surname !");
    			jQuery("[name='name']").addClass('new-color');
    		}
    	
    		if (validateEmail(valueEmail) == false ) {
    			check = false;
    			jQuery("[name='email']").css({"border": "2px solid #F64747",});
    			jQuery("[name='email']").attr("placeholder", "Please put your email address !");
    			jQuery("[name='email']").addClass('new-color');
    		}
    	
    		if (validateUrl(valueUrl) == false ) {
    			check = false;
    			jQuery("[name='Url']").css({"border": "2px solid #F64747",});
    			jQuery("[name='Url']").attr("placeholder", "Please put the url of your favourite video !");
    			jQuery("[name='Url']").addClass('new-color');
    		}
    		
    		if (valueSumary == "" || valueSumary == undefined) {
    			check = false;
    			jQuery("[name='sumary']").css({"border": "2px solid #F64747",});
    			jQuery("[name='sumary']").attr("placeholder", "Please tell us why do you like this video !");
    			jQuery("[name='sumary']").addClass('new-color');
    		}
    		

    		if(check == true){
    			jQuery(".grn-submit").css({"display": "block"});
    			jQuery("[name='name']").css({"border": "2px solid rgb(197, 197, 197)"});
    			jQuery("[name='email']").css({"border": "2px solid rgb(197, 197, 197)"});
    			jQuery("[name='Url']").css({"border": "2px solid rgb(197, 197, 197)	"});
    			jQuery("[name='sumary']").css({"border": "2px solid rgb(197, 197, 197)"});
    			var result = JSON.stringify({"name": valueName, "email": valueEmail, "url": valueUrl, "summary": valueSumary});

    			eddie.putLou("", "sendContestEmail(" + result + ")");
    			
    		}
    	    
    	});
    // end of form validation
};

Template.prototype = Object.create(Component.prototype);