window.addEventListener("load", function(){

	var calc = document.querySelector("#calc");
	var addBtn = calc.querySelector(".add-btn");
	var addedRm = calc.querySelector(".added-rm");
	var sumBtn = calc.querySelector(".sum-btn");
	var	reSumBtn = calc.querySelector(".re-sum-btn");
	var kcalView = calc.querySelector(".kcal-view");
	
	addBtn.onclick = function() {
		var target = document.getElementById("ramyun-select");
		var br=document.createElement("br");

		addedRm.append(target.options[target.selectedIndex].text);
		addedRm.append(br);
        //addedRm.insertAdjacentHTML("beforeend",'<div class="bybyby" <label>라면</label> <button>삭제하기</button> </div>');
	}; 

	sumBtn.onclick = function() {
		
		alert("계산");
	}

	reSumBtn.onclick = function() {
		kcalView.value = "";
		alert("다시 계산");
	}

});