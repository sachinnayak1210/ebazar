window.onload = initAll;

function initAll(){
	pageScriptStart();

	resizeText(document.getElementById('anc'),8);//to resize user name displayed in header
}

function resizeText(elm,size){
	if(elm!=null&&elm.innerHTML.length > size){
		//anc.title = anc.innerHTML;
		elm.innerHTML = elm.innerHTML.substring(0,size);		
	}
}