<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<style>
</style>  
<script>
function register(f){
	var c = confirm('Room�� ��� �Ͻðڽ��ϱ�?');
	if(c == true){
		f.method = 'POST';//GET, POST
		f.action = 'room.bs?cmd=register';//���� �����̸�.bank -->dispatcher ���� ������  
		f.submit();
	};
};
</script>
<div class="container">
  <h2>���� ���</h2><br>
  <table class="table">
    <tbody>
		<form method="POST" action="room.bs?cmd=register" 
		enctype="multipart/form-data"><!-- �ؽ�Ʈ, �̹������� �� ���̳ʸ������� ���� ������ �ø��� -->
		<tr><td>Room</td><td><input type="text" name="rnum"></td></tr>		
		<tr><td>Grade</td><td><input type="text" name="grade"></td></tr>	
		<tr><td>Price</td><td><input type="number" name="price"></td></tr>	
		<tr><td>Description</td><td><input type="text" name=description></td></tr>	
		<tr><td>Image</td><td><input type="file" name="img"></td></tr><!-- ���ϼ��� file upload-->	
		<tr><td>Branch</td><td><input type="text" name="branch"></td></tr>	
		<tr><td colspan=2><h3><input type="button" value="register" onclick="register(this.form)"></h3></td>
		</form>	
		</tr>	
    </tbody>
  </table>
</div>
