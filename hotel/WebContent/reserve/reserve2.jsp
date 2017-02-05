<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>

</style>
<script>
function register(f){
	var c = confirm('내역이 맞습니까???');
	alert(f);
	if(c == true){
		f.method = 'POST';//GET, POST
		f.action = 'reserve.bs?cmd=register';//내가 정한이름.bank -->dispatcher 에게 보낼때  
		f.submit();
	};
};
$( document ).ready(function() {
	document.getElementById('price').value = null;
	document.getElementById("rgrade").addEventListener("click", function(){
	    document.getElementById('price').value = this.value.split(" ")[1].split("원")[0];
	});
});

</script>
<h1>예약 추가</h1>
<form>
<div class="input-group date">
	<input type="text" class="form-control" id="mypicker123"><span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
	<input type="text" class="form-control" id="mypicker321"><span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
</div>
<div class="form-group">
  <label for="rgrade">방등급선택:</label>
  <select class="form-control" id="rgrade">
    <c:forEach var="c" items="${roomlist }">
    <option>${c.grade } ${c.price }</option>
    </c:forEach>
  </select>
</div>

<div class="form-group">
  <label for="rnum">방번호:</label>
  <select class="form-control" id="rnum">
    <option>1호</option>
    <option>2호</option>
    <option>3호</option>
    <option>4호</option>
    <option>5호</option>
    <option>6호</option>
  </select>
</div>

<div class="form-group">
  <label for="pwd">가격:</label>
  <input type="text" class="form-control" id="price" readonly>
</div>

<div class="form-group">
  <label for="usr">회원ID:</label>
  <input type="text" class="form-control" id="cid">
</div>

<div class="form-group">
  <label for="sel1">인원:</label>
  <select class="form-control" id="person">
    <option>1명</option>
    <option>2명</option>
    <option>3명</option>
    <option>4명</option>
  </select>
</div>


<div class="form-group">
  <label for="sel1">목적:</label>
  <select class="form-control" id="purpose">
    <option>no info</option>
    <option>여행</option>
    <option>업무</option>
    <option>기타</option>
  </select>
</div>
<div class="container">
  <button type="button" class="btn" onclick="register(this.form)">submit</button>
</div>
</form>