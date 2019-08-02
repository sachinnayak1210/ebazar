function pageScriptStart(){
	getAllElements();
	managePriceChange();
}

var gt,chk;
function getAllElements(){
	gt = document.getElementById('gt');
	chk = document.getElementById('chk');	
}

function managePriceChange(){
	var i = 1;
	var sum = 0;

	var str = "";
	while(true){
		var elm = document.getElementById('apply_changes_'+i);

		if(elm!=null){
			elm.value = 1;
			var pro_id = document.getElementById('proId_'+i);
			str += ("&pro_id="+pro_id.value+"&qt="+elm.value);

			sum = sum + new Number(document.getElementById('amt_'+i).innerHTML);
			
			elm.onchange = updateAmount;
			elm.x = i;
		}else{
			break;
		}

		i++;
	}

	gt.innerHTML = sum;
	chk.onclick = function(){window.location = 'checkout.do?grand_total='+gt.innerHTML+str};
}

function updateAmount(){
	var price = document.getElementById('mrp_'+this.x).innerHTML;
	var quantity = this.value;
	document.getElementById('amt_'+this.x).innerHTML = price*quantity;

	var i = 1;
	var sum = 0;
	var str = "";
	while(true){
		var elm = document.getElementById('amt_'+i);
		var elm2 = document.getElementById('apply_changes_'+i);

		if(elm!=null){
			var pro_id = document.getElementById('proId_'+i);
			str += ("&pro_id="+pro_id.value+"&qt="+elm2.value);

			sum += new Number(elm.innerHTML);
		}else{
			break;
		}
		
		i++;
	}

	gt.innerHTML = sum;
	chk.onclick = function(){window.location = 'checkout.do?grand_total='+gt.innerHTML+str};
}