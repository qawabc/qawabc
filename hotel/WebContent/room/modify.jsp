<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<style>
</style>  
<script>
function modify(f){
	var c = confirm('Room을 수정 하시겠습니까?');
	if(c == true){
		f.method = 'POST';//GET, POST
		f.action = 'room.bs?cmd=modifyimpl';//내가 정한이름.bank -->dispatcher 에게 보낼때  
		f.submit();
	};
};
</script>
<div class="container">
  <h2>객실 수정 상세</h2><br>
  <table class="table">
    <tbody>
		<form method="POST" action="room.bs?cmd=modifyimpl" enctype="multipart/form-data">
		<input type="hidden" name="rid" value="${modifyroom.rid }">
		<input type="hidden" name="rnum" value="${modifyroom.rnum }">				
		<tr><td>Room</td><td>${modifyroom.rnum }</td></tr>		
		<tr><td>Grade</td><td><input type="text" name="grade" value="${modifyroom.grade }"></td></tr>	
		<tr><td>Price</td><td><input type="text" name="price" value="${modifyroom.price }"></td></tr>	
		<tr><td>Description</td><td><input type="text" name="description" value="${modifyroom.description }"></td></tr>	
		<tr><td>Image</td><td><input type="hidden" name="img" value="${modifyroom.img }"><img src="img/${modifyroom.img }"></td></tr>	
		<tr><td>New Image</td><td><input type="file" name="newimg"></td></tr>			
		<tr><td>Branch</td><td><input type="text" name="branch" value="${modifyroom.branch }"></td></tr>	
		<tr><td colspan=2><h3><input type="button" value="modify" onclick="modify(this.form)"></h3></td>
		</tr>	
		</form>			
    </tbody>
  </table>
</div>


