<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="css/styles.css" rel="stylesheet" />
	<style>
	
		*{padding: 20px;}
		#search{
			width: 300px;
			margin: 5px;
		}
	</style>
</head>
<body>

	검색 : <select class="form-control" id="search">
		<!-- <option value="서울특별시">서울특별시</option>
		<option value="인천광역시">인천광역시</option>
		<option value="대전광역시">대전광역시</option>	-->
	</select>

	<div id="show">
		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>센터ID</th>
					<th>센터명</th>
					<th>전화번호</th>
				</tr>
			</thead>
			<tbody id="list"></tbody>		
		</table>	
	</div>

	<script src="js/openapi.js"></script>
	
	
</body>
</html>



