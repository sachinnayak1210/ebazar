function showDashboard(){
	window.location = 'dashboard.do';
}

function searchHint(){
	search_text = document.getElementById('search_text');
		
	var result = document.getElementById('result');
	result.innerHTML = '';
	result.style.display = 'none';

	len = search_text.value.trim().length;

	if(len>2){
		findResult();
	}
}


var srchRq;
function findResult(){
	srchRq = new XMLHttpRequest();

	srchRq.open('get','search.do?input='+search_text.value.trim(),true);
	srchRq.onreadystatechange = showSearchResult;
	srchRq.send(null);
}

function showSearchResult(){
	if(srchRq.readyState==4&&srchRq.status==200){
		//alert(srchRq.responseText);
		var arr = eval(srchRq.responseText);

		//alert(arr.length);

		if(arr.length!=0){
			var result = document.getElementById('result');
			result.innerHTML = '';
			result.style.display = 'block';

			for(i=0;i<arr.length;i++){
				var obj = document.createElement('a');
				obj.innerHTML = obj.title = arr[i].pro_title;
				obj.href = 'product_detail.do?pro_id='+arr[i].pro_id;
				resizeText(obj,20);
				result.appendChild(obj);				
			}
		}
		
	}
}