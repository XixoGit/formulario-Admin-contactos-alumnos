<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <style type="text/css">

/* PAGINA */
body {
	font-family: sans-serif;
	margin: 0.5in;     /* El cuerpo de la página debe mostrar un margen de media pulgada */
}
h1 {
	color: blue;
	font-family: Arial;
	font-size: large;
} 
p {
	color: gray;
	font-family: Verdana;
	font-size: medium;
}

 

/* EMPIEZA EL FORMULARIO */
h2 {
	font: normal 2em arial, sans-serif;
	margin: 0;
}
.izquierda {
	float: left;
	clear: left;
}
ul {
	list-style: none;
	margin: 0;
	padding: 0;
}
#contenedor {
	background: #FFF;
	border: 1px solid silver;
	margin: 1em auto;
	padding: 1em;
	width: 768px;
}
span.requerido {
	font-size: 1.3em;
	font-weight: bold;
	color: #C00;
}
ul li.botones {
	border-top: 2px solid #CCC;
	clear: both;
	float: none;
	padding: 1em 0;
	margin-top: 1em;
	text-align: right;
	width: 100%;
}
ul li.botones input {
	font-size: 1.3em;
}
ul li {
	margin: 0.5em 0;
	padding: 0.5em;
	width: 46%;
}
ul li label.titulo {
	font-weight: bold;
}
ul li div span {
	float: left;
	padding: 0.3em 0;
}
ul li div span.completo {
	width: 100%;
}
ul li div span.mitad {
	width: 50%;
}
ul li div span.tercio {
	width: 33%;
}
ul li div span.dostercios {
	width: 66%;
}
ul li div span label {
	display: block;
	font: normal 0.8em arial, sans-serif;
	color: #333;
}
ul li p.ayuda {
	display: none;
}
ul li input {
	padding: 0.2em;
}
input#apellido1, input#email {
	width: 260px;
}

input#telefonofijo{
width:135px;
}

/* Cambiar el color en el :hover y resaltar los campos en el :focus */
ul li:hover {
	background-color: #98FB98; /* color verde */
}
ul li.botones:hover {
	background-color: transparent;
}
ul li input:focus {
	border: 2px solid #E6B700;
}
/* Formatear el formulario a una columna */
ul li.izquierda, ul li.derecha {
	float: none;
	width: auto;
}
ul li {
	overflow: hidden;
}
ul li label.titulo {
	float: left;
	width: 150px;
}
ul li div {
	margin-left: 160px;
}

/* Aspecto final del formulario con los mensajes de ayuda */
h2 {
	margin-bottom: 0.3em;
}
ul li {
	border-top: 1px solid #CCC;
	margin: 0;
	padding: 1em;
}
ul li.botones {
	margin: 0;
}
ul li label.titulo {
	text-align: right;
	width: 100px;
}
ul li div {
	margin-left: 110px;
	overflow: hidden;
}
ul li {
	position: relative;
}
ul li:hover p.ayuda {
	display: block;
	margin: 0.3em;
	position: absolute;
	top: 0;
	right: 0;
	width: 150px;
}

/* TERMINA EL FORMULARIO*/
/* TABLA */
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
<title>Formulario de Registro de Contactos</title>
</head>

<body> 
<div id="contenedor">
 
<h2>Formulario de alta</h2>

	<form:form method="post" action="add.html" commandName="contacto">
		<ul>
		<!-- ++++++++++++++++++++++++++++++++++ -->
		    <li class="izquierda">
		    <label class="titulo" for="nombre">Nombre y Apellido <span class="requerido">*</span></label>
				<div>
					<span class="completo"> 
					   <form:input path="firstname" /> 
					   <form:label path="firstname">
					      <spring:message code="label.firstname" />
					   </form:label>
					</span> 
					<span class="completo"> 
					   <form:input path="lastname" /> 
					   <form:label path="lastname">
						  <spring:message code="label.lastname" />
					   </form:label>
					</span>

				</div>
					<p class="ayuda">No te olvides de escribir también tu segundo apellido</p>
			</li>
		<!-- ++++++++++++++++++++++++++++++++++ -->
          <li class="izquierda">
            <label class="titulo" for="email">E-mail<span class="requerido">*</span></label>
				<div>
							<span class="completo"> 
							   <form:input path="email" /> 
							   <form:label path="email">
									<spring:message code="label.email" />
								</form:label>
							</span>
				</div>
				<p class="ayuda">Asegúrate de que sea válido</p>
			</li>
		<!-- ++++++++++++++++++++++++++++++++++ -->
             <li class="derecha">
             <label class="titulo" for="telefonofijo">Teléfono<span class="requerido">*</span></label>
					<div>
							<span class="mitad"> 
							<form:input path="telephone" /> 
							<form:label path="telephone">
									<spring:message code="label.telephone" />
							</form:label>
							</span>
					</div>
					<p class="ayuda">Sin prefijo de país y sin espacios en blanco</p>
			</li>
					<!-- ++++++++++++++++++++++++++++++++++ -->
			<li class="botones"><input id="alta" type="submit"	value="<spring:message code="label.addcontact"/>" />
			</li>
		</ul>
	</form:form>
</div>
 
 <!-- TABLA -->
<h3>Contactos</h3>

<c:if test="${!empty listadoContactos}">
		
		<table class="data">
			<tr>
				<th><spring:message code="label.firstname" /></th>
				<th><spring:message code="label.email" /></th>
				<th><spring:message code="label.telephone" /></th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${listadoContactos}" var="contact">
				<tr>
					<td>${contact.lastname},${contact.firstname}</td>
					<td>${contact.email}</td>
					<td>${contact.telephone}</td>
					<td><a href="delete/${contact.id}">Eliminar</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
<!--  ++++++++++++++++++++++++++++L -->
</body>
</html>