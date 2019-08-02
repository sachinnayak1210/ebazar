//window.onload = initAll;

var eml,eml_msg;
function initAll(){
	eml = document.getElementById('email');
	eml_msg = document.getElementById('eml_msg');

	eml.onblur = validateEmail;	
	eml.onfocus = resetEmlMsg;
}

var patt = new RegExp("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?");
function resetEmlMsg(){ 	
	if(!patt.test(eml.value)){
		eml.value='';  
	}
	eml_msg.style.visibility = 'hidden';
}

function validateEmail(){	
	if(!patt.test(eml.value)){
		eml_msg.innerHTML = 'email is incorrect';
		eml_msg.style.visibility = 'visible';
	}
}