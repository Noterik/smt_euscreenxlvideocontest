var Template = function () {
    Component.apply(this, arguments);
    
  //form validation
    var check = true;

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
    	  
	        var valueName = jQuery("[name='name']").get(0).value;
	        var valueEmail = jQuery("[name='email']").get(0).value;
	        var valueUrl = jQuery("[name='Url']").get(0).value;
	        var valueSumary = jQuery("[name='sumary']").get(0).value;
    	
    		if (valueName == "" || valueName == undefined) {
    			check = false;
    			jQuery("[name='name']").css({"border": "1px solid red", "color": "red"});
    		}
    	
    		if (validateEmail(valueEmail) == false ) {
    			check = false;
    			jQuery("[name='email']").css({"border": "1px solid red", "color": "red"});
    		}
    	
    		if (validateUrl(valueUrl) == false ) {
    			check = false;
    			jQuery("[name='Url']").css({"border": "1px solid red", "color": "red"});
    			
    		}
    	    console.log(valueName);
    	    console.log(valueEmail);
    	    console.log(valueUrl);
    	    console.log(valueSumary);
    	    
    	});
    // end of form validation
};

Template.prototype = Object.create(Component.prototype);