//window.onload = initAll;

var arr = new Array();
var i = 0;
function pageScriptStart(){
	while(true){
		var obj = document.getElementById('cancel_'+i);

		if(obj!=null){
			arr[i] = obj;
			arr[i].onclick = delRecord;
			i++;
		}else{
			break;
		}
	}
}


var req;
var str;
function delRecord(){
	req = new XMLHttpRequest();
	
	str = this.id.split('_')[1];
	alert(str);
	req.open('get','del_pro_pic.do?index='+str,true);
	req.onreadystatechange = showResult;
	req.send(null);
}

function showResult(){
	if(req.readyState==4&&req.status==200){
		var obj = document.getElementById('img_'+str);
		obj.style.border = '1px solid blue';
		obj.style.opacity = 0.5;
	}
}