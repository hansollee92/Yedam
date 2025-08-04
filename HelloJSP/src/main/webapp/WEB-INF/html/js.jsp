<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEB-INF/html/js.jsp</title>
</head>
<body>
	<h3>JS연습</h3>
	
	<!-- <script type="text/javascript" src="js/basic.js"></script> -->
	<!-- http://localhost/HelloJSP/js.do
	
	webapp (제일 상위경로, html 내에서는)
	- css
	- js/basic.js
	- WEB-INF
	- index.jsp
	
	현재 위와 같은 경로로 되어 있음
	그렇기 때문에 경로가 위와 같이 됨 js/basic.js 	
	-->	 
	
	 
	
	<div style="display: none;">
		ID : <input type="text" id="mid" ><br>
		Name : <input type="text" id="mname"><br>
		Point : <input type="number" id="point"><br>
		<button id="addBtn">추가</button>	
	</div>
	<div style="display: none;">
		<ul id="list"></ul>
	</div>

	
		
	
	<!-- 문제 -->
	<div>
		이름 : <input type="text" id="std_name"><br>
		영어 : <input type="number" id="std_score"><br>
		<button id="addList">추가</button>
	</div><br>
	<div>
		<table border="1">
			<thead>
				<tr>
					<th>이름</th>
					<th>점수</th>
				</tr>
			</thead>
			<tbody id="tlist">
			<!--<tr>
					<td>홍길동</td>
					<td>90</td>
				</tr>-->
			</tbody>
		</table>
	</div>
	 




	<!-- 스크립트는 항상 아래에 있어야함 아님 null 오류뜸 -->	
	<script type="text/javascript" src="js/data.js"></script>
	 
	 
</body>
</html>