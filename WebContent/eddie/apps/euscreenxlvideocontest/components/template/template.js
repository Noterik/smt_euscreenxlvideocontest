var Template = function () {
    Component.apply(this, arguments);
    
  //form validation
    var bla1 = $('#input-1').val();
    var bla2 = $('#input-2').val();
    var bla3 = $('#input-3').val();
    var bla4 = $('#txt_name').val();
    
    var valueName = jQuery("[name='name']").get(0).value;
     console.log(jQuery("[name='name']").get(0).value);
    var valueEmail = jQuery("[name='email']").get(0).value;
    var valueUrl = jQuery("[name='Url']").get(0).value;
    var valueSumary = jQuery("[name='sumary']").get(0).value;

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
    		if (valueName == "" || valueName == undefined) {
    			check = false;
    		}
    	
    		if (validateEmail(valueEmail) == false ) {
    			check = false;
    		}
    	
    		if (validateUrl(valueUrl) == false ) {
    			check = false;
    		}
    	    console.log(valueName);
    	    console.log(valueEmail);
    	    console.log(valueUrl);
    	    console.log(valueSumary);
    	    
    	    console.log(bla1);
    	    console.log(bla2);
    	    console.log(bla3)
    	});
    // end of form validation
    
};

Template.prototype = Object.create(Component.prototype);