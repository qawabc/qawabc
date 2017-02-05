<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<style>
</style>  
<script>
function modify(f){
	var c = confirm('Room을 수정 하시겠습니까?');
	if(c == true){
		f.method = 'POST';//GET, POST
		f.action = 'room.bs?cmd=modify';//내가 정한이름.bank -->dispatcher 에게 보낼때  
		f.submit();
	};
};

function remove(f){
	var c = confirm('Room을 삭제 하시겠습니까?');
	if(c == true){
		f.method = 'POST';//GET, POST
		f.action = 'room.bs?cmd=remove';//내가 정한이름.bank -->dispatcher 에게 보낼때  
		f.submit();
	};
};
</script>
<div class="container">
  <h2>객실 상세</h2><br>
  <table class="table">
    <tbody>
		<form>		
		<input type="hidden" name="rid" value="${getroom.rid }">
		<input type="hidden" name="rnum" value="${getroom.rnum }">				
		<tr><td>Room</td><td><a href="room.bs?cmd=get&rid=${getroom.rid }&rnum=${getroom.rnum}">${getroom.rnum }</a></td></tr>		
		<tr><td>Grade</td><td>${getroom.grade }</td></tr>	
		<tr><td>Price</td><td>${getroom.price }</td></tr>	
		<tr><td>Description</td><td>${getroom.description }</td></tr>	
		<tr><td>Image</td><td><img src="img/${getroom.img }">${getroom.img }</td></tr>	
		<tr><td>Branch</td><td>${getroom.branch }</td></tr>	
		<tr><td><h3><input type="button" value="Update" onclick="modify(this.form)"></h3></td>
		<td><h3><input type="button" value="Delete" onclick="remove(this.form)"></h3></td></tr>			
		</form>			
    </tbody>
  </table>
</div>
