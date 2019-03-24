<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Create</title>
   </head>
   <body>
    
      <jsp:include page="_header.jsp"></jsp:include>
      <jsp:include page="_menu.jsp"></jsp:include>
       
      <h3>Создание бутера</h3>
       
      <p style="color: red;">${errorString}</p>
       
      <form method="POST" action="${pageContext.request.contextPath}/createSandwich">
         <table border="0">
            <tr>
               <td>Id: </td>
               <td><input type="text" name="id" value="${sandwich.id}" /></td>
            </tr>
            <tr>
               <td>Название: </td>
               <td><input type="text" name="name" value="${sandwich.name}" /></td>
            </tr>
            <tr>
               <td>Тип: </td>
               <td><input type="text" name="type" value="${sandwich.type}" /></td>
            </tr>
            <tr>
               <td>Время приготовления: </td>
               <td><input type="text" name="minutes" value="${sandwich.minutes}" /></td>
            </tr>
            <tr>
               <td>Подходящий хлебушек: </td>
               <td><input type="text" name="bread" value="${sandwich.bread}" /></td>
            </tr>
            <tr>
               <td>Приготовление: </td>
               <td><input type="text" name="comment" value="${sandwich.comment}" /></td>
            </tr>
            <tr>
               <td colspan="2">                   
                   <input type="submit" value="Submit" />
                   <a href="sandwichesList">Cancel</a>
               </td>
            </tr>
         </table>
      </form>
       
      <jsp:include page="_footer.jsp"></jsp:include>
       
   </body>
</html>