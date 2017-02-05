<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<style>
</style>  
<script>
function register(f){
	var c = confirm('Cust를 등록 하시겠습니까?');
	if(c == true){
		f.method = 'POST';//GET, POST
		f.action = 'cust.bs?cmd=register';//내가 정한이름.bank -->dispatcher 에게 보낼때  
		f.submit();
	};
};
</script>
<div class="container">
  <h2>회원 등록</h2><br>
  <table class="table">
    <tbody>
		<form>		
		<tr><td>Id</td><td><input type="text" name="id"></td></tr>		
		<tr><td>Password</td><td><input type="password" name="pwd"></td></tr>	
		<tr><td>Name</td><td><input type="text" name="name"></td></tr>	
		<tr><td>Address</td><td><input type="text" name="addr"></td></tr>	
		<tr><td>Gender</td><td><input type="text" name="gender"></td></tr>	
		<tr><td>Age</td><td><input type="text" name="age"></td></tr>	
		<tr><td>Grade</td><td><input type="text" name="grade"></td></tr>	
		<tr><td>Mobile</td><td><input type="text" name="mobile"></td></tr>	
		<tr><td colspan=2><h3><input type="button" value="register" onclick="register(this.form)"></h3></td>
		</form>			
		</tr>	
    </tbody>
  </table>
</div>
