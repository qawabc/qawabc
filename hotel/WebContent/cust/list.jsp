<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<style>

</style>  
<script>

</script>

<div class="container">
  <h2>회원 목록</h2><br>
  <table class="table table-hover" id="example">
    <thead>
      <tr>
        <th>Id</th>
<!--         <th>Password</th> -->
        <th>Name</th>
<!--         <th>Address</th> -->
        <th>Gender</th>
        <th>Age</th>
        <th>Grade</th>
<!--         <th>Mobile</th>      -->                                   
      </tr>
    </thead>
    <tbody>
	<c:forEach var="c" items="${custlist }"><!-- for(Arraylist c: custlist){} 동일-->
		<tr>
		<td><a href="cust.bs?cmd=get&cid=${c.cid }&id=${c.id}">${c.id }</a></td>
<%-- 		<td>${c.pwd }</td>	 --%>
		<td>${c.name }</td>	
<%-- 		<td>${c.addr }</td>	 --%>
		<td>${c.gender }</td>	
		<td>${c.age }</td>	
		<td>${c.grade }</td>	
<%-- 		<td>${c.mobile }</td>	 --%>												
		</tr>
	</c:forEach>      
    </tbody>
  </table>
</div>