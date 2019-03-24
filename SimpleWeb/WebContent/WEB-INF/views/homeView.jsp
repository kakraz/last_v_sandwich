<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
     <meta charset="UTF-8">
     <title>Home Page</title>
     <style>
     body { margin: 0; }
    #sidebar, #content { position: absolute; } 
   #sidebar, #content { overflow: auto; padding: 10px; }
   #header {
    height: 80px; /* Высота слоя */
    background: #FFE29E; 
    border-bottom: 2px solid #7B5427;
   }
   #header h3 { padding: 10px; margin: 0; font-size: 14 pt;}
   #sidebar { 
    width: 150px; 
    background: #FFCE7A; 
    border-right: 1px solid #231F20;
    top: 90px; /* Расстояние от верхнего края */ 
    bottom: 0; /* Расстояние снизу  */
    
   }
   #content {
    background: #FFECC0;
    opacity: 80;
    top: 90px; /* Расстояние от верхнего края */
    left: 170px; /* Расстояние от левого края */ 
    bottom: 0; 
    right: 0;
   }
</style>
  </head>
  <body>
     <jsp:include page="_header.jsp"></jsp:include>
     <jsp:include page="_menu.jsp"></jsp:include>
     
     <div id="header"><h3>Пробую тыкать на кнопки</h3></div>
  <div id="sidebar">
  <h3>Ингредиенты</h3>
  <div>
  <input id='one' type='checkbox' />
  <label for='one'>
    Огурки
  </label>
  </div>
  <div>
  <input id='two' type='checkbox' />
  <label for='two'>
    Яйки
  </label>
  </div>
  <div>
  <input id='three' type='checkbox' />
  <label for='three'>
    Колбаса
  </label>
  
    <h3>Тип бутера</h3>
  <div>
  <div>
    <input type="radio" id="contactChoice1" name="type" value="sytnyi">
    <label for="contactChoice1">Сытный</label> </div>
	<div>
    <input type="radio" id="contactChoice2" name="type" value="sladkyi">
    <label for="contactChoice2">Сладкий</label></div>
	<div>
    <input type="radio" id="contactChoice3" name="type" value="vegan">
    <label for="contactChoice3">Веганский</label></div>
  </div>
  </div>
  </div>
  <div>
    <button type="submit">Найти бутер!</button>
  </div>
  <div id="content">
   <h2>Помогите</h2>
   <p>Пожалуйста</p>
  </div>
 
     <jsp:include page="_footer.jsp"></jsp:include>
  </body>
</html>