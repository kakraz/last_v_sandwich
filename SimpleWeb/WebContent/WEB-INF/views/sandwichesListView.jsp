<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>List</title>
 </head>
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
 
    <h3>Список бутеров</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>id</th>
          <th>Название</th>
          <th>Тип</th>
          <th>Редактировать</th>
       </tr>
       <c:forEach items="${sandwichesList}" var="sandwiches" >
          <tr>
             <td>${sandwiches.id}</td>
             <td>${sandwiches.name}</td>
             <td>${sandwiches.type}</td>
             <td>
                <a href="editSandwich?id=${sandwiches.id}">Редактировать</a>
             </td>
          </tr>
       </c:forEach>
    </table>
 
    <a href="createSandwich">Добавить бутер</a>
 
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>