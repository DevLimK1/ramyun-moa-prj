window.addEventListener("load", function() {

	
	var reviews="";

	var main = document.querySelector("#main");
	var pager = main.querySelector(".pager");
	var regBtn = document.querySelector(".review-board .reg-btn");
	var pagerNums=pager.querySelectorAll(".pager-num");
	var indexNum = main.querySelector(".index-num");
	
	var shield = new Shield(".review-board");

	var navbar=document.querySelector(".navbar");
	var member=navbar.querySelector(".member");
	
	
	regBtn.onclick = regBtnClick;
	pager.onclick = pagerClick;
	


	
	
	
	function regBtnClick(e) { // 등록버튼 클릭
		
		e.preventDefault();
		
		var loginFlag=member.children[0].innerText;
		
		if(loginFlag === '로그인'){
			alert('글쓰기는 로그인이 필요합니다.');
			return;
		}
		
		if (e.target.nodeName != "I"){
		 console.log(e.target.nodeName);
			return;
		}
		// 부분 페이지 요청

		var xhr = new XMLHttpRequest();
		
		xhr.open('GET', 'reg', true); // 비동기 옵션
		// 비동기옵션 true : 비동기요청 false:동기형
		
		xhr.onload = function() {
			  reviewImportCSS("reg.css");
	    	  var header=main.previousElementSibling;
	    	  var div=document.createElement("div");
	    	  div.innerHTML=xhr.responseText.trim(); //문자열을 dom으로 변경
	    	  console.log(xhr.responseText.trim());
	    	  var newMain=div.firstElementChild;
	    	  
	    	  main.remove();
	    	  header.insertAdjacentElement("afterend",newMain);
	    	  shield.hide();
	    	 
	    	  //reg.js 코드 불러오는 방법1)
	    	  var xhr2=new XMLHttpRequest();
	    	  xhr2.open('GET','../js/board/review/reg.js',true);

	    	  
	    	  xhr2.onload=function(){
	    		  console.log(xhr2.responseText);
	    		  
	    		  new Function(xhr2.responseText)();//eval대신 사용!
	    		  
	    	  }
	    	  

	    	  xhr2.send(null);
	    	  
			
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
		var star="";
		var reviewBoardBox = document.querySelector("#main .review-board-box");
		for ( var i in reviews) {
			var list = reviews[i];
			
			switch (parseInt(`${list.gradeId}`)) {
			case 1:
				star='★☆☆☆☆';
				break;
			case 2:
				star='★★☆☆☆';
				break;
			case 3:
				star='★★★☆☆';
				break;
			case 4:
				star='★★★★☆';
				break;
			case 5:
				star='★★★★★';
				break;
			}
			
			var template = `<div class="review-list-box">

					<div class="review-list-box_group">
						<a class="fnt_sunflower" href="#">${list.mfcProduct}</a>
					</div>

					<div class="review-list-box_vote">
						<!-- <i class="far fa-thumbs-up"></i> -->
						<div class="star">
							`+star+`
						</div>
					</div>

					<div class="review-list-box_content">

						<div class="review-list-box_title">
							<div class="span-title">
								<a class="review-title" href="detail?id=${list.id}">${list.title}</a>
							</div>

							<span class="review-comment">[${list.cmtCount}]</span>
						</div>


						<div class="review-list-box-meta">
							<div class="review-list-box-meta_regdate">
								${list.regdate}
							</div>
							<div class="review-list-box-meta_author">${list.nickname }</div>
						</div>
					</div>
				</div>`;

			console.log(template);
			reviewContent +=template;
		}
		
		reviewBoardBox.innerHTML = reviewContent;
	}
});
