<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<style>
</style>  
<script>

</script>

<div class="container">
  <h2>객실 목록</h2><br>
  <table class="table table-hover" id="example">
    <thead>
      <tr>
        <th>Room</th>
        <th>Grade</th>                     
        <th>Price</th>
        <th>Description</th>
        <th>Image</th>
        <th>Branch</th>                                        
      </tr>
    </thead>
    <tbody>
	<c:forEach var="c" items="${plist }"><!-- for(Arraylist c: plist){} 동일-->
		<tr>
		<td><a href="room.bs?cmd=get&rid=${c.rid }&rnum=${c.rnum}">${c.rnum}</a></td>
		<td>${c.grade }</td>				
		<td>${c.price }</td>	
		<td>${c.description }</td>	
		<td><%-- <img src="img/${c.img }"> --%>${c.img }</td>	
		<td>${c.branch }</td>	
		</tr>
	</c:forEach>      
    </tbody>
  </table>
</div>