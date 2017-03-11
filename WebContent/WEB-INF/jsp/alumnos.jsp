<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<head>
	 <style type="text/css">
		body {
			font-family: sans-serif;
		}
		.data, .data td {
			border-collapse: collapse;
			width: 80%;
			border: 1px solid #aaa;
			margin: 2px;
			padding: 2px;
		}
		.data th {
			font-weight: bold;
			background-color: #5C82FF;
			color: white;
		}
	</style>
</head>
</head>
<body>
<h2><spring:message code="label.title"/></h2>
 <form:form method="post" action="agrega.html" commandName="alumnocomand">
    <table>
	<tr>
		<td><form:label path="nombre"><spring:message code="label.nombre"/></form:label></td>
		<td><form:input path="nombre" /></td> 
	</tr>
	<tr>
		<td><form:label path="apellido"><spring:message code="label.apellido"/></form:label></td>
		<td><form:input path="apellido" /></td>
	</tr>
	<tr>
		<td><form:label path="email"><spring:message code="label.emailal"/></form:label></td>
		<td><form:input path="email" /></td>
	</tr>
	<tr>
		<td><form:label path="telefono"><spring:message code="label.telefono"/></form:label></td>
		<td><form:input path="telefono" /></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="<spring:message code="label.addalu"/>"/>
		</td>
	</tr>
</table>	
</form:form>

	
<h3>Alumnos</h3>
<c:if  test="${!empty listadoAlum}">
  <table class="data">
     <tr>
	    <th><spring:message code="label.nombre"/></th>
	    <th><spring:message code="label.emailal"/></th>
	    <th><spring:message code="label.telefono"/></th>
	   <th>&nbsp;</th>
     </tr>
     <c:forEach items="${listadoAlum}" var="alu">
	   <tr>
	    	<td>${alu.apellido}, ${alu.nombre} </td>
		    <td>${alu.email}</td>
		    <td>${alu.telefono}</td>
		    <td><a href="elimina/${alu.id}">Eliminar</a> / <a href="modifica/${alu.id}">Editar</a></td>
	  </tr>
    </c:forEach>
  </table>
</c:if>

</body>
</html>