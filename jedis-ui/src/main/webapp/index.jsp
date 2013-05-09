<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Jedis UI</title>
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <meta name="description" content="">
 <meta name="author" content="">
<style type="text/css">
	.searchBox{
		top:400px;
	}
</style>
 <!-- Le styles -->
 <link href="css/bootstrap.css" rel="stylesheet">
</head>
<body style="text-align: center;background-image: url('images/sea1366x768.jpg');">
	<form action="searchKeys" method="post" id="frmSearch">
		<div class="searchBox">
		<h3>Search Keys</h3> <br/>
		<input style="margin-left: 60px;" id="searchKey" name="pattern" type="text"   required="required" >
		<input type="button" name="" id="btnSearch" style="margin-top: -9px;" value="Search" class="btn"><br/>
		</div>
	</form>
	<div id="divSearchResults">
		
	</div>
	<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$('#btnSearch').click(function(e){
			$('#divSearchResults').load("searchKeys",{pattern:$('#searchKey').val()});
		});
	</script>
</body>
</html>