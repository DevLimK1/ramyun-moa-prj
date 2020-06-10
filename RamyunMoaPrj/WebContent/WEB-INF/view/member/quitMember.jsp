<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<main id="login-main">
	<div>
		<form class="form-row quit-form" name="quitFrm" method="post" action="quitMember">
			<table>
				<tr>
					<td>비밀번호 확인</td>
					<td><input type="password" name="pwd"></td>
				</tr>
				<tr>
					<td>
						<div>
							<input class="btn-style" type="button" value="뒤로가기" onclick="history.back()">&nbsp;
							<input class="btn-style" type="button" value="회원탈퇴" onclick="quitProc()">
						</div>
					</td>
				</tr>
			</table>
		</form>
	</div>
</main>