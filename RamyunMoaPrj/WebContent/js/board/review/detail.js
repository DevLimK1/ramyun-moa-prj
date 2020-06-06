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

	//comment data values
	var commentWriterName=commentForm.querySelector(".comment-writer-name");
	var textarea=commentForm.querySelector("textarea");
	
	
	
	
	commentSortWrite.onclick=function(e){
		textarea.value="";//textarea에 값을 초기화시키기 위해 textarea.innerText="";가 아닌 value를 쓰자
		commentForm.classList.remove("d-none");
	}
	
	commentCancelBtn.onclick=function(e){
		commentForm.classList.add("d-none");
	}
	
	commentRegBtn.onclick=function(e){ //댓글 등록버튼 클릭시
		e.preventDefault();
		console.log(textarea.value);
		console.log(commentWriterName.innerText);
		
		var content=textarea.value;
		var writerName=commentWriterName.innerText;
		
		if (content == "") {
			alert("댓글을 작성하지 않았습니다.");
			return;
		}
		
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
						<a href="" class="user-id">${result.writerName}</a>
						<div class="regdate">${result.regdate}</div>
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

			</div>`
			
			commentForm.insertAdjacentHTML('afterend',template);

			commentForm.classList.add("d-none");
		}
		
		var json={"writerName":writerName,
				"content":content};
		
		var data=JSON.stringify(json);
		
		xhr.setRequestHeader("Content-type", "application/json");
		console.log(data);
		xhr.send(data);
		
	}
	
});
