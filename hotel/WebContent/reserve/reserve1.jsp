<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
</style>
<h1>예약 목록</h1>
<div class="container">
  <table id="reservelist" class="hover" cellspacing="0" width="100%">
    <thead>
      <tr>
        <th>예약ID</th>
        <th>회원ID</th>
        <th>방ID</th>
        <th>가격</th>
        <th>예약취소</th>
        <th>인원</th>
        <th>날짜</th>
        <th>목적</th>
        <th>취소사유</th>
      </tr>
    </thead>
	<tfoot>
      <tr>
        <th>RID</th>
        <th>CID</th>
        <th>RRID</th>
        <th>PRICE</th>
        <th>RTYPE</th>
        <th>PERSON</th>
        <th>ACCOMO</th>
        <th>PURPOSE</th>
        <th>REASON</th>
      </tr>
	</tfoot>
    <tbody>
<c:forEach var="c" items="${reservelist }"><!-- for(Arraylist c: custlist){} 동일-->
	<tr>
	<td>${c.rid }</td>
	<td>${c.cid }</td>	
	<td>${c.rrid }</td>
	<td>${c.price }</td>
	<td>${c.rtype }</td>
	<td>${c.person }</td>
	<td>${c.date }</td>
	<td>${c.purpose }</td>
	<td>${c.reason }</td>
	</tr>
</c:forEach>
    </tbody>
  </table>
</div>