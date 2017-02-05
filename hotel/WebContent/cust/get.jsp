<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<style>
</style>  
<script>
function modify(f){
	var c = confirm('Cust를 수정 하시겠습니까?');
	if(c == true){
		f.method = 'POST';//GET, POST
		f.action = 'cust.bs?cmd=modify';//내가 정한이름.bank -->dispatcher 에게 보낼때  
		f.submit();
	};
};

function remove(f){
	var c = confirm('Cust를 삭제 하시겠습니까?');
	if(c == true){
		f.method = 'POST';//GET, POST
		f.action = 'cust.bs?cmd=remove';//내가 정한이름.bank -->dispatcher 에게 보낼때  
		f.submit();
	};
};
</script>
<div class="container">
  <h2>회원 상세</h2><br>
  <table class="table">
    <tbody>
		<form>		
		<input type="hidden" name="cid" value="${getcust.cid }">
		<input type="hidden" name="id" value="${getcust.id }">				
		<tr><td>Id</td><td><a href="cust.bs?cmd=get&cid=${getcust.cid }&id=${getcust.id}">${getcust.id }</a></td></tr>		
		<tr><td>Password</td><td>${getcust.pwd }</td></tr>	
		<tr><td>Name</td><td>${getcust.name }</td></tr>	
		<tr><td>Address</td><td>${getcust.addr }</td></tr>	
		<tr><td>Gender</td><td>${getcust.gender }</td></tr>	
		<tr><td>Age</td><td>${getcust.age }</td></tr>	
		<tr><td>Grade</td><td>${getcust.grade }</td></tr>	
		<tr><td>Mobile</td><td>${getcust.mobile }</td></tr>	
		<tr><td><h3><input type="button" value="Update" onclick="modify(this.form)"></h3></td>
		<td><h3><input type="button" value="Delete" onclick="remove(this.form)"></h3></td></tr>			
		</form>			
    </tbody>
  </table>
</div>
