/**
 * 
 */

window.addEventListener("load",function(){
	var comment = document.querySelector("#comment");
	var commentSortWriteBtn=comment.querySelector(".comment-sort-write-btn");
	var commentSortWrite=comment.querySelector(".comment-sort-write");
	var commentWriteBox=comment.querySelector(".comment-write-box");
	var commentForm=comment.querySelector(".comment-form");
	var commentCancelBtn=comment.querySelector(".comment-cancel-btn");
	var commentRegBtn=comment.querySelector(".comment-reg-btn");

	
	// comment data values
	var writerName=comment.querySelector(".comment-writer-name");
	var textarea=comment.querySelector("textarea");
	var reviewDetailId_=comment.querySelector(".review-detail-id");
	
	
	
	comment.onclick=function(e){
		console.log(e.target);
		
	
		
		if(e.target.classList.contains('comment-sort-write-btn'))
			commentSortWriteBtnClick(e);// 맨 위 상단 댓글쓰기 버튼클릭
		
		
		if (e.target.classList.contains('comment-reg-btn'))
			commentRegBtnClick(e);// 등록버튼 클릭시 ★ 이벤트 e를 인자로 넘겨줘야함!!
		
		
		if(e.target.classList.contains('comment-write-btn'))
			commentWriteBtnClick(e); // 대댓글 댓글쓰기 버튼클릭
		
		if(e.target.classList.contains('comment-cancel-btn'))
			commentCancelBtnClick(e); // 댓글 취소버튼 클릭
			
	}
// console.log(commentForm);
// console.log(commentRegBtn);
	
	
	// 댓글쓰기 버튼 클릭시
	function commentSortWriteBtnClick(e){
		textarea.value="";// textarea에 값을 초기화시키기 위해 textarea.innerText="";가 아닌
							// value를 쓰자
		e.target.parentElement.parentElement.nextElementSibling.classList.remove("d-none");
	}
	
	// 대댓글 댓글쓰기 버튼 클릭시
	function commentWriteBtnClick(e){
		textarea.value="";// textarea에 값을 초기화시키기 위해 textarea.innerText="";가 아닌
		// value를 쓰자
		e.target.parentElement.parentElement.parentElement.parentElement.nextElementSibling.classList.remove("d-none");
	}
	
	
	// 댓글 취소 버튼 클릭시
	function commentCancelBtnClick(e){
		e.target.classList.add("d-none");
	}
	
	// 대댓글 등록 버튼 클릭시
	
	
	// 상단 댓글 등록 버튼 클릭시
	function commentRegBtnClick(e){ // 댓글 등록버튼 클릭시
		e.preventDefault();
// alert("hi");
		console.log(e);
		console.log(e.target);
		
		// console.log(e.target.innerText); // 작성자이름
		var current = null;
	    for(current = e.target; !current.classList.contains("comment-container"); current = current.parentElement){
	    	console.log(current.classList);
	    }
		
	    console.log(reviewDetailId_.value); // 해당 게시물 id값
		
		console.log(current.previousElementSibling.value); // 작성한 contents
		console.log(current.previousElementSibling.previousElementSibling.firstElementChild.innerText);// 작성자이름

	    var content=textarea.value;
		var writerName=current.previousElementSibling.previousElementSibling.firstElementChild.innerText;
		var reviewDetailId=reviewDetailId_.value;
		
// if (content == "") {
// alert("댓글을 작성하지 않았습니다.");
// return;
// }
		
		xhr=new XMLHttpRequest();
		xhr.open('POST','detail',true);
		
		xhr.onload=function(){
			console.log(xhr.responseText);
			var result=JSON.parse(xhr.responseText);
			
			var commentSort=comment.querySelector(".comment-sort");
			
			var template=`<div class="comment-box">
				<div class="comment-likes">
					<button type="button" class="likes-btn">
						<i class="likes far fa-heart"></i>
						<!--<i class="likes fas fa-heart"></i>-->
					</button>
					<div class="likes-cnt">${result.likes}</div>
				</div>

				<div class="comment-box_box">
					<div class="comment-meta-info">
				<a href="" class="user-id">${result.writerName }</a>
				<div class="regdate">${result.regdate}</div>
				<div class="update">
                        <div class="dots-box">
                            <i class="fas fa-ellipsis-v"></i>
                        </div>
                        <div class="update-box d-none">
                            <div class="update-edit"><span>수정</span></div>
                            <div class="update-delete"><span>삭제</span></div>
                        </div>
                    </div>
			</div>

					<p class="comment-content">${result.content}</p>

					<ul class="comment-btn-list">
						<li class="comment-item">
							<button class="comment-item-btn btn-reset comment-report-btn">
								<img src="../../../../images/board/siren-2859791_640.png"
									width="16px" height="16px" alt="">신고
							</button>
						</li>
						<li class="comment-item">
							<button class="comment-item-btn btn-reset comment-write-btn">
								<i class="fas fa-comment-medical"></i>댓글 쓰기
							</button>
						</li>
					</ul>
				</div>

			</div>
			<form class="comment-form d-none" action="detail" method="post">
	        <div class="comment-write-box second">
	            <div class="img-box">
	                <img src="../images/right-arrow-64x64.png" alt="">
	            </div>
	
	            <div class="comment-box_box">
	                <div class="comment-meta-info">
	                    <a href="" class="comment-writer-name">id랍니다</a>
	                    <!-- <div class="regdate">2020-06-03 15:23:43</div> -->
	                </div>
	
	                <textarea class="comment-write-content" name="contents" placeholder="댓글을 입력해주세요." rows="" cols=""
	                    spellcheck="false" required="required"></textarea>
	                <div class="comment-container">
	                    <ul class="comment-btn-list">
	                        <li class="comment-reg-item"><input type="submit" value="등록"
	                                class="comment-reg-btn btn-reset" /></li>
	                        <li class="comment-reg-item margin-left"><a class="comment-cancel-btn"> 취소 </a></li>
	                    </ul>
	
	                    <div class="comment-write-count">
	                        <span class="comment-write-num">0</span>/<span>300</span>
	                    </div>
	                </div>
	            </div>
	
	        </div>
       </form>
			`
			
			commentForm.insertAdjacentHTML('afterend',template);

			commentForm.classList.add("d-none"); // 댓글 등록 후 댓글 폼 지우기
		}
		
		var json={"reviewId":reviewDetailId,"writerName":writerName,
				"content":content};
		console.log(json);
		var data=JSON.stringify(json);
		
		xhr.setRequestHeader("Content-type", "application/json");
		console.log(data);
		xhr.send(data);
		
	}
	
});
