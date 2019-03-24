<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Редактирование</title>
   </head>
   <body>
 
      <jsp:include page="_header.jsp"></jsp:include>
      <jsp:include page="_menu.jsp"></jsp:include>
 
      <h3>Отредактировать бутер</h3>
 
      <p style="color: red;">${errorString}</p>
 
      <c:if test="${not empty sandwich}">
         <form method="POST" action="${pageContext.request.contextPath}/editSandwich">
            <input type="hidden" name="id" value="${sandwich.id}" />
            <table border="0">
               <tr>
                  <td>Id: </td>
                  <td style="color:red;">${sandwich.id}</td>
               </tr>
               <tr>
                  <td>Название: </td>
                  <td><input type="text" name="name" value="${sandwich.name}" /></td>
               </tr>
               <tr>
                  <td>Тип: </td>
                  <td><input type="text" name="price" value="${sandwich.type}" /></td>
               </tr>
                <tr>
                  <td>Время приготовления: </td>
                  <td><input type="text" name="price" value="${sandwich.minutes}" /></td>
               </tr>
                <tr>
                  <td>Подходящий хлебушек: </td>
                  <td><input type="text" name="price" value="${sandwich.bread}" /></td>
               </tr>
               <tr>
                  <td>Приготовление: </td>
                  <td><input type="text" name="price" value="${sandwich.comment}" /></td>
               </tr>
               <tr>
                  <td>Ингредиенты: </td>
                  <c:forEach items="${ingredients}" var="ingredients" >
          			<tr>
             		<td style = "padding-left: 30px;">${ingredients.component}  ${ingredients.unit}</td>
             		<td></td>
            		 <td>
                	<a href="deleteIngredient?comp_id=${ingredients.comp_id}&id=${sandwich.id}">Удалить</a>
             		</td>
          			</tr>
       			</c:forEach>
               </tr>
               <tr>
                  <td>Можно добавить: </td>
                  <c:forEach items="${all_ingredients}" var="all_ingredients" >
          			<tr>
             		<td style = "padding-left: 30px;">${all_ingredients.component}</td>
            		<td>
                	<a href="addIngredient?comp_id=${all_ingredients.comp_id}&id=${sandwich.id}">Добавить</a>
             		</td> 
          			</tr>
       			</c:forEach>
               </tr>
               <tr>
               <td>Дополнения: </td>
                  <c:forEach items="${additions}" var="additions" >
          			<tr>
             		<td style = "padding-left: 30px;">${additions.complement}  ${additions.type}</td>
             		<td></td>
            		 <td>
                	<a href="deleteAddition?add_id=${aditions.add__id}&id=${sandwich.id}">Удалить</a>
             		</td>
          			</tr>
       			</c:forEach>
               </tr>
               <tr>
                  <td>Можно добавить: </td>
                  <c:forEach items="${all_additions}" var="all_additions" >
          			<tr>
             		<td style = "padding-left: 30px;">${all_additions.complement}</td>
            		<td>
                	<a href="addAddition?add_id=${all_additions.add_id}&id=${sandwich.id}">Добавить</a>
             		</td> 
          			</tr>
       			</c:forEach>
               </tr>
               <tr>
                  <td colspan = "2">
                      <input type="submit" value="Submit" />
                      <a href="${pageContext.request.contextPath}/sandwichesList">Cancel</a>
                  </td>
               </tr>
            </table>
         </form>
      </c:if>
 
      <jsp:include page="_footer.jsp"></jsp:include>
 
   </body>
</html>