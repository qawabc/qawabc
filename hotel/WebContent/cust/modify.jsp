<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<style>
</style>  
<script>
function modify(f){
	var c = confirm('Cust�� ���� �Ͻðڽ��ϱ�?');
	if(c == true){
		f.method = 'POST';//GET, POST
		f.action = 'cust.bs?cmd=modifyimpl';//���� �����̸�.bank -->dispatcher ���� ������  
		f.submit();
	};
};
</script>
<div class="container">
  <h2>ȸ�� ���� ��</h2><br>
  <table class="table">
    <tbody>
		<form>		
		<input type="hidden" name="cid" value="${modifycust.cid }">
		<input type="hidden" name="id" value="${modifycust.id }">				
		<tr><td>Id</td><td>${modifycust.id }</td></tr>		
		<tr><td>Password</td><td><input type="password" name="pwd" value="${modifycust.pwd }"></td></tr>	
		<tr><td>Name</td><td><input type="text" name="name" value="${modifycust.name }"></td></tr>	
		<tr><td>Address</td><td><input type="text" name="addr" value="${modifycust.addr }"></td></tr>	
		<tr><td>Gender</td><td><input type="text" name="gender" value="${modifycust.gender }"></td></tr>	
		<tr><td>Age</td><td><input type="text" name="age" value="${modifycust.age }"></td></tr>	
		<tr><td>Grade</td><td><input type="text" name="grade" value="${modifycust.grade }"></td></tr>	
		<tr><td>Mobile</td><td><input type="text" name="mobile" value="${modifycust.mobile }"></td></tr>	
		<tr><td colspan=2><h3><input type="button" value="modify" onclick="modify(this.form)"></h3></td>
		</tr>	
		</form>			
    </tbody>
  </table>
</div>
