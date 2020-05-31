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

	var shield = new Shield(".review-board");
	var regButton = document.querySelector(".review-board .reg-button");
	regButton.onclick = regButtonClick;

	function regButtonClick(e) { // 등록버튼 클릭
		
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
			
//			console.log(oldMain);
//			console.log(oldHeader);
			
//			console.log(oldHead);
//			console.log(oldBody);
			
//			console.log(oldHTML.children);
//			oldHead.remove();
//			oldBody.remove();

//			var header = oldMain.previousElementSibling;
//			console.log(header);
// var div = document.createElement("div");
			// div.innerHTML=xhr.responseText.trim(); //문자열을 dom으로 변경
// var newMain = div.firstElementChild;

			//			console.log(xhr.responseText.trim());
			var html=document.createElement("html");
//			oldHTML.innerHTML=xhr.responseText.trim();
			html.innerHTML=xhr.responseText.trim();
			var newHead=html.firstElementChild;
			var newBody=html.lastElementChild;
			var newMain=newBody.children[1];
//			var newHeader=newBody.children[0];

//			oldHead.remove();
			oldMain.remove();
//			oldBody.insertAdjacentElement("beforebegin",newHead);
			oldHeader.insertAdjacentElement("afterend",newMain);
			
//			oldHead=newHead;
//			newBody=newBody;
//			var content="";
		

//			oldHTML.append(newHead);
//			oldHTML.append(newBody);

			
//			html.innerHTML+=newHead;

//			oldBody.insertAdjacentHTML("afterend", newHead);
//			oldBody.insertAdjacentHTML("afterend", newBody);
			


			
//			console.log('newHTML:'+newHTML);
//			oldMain.remove();
//			console.log(oldMain);
			// aside.insertAdjacentElement("afterend",newMain);
			
			
			
			shield.hide();

		};
		xhr.send(null);
		
		shield.show();
	}

	pager.onclick = pagerClick;

	// 좋지 않은 방법 : 반복문으로 onclick 함수를 대입함
	// var section =document.querySelector(".pager");
	// var table=section.querySelector(".table");
	// var nums = section.querySelectorAll("ul a");

	// for(var i=0;i<nums.length;i++){
	// nums[i].onclick=function(){
	// alert("clicked");
	// };
	// }

	function pagerClick(e) { // 페이지 버튼 클릭
		// 엘리먼트 노드가 가지는 기본 행위를 막는 함수
		e.preventDefault();
		// A 태그가 클릭 된 것이 아닌 경우 함수를 끝내기 , nodeName은 다 대문자로 나온다!! 소문자로 나오지 않음!!
		console.log(e.target.nodeName);

		if (e.target.nodeName != "A")
			return;
		console.log(e.target);

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
			// tbodyContent = tbodyContent.concat(template);
			// console.log(tbodyContent);
		}
		reviewBoardBox.innerHTML = reviewContent;
	}
});

// window.addEventListener("load", function () {
// var notices = [
// { id: 1, title: "hello", writerId: "newlec" },
// { id: 2, title: "hi~", writerId: "newlec" },
// ];

// var table = document.querySelector(".notice .table");

// bind();

// // var bind = function () { --> bind() 하면 에러남
// function bind() {
// var n = notices[0];
// var template = `<tr>
// <td>${n.id}</td>
// <td class="title indent text-align-left"><a
// href="detail?id=${n.id}">${n.title}</a></td>
// <td>${n.writerId}</td>
// </tr>`;
// var tbody = table.querySelector("tbody");
// tbody.innerHTML = template;
// }
// });
