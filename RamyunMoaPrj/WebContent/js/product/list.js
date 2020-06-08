
addEventListener("load", function () {

	var container = document.querySelector("#container");

	var pagerUl = container.querySelector(".pager ul");

	var imgSec = container.querySelector(".noodle-img");
	var listImgDiv = imgSec.querySelector(".noodle-list-img");
	var itemName = listImgDiv.querySelectorAll(".item-name");

	for (var i = 0; i < itemName.length; i++) {

		if (itemName[i].innerText.includes("(")) {
			var index = itemName[i].innerText.indexOf("(");
			itemName[i].innerText = itemName[i].innerText.substring(0, index);
		}

		if (itemName[i].innerText.includes(" ")) {
			var temp = itemName[i].innerText.split(" ");
			itemName[i].innerHTML = `${temp[0]}<br/>${temp[1]}`;
		}

	}

	pagerUl.onclick = function (e) {

		e.preventDefault();
		if (e.target.nodeName != "A") return;

		var page = e.target.innerText;

		var xhr = new XMLHttpRequest();
		xhr.open('get', 'list-data?p=' + page, true);
		xhr.send();
		xhr.onload = function () {
			list = JSON.parse(xhr.responseText);
			listImgDiv.innerHTML = "";
			bind();
		}

		function bind() {

			for (var i in list) {

				var itemDiv = document.createElement("div");
				listImgDiv.append(itemDiv);
				itemDiv.classList.add("item");
				itemDiv.innerHTML = `<div class="item-img">
										<img class="rm-img" src="${list[i].img}" value="${list[i].id}">
										</div>
										<div class="item-name">
											<span>${list[i].name}</span>
										</div>
										<div class="review-link">
											<div>
												<a href="">
													<i class="far fa-comment-dots"></i>
													<span>9999</span>
												</a>
											</div>
											<div>
												<a href="">
													<i class="far fa-heart"></i>
													<span>9999</span>
												</a>
											</div>
										</div>`;
			}

		}

	}

	container.onclick = function (e) {

		if (!e.target.classList.contains("rm-img")) return;

		var detailsId = e.target.getAttribute("value");
		var detailContainer = document.createElement("div");
		listImgDiv.append(detailContainer);

		detailContainer.style.position = "absolute";
		detailContainer.style.left = `${e.clientX} px`;
		detailContainer.style.top = `${e.clientY} px`;

		var xhr = new XMLHttpRequest();
		xhr.open('get', 'detail?id=' + detailsId, true);
		xhr.send();

		xhr.onload = function () {
			var result = JSON.parse(xhr.responseText);

			var natrium_ = `${result.natrium / 2000 * 100}`;
			var natrium = natrium_.substr(0, 3);

			var carbohydrate_ = `${result.carbohydrate / 324 * 100}`;
			var carbohydrate = carbohydrate_.substr(0, 3);

			var sugars_ = `${result.sugars / 100 * 100}`;
			var sugars = sugars_.substr(0, 3);

			var fat_ = `${result.fat / 54 * 100}`;
			var fat = fat_.substr(0, 3);

			var saturatedFat_ = `${result.saturatedFat / 15 * 100}`;
			var saturatedFat = saturatedFat_.substr(0, 3);

			var cholesterol_ = `${result.cholesterol / 300 * 100}`;
			var cholesterol = cholesterol_.substr(0, 3);

			var protein_ = `${result.protein / 55 * 100}`;
			var protein = protein_.substr(0, 3);

			detailContainer.innerHTML =
				`<div class="detail">
				<i class="fas fa-times-circle fa-2x"></i>
				<div class="top-container">
					<div class="img-container">
						<img src="${result.img}" />
					</div>
					<div class="info-container">
						<div class="item-name">${result.name}</div>
						<div class="info-sub-container">
							<div>
								<i class="fas fa-check"></i>
								<span>용량: ${result.capacity}g</span>
							</div>
							<div>
								<i class="fas fa-check"></i>
								<span>열량: ${result.kcal}kcal</span>
							</div>
						</div>
						<div class="review-link">
							<div>
								<a href="">
									<i class="far fa-comment-dots fa-2x"></i>
									<span>999</span>
								</a>
							</div>
							<div>
								<a href="">
									<i class="far fa-heart fa-2x"></i>
									<span>999</span>
								</a>
							</div>
						</div>
					</div>
				</div>
				<div class="table-container">
					<table border="1">
						<thead>
							<tr>
								<td>나트륨</td>
								<td>탄수화물</td>
								<td>당류</td>
								<td>지방</td>
								<td>트랜스지방</td>
								<td>포화지방</td>
								<td>콜레스테롤</td>
								<td>단백질</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>${result.natrium == null ? 0 : result.natrium}g</td>
								<td>${result.carbohydrate == null ? 0 : result.carbohydrate}g</td>
								<td>${result.sugars == null ? 0 : result.sugars}g</td>
								<td>${result.fat == null ? 0 : result.fat}g</td>
								<td>${result.transfat == null ? 0 : result.transfat}g</td>
								<td>${result.saturatedFat == null ? 0 : result.saturatedFat}g</td>
								<td>${result.cholesterol == null ? 0 : result.cholesterol}g</td>
								<td>${result.protein == null ? 0 : result.protein}g</td>
							</tr>
						</tbody>
						<tbody>
							<tr>
								<td>${natrium}%</td>
								<td>${carbohydrate}%</td>
								<td>${sugars}%</td>
								<td>${fat}%</td>
								<td>-</td>
								<td>${saturatedFat}%</td>
								<td>${cholesterol}%</td>
								<td>${protein}%</td>
							</tr>
						</tbody>
					</table>
					<span>(% 영양성분 기준치 : 1일 영양성분 기준치에 대한 비율)</span>
				</div>
			</div >`}

		detailContainer.onclick = function () {
			detailContainer.remove();
		}

	}

})