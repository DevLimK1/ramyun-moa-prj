/**
 * 
 */

//var regBox = document.querySelector(".reg-box");
//
//console.log(regBox);
//
//var btnCancel = regBox.querySelector(".btn-cancel");
//
//btnCancel.onclick = cancelBtnClick;

// TODO : cancel button
function cancelBtnClick(e) {
	shield.show();
	e.preventDefault();

	if (e.target.nodeName != "A") {
		console.log(e.target.nodeName);
		return;
	}
	newMain.remove();
	console.log(newMain);
	// oldBody.insertAdjacentElement("beforebegin",newHead);
	header.insertAdjacentElement("afterend", main);

	shield.hide();

}