function pageScriptStart(){
	getAllElements();

	setAllActions();

	manageProductImages();
}

var up_arrow,down_arrow;
var main_pic,pro_id;
var rm,atwl,bn,atc;
var cart_size,cart_box;
function getAllElements(){
	cart_size = document.getElementById('cart_size');	
	cart_box = document.getElementById('cart_box');	

	pro_id = document.getElementById('pro_id');
	main_pic = document.getElementById('main_pic');
	up_arrow = document.getElementById('up_arrow');
	down_arrow = document.getElementById('down_arrow');

	rm = document.getElementById('rm');
	atwl = document.getElementById('atwl');
	bn = document.getElementById('bn');
	atc = document.getElementById('atc');
}

function setAllActions(){
	up_arrow.onclick = showPrevious;
	down_arrow.onclick = showNext;

	cart_box.onclick = function(){ window.location = "show_cart.do"; };

	//rm,atwl,bn,
	atc.onclick = addToCart;
}

var rqAtc;
function addToCart(){
	rqAtc = new XMLHttpRequest();

	rqAtc.open('get','add_to_cart.do?pro_id='+pro_id.value,true);
	rqAtc.onreadystatechange = showAtcResult;
	rqAtc.send(null);
}

function showAtcResult(){
	if(rqAtc.readyState==4&&rqAtc.status==200){
		cart_size.innerHTML = rqAtc.responseText;
	}
}

function showPrevious(){
	if(tmp>=2){
		tmp--;	

		var e = 1;
		while(true){
			var obj = document.getElementById('box_'+e);

			if(obj!=null){
				if(e>=tmp&&e<tmp+3){
					obj.style.display = 'block';
				}else{
					obj.style.display = 'none';
				}
			}else{
				break;
			}

			e++;
		}
	}
}

var cr,tmp=1;
function showNext(){
	if(tmp<(i-3)){
		tmp++;	

		var e = 1;
		while(true){
			var obj = document.getElementById('box_'+e);

			if(obj!=null){
				if(e>=tmp&&e<tmp+3){
					obj.style.display = 'block';
				}else{
					obj.style.display = 'none';
				}
			}else{
				break;
			}

			e++;
		}
	}	
}

var i = 1;
function manageProductImages(){
	while(true){
		var obj = document.getElementById('box_'+i);		
		
		if(obj!=null){
			obj.x = i;
			if(i>3){
				obj.style.display = 'none';
			}

			obj.onmouseover = function(){ main_pic.src = document.getElementById('pic_'+this.x).src; };
		}else{
			break;
		}
		
		i++;
	}

	cr = i-1;
}