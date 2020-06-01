//Ajax-> 비동기로 자바스크립트를 이용해서 원격의 xml(데이터)를 요청해서 화면을 갱신하는 기술



window.addEventListener("load", function() {

// var reviews = [ {
// id : 1,
// title : "hello",
// writerId : "newlec"
// }, {
// id : 2,
// title : "hi~",
// writerId : "newlec"
// }, ];
	
	var reviews="";

	var main = document.querySelector("#main");
	var pager = main.querySelector(".pager");
	var regBtn = document.querySelector(".review-board .reg-btn");
	var pagerNums=pager.querySelectorAll(".pager-num");
	var indexNum = main.querySelector(".index-num");
	
	var shield = new Shield(".review-board");

	
	regBtn.onclick = regBtnClick;
	pager.onclick = pagerClick;
	


	
	
	
	function regBtnClick(e) { // 등록버튼 클릭
		
		e.preventDefault();
		
		if (e.target.nodeName != "I"){
		 console.log(e.target.nodeName);
			return;
		}
		// 부분 페이지 요청

		var xhr = new XMLHttpRequest();
		
		xhr.open('GET', 'reg', true); // 비동기 옵션
		// 비동기옵션 true : 비동기요청 false:동기형
		
		xhr.onload = function() {
			// alert(xhr.responseText.trim());
		
			var oldHTML = document.querySelector("html");
			var oldHead=document.querySelector("head");
			var oldBody=document.querySelector("body");
			var oldMain=oldBody.children[1];
			var oldHeader=oldBody.children[0];
			

			var html=document.createElement("html");
			html.innerHTML=xhr.responseText.trim();
			var newHead=html.firstElementChild;
			var newBody=html.lastElementChild;
			var newMain=newBody.children[1];
			console.log(newMain);
			
//			html.onload= function(){
//			
//				alert(document.querySelector(".btn-cancel"));
//			}

			oldMain.remove();
// oldBody.insertAdjacentElement("beforebegin",newHead);
			oldHeader.insertAdjacentElement("afterend",newMain);
			
			shield.hide();
			
			//-----------------------------------------------
			// 취소버튼 클릭시 -> shield 부분 어떻게 해야할까?
			
			var regBox=document.querySelector(".reg-box");
			
			console.log(regBox);
			
			var btnCancel=regBox.querySelector(".btn-cancel");
			
			btnCancel.onclick=cancelBtnClick;
			
			// TODO : cancel button
			function cancelBtnClick(e){
				shield.show();
				e.preventDefault();
				 
				if (e.target.nodeName != "A"){
					 console.log(e.target.nodeName);
						return;
				}
				newMain.remove();
				// oldBody.insertAdjacentElement("beforebegin",newHead);
				oldHeader.insertAdjacentElement("afterend",oldMain);

				shield.hide();
				
			}
			
			
		};
		xhr.send(null);
		
		shield.show();
	}


	
	function pagerClick(e) { // 페이지 버튼 클릭
		// 엘리먼트 노드가 가지는 기본 행위를 막는 함수
		e.preventDefault();
		// A 태그가 클릭 된 것이 아닌 경우 함수를 끝내기 , nodeName은 다 대문자로 나온다!! 소문자로 나오지 않음!!
		
		if (e.target.nodeName != "A")
			return;
		
		for(var i=0;i<pagerNums.length;i++){
				pagerNums[i].classList.remove("orange");
		}
		
		e.target.classList.add("orange"); 
		
		var page = e.target.innerText;
		console.log(page);
		
		

		// XmlHttpRequest : callback 개념의 라이브러리
		var xhr = new XMLHttpRequest();
		xhr.open('GET', 'list-data?p=' + page, true);
		// 비동기옵션 true : 비동기요청 false:동기형

		xhr.onload = function() {
			console.log(xhr.responseText);
			reviews = JSON.parse(xhr.responseText);
			bind();
			indexNum.innerText=page; // (현재페이지 / 전체페이지) 현재페이지 변경하기
			shield.hide();

		};
		xhr.send(null);

		shield.show();

	}

	function bind() {
		var reviewContent = "";
		var reviewBoardBox = document.querySelector("#main .review-board-box");
		for ( var i in reviews) {
			var list = reviews[i];
			
			console.log(list);
			var template = `<div class="review-list-box">

					<div class="review-list-box_group">
						<a class="fnt_sunflower" href="#">${list.item}</a>
					</div>

					<div class="review-list-box_vote">
						<!-- <i class="far fa-thumbs-up"></i> -->
						<div class="star">${list.star }</div>
					</div>

					<div class="review-list-box_content">

						<div class="review-list-box_title">
							<div class="span-title">
								<a class="title" href="detail?id=${list.id}">${list.title }</a>
							</div>

							<span class="comment">[${list.comment}]</span>
						</div>


						<div class="review-list-box-meta">
							<div class="review-list-box-meta_regdate">
								${list.regdate}
							</div>
							<div class="review-list-box-meta_author">${list.writerName }</div>
						</div>
					</div>
				</div>`;

			console.log(template);
			reviewContent +=template;
			// tbodyContent = tbodyContent.concat(template); //concat 쓰지말 것
			// console.log(tbodyContent);
		}
		
		reviewBoardBox.innerHTML = reviewContent;
	}
});
