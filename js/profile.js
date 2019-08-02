//window.onload = initAll;

function pageScriptStart(){
	getAllElements();

	setAllActions();
}

var unm_sp,unm_txt,unm_edit,unm_save,unm_cancel;
var pass_sp,pass_box,opass,npass,repass,pass_edit,pass_save,pass_cancel;
var city_sp,state,city_edit,city_save,city_cancel,city,cityState='';
function getAllElements(){
	//User Name /////////////////////////////
	unm_sp = document.getElementById('unm_sp');
	unm_txt = document.getElementById('unm_txt');
	unm_edit = document.getElementById('unm_edit');
	unm_save = document.getElementById('unm_save');
	unm_cancel = document.getElementById('unm_cancel');

	//Password /////////////////////////////
	pass_sp = document.getElementById('pass_sp');
	pass_box = document.getElementById('pass_box');
	opass = document.getElementById('opass');
	npass = document.getElementById('npass');
	repass = document.getElementById('repass');
	pass_edit = document.getElementById('pass_edit');
	pass_save = document.getElementById('pass_save');
	pass_cancel = document.getElementById('pass_cancel');

	//City /////////////////////////////////
	city_sp = document.getElementById('city_sp');
	state = document.getElementById('state');
	city_edit = document.getElementById('city_edit');
	city_save = document.getElementById('city_save');
	city_cancel = document.getElementById('city_cancel');
	city = document.getElementById('city');
}

function setAllActions(){
	//User Name /////////////////////////////
	unm_edit.onclick = startEditUnm;
	unm_save.onclick = saveUnm;
	unm_cancel.onclick = cancelEditUnm;

	//Password /////////////////////////////
	pass_edit.onclick = startEditPass;
	pass_save.onclick = savePass;
	pass_cancel.onclick = cancelEditPass;

	//City //////////////////////////////////
	city_edit.onclick = startEditCity;
	city_save.onclick = saveCity;
	city_cancel.onclick = cancelEditCity;
	state.onchange = collectCities;
	city.onchange = function(){cityState = this[this.selectedIndex].text+','+state[state.selectedIndex].text};
}

var ctRq;
function collectCities(){
	ctRq = new XMLHttpRequest();

	ctRq.open('get','collect_cities.do?state_id='+state.value,true);
	ctRq.onreadystatechange = showCities;
	ctRq.send(null);
}

function showCities(){
	if(ctRq.readyState==4&&ctRq.status==200){
		city.innerHTML = '<option>Select City</option>';
		//alert(ctRq.responseText);
		//alert(eval(ctRq.responseText));
		var arr = eval(ctRq.responseText);

		for(i=0;i<arr.length;i++){
			var op = document.createElement('option');
			op.text = arr[i].citynm;
			op.value = arr[i].cityid;

			city.appendChild(op);
		}
		
		city.className = 'chng_ show';
	}
}

function startEditCity(){
	city_sp.className = 'hide';
	city_edit.className = 'hide';
	city_save.className = 'chng_ show';
	city_cancel.className = 'chng_ show';
	state.className = 'show';
}

var svCtRq;
function saveCity(){
	svCtRq = new XMLHttpRequest();
	
	svCtRq.open('get','save_city.do?city_id='+city.value,true);
	svCtRq.onreadystatechange = showCityChange;
	svCtRq.send(null);
}

function showCityChange(){
	if(svCtRq.readyState==4&&svCtRq.status==200){
		var val = svCtRq.responseText;

		if(val=='one'){
			city_sp.className = 'show';
			city_sp.innerHTML = cityState;
			city_edit.className = 'chng_ show';
			city_save.className = 'hide';
			city_cancel.className = 'hide';
			state.className = 'hide';
			city.className = 'hide';
		}
	}
}

function cancelEditCity(){
	city_sp.className = 'show';
	city_edit.className = 'chng_ show';
	city_save.className = 'hide';
	city_cancel.className = 'hide';
	state.className = 'hide';
}

function cancelEditPass(){
	pass_sp.className = 'show';
	pass_box.className = 'hide';
	pass_edit.className = 'chng_ show';
	pass_save.className = 'hide';
	pass_cancel.className = 'hide';
}

var pRq = null;
function savePass(){
	pRq = new XMLHttpRequest();

	pRq.open('get','update_password.do?opass='+opass.value+'&npass='+npass.value+'&repass='+repass.value,true);
	pRq.onreadystatechange = showPassChange;
	pRq.send(null);
}

function showPassChange(){
	if(pRq.readyState==4&&pRq.status==200){
		var res = pRq.responseText;

		if(res=='yes'){
			pass_sp.className = 'show';
			pass_box.className = 'hide';
			pass_edit.className = 'show';
			pass_save.className = 'hide';
			pass_cancel.className = 'hide';
		}
	}
}

function startEditPass(){
	pass_sp.className = 'hide';
	pass_box.className = 'show_block';
	pass_edit.className = 'hide';
	pass_save.className = 'chng_ show';
	pass_cancel.className = 'chng_ show';
}

function cancelEditUnm(){
	unm_sp.className = 'show';
	//unm_txt.value = unm_sp.innerHTML;
	unm_txt.className = 'hide';
	
	unm_edit.className = 'show';
	unm_save.className = 'hide';
	unm_cancel.className = 'hide';
}
	
var uRq;
function saveUnm(){
	if(unm_sp.innerHTML!=unm_txt.value){
		uRq = new XMLHttpRequest();
	
		uRq.open('get','update_unm.do?unm='+unm_txt.value,true);
		uRq.onreadystatechange = showUnmChange;
		uRq.send(null);	
	}else{
		alert("No Changes made");
	}	
}

function showUnmChange(){
	if(uRq.readyState==4&&uRq.status==200){
		var val = uRq.responseText;

		if(val=='yes'){
			unm_sp.innerHTML = unm_txt.value;
			unm_sp.className = 'show';		
			unm_txt.className = 'hide';

			unm_edit.className = 'show';
			unm_save.className = 'hide';
			unm_cancel.className = 'hide';
		}
	}
}

function startEditUnm(){
	unm_sp.className = 'hide';
	unm_txt.value = unm_sp.innerHTML;
	unm_txt.className = 'show';
	
	unm_edit.className = 'hide';
	unm_save.className = 'chng_ show';
	unm_cancel.className = 'chng_ show';
}