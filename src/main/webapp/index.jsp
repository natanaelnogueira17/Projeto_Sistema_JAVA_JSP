<%@page import="org.apache.jasper.tagplugins.jstl.core.Out"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang = en>
<head>
<meta charset="ISO-8859-1">

<meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" 
    rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" 
    crossorigin="anonymous">
    
<title>Curso JSP</title>

<style type="text/css">
form{
	position: absolute;
	top: 40%;
	left: 33%;
	
}

h4{
	position: absolute;
	top: 30%;
	left: 33%;
	font: bold;
	color: purple;
}
h5{
	position: absolute;
	top: 80%;;
	left: 33%;
	color: red;
	font: bold;
}
</style>
</head>
<body>
	<h4>Bem Vindo ao Curso JSP</h1>

	<form action="ServletLogin" method="post" class="row g-3 needs-validation" novalidate >
	<input type="hidden" value = "<%= request.getParameter("url") %>" name = "url">
			<div class="col-md-6">
				<label class="form-label">Login</label>
				<input  class="form-control" name="Login" type="text" required>
				<div class="invalid-feedback">
					Obrigatorio
				</div>
				<div class="valid-feedback">
					OK
				</div>
			 </div>			 
			 <div class="col-md-6">
				<label class = "form-label">Senha</label >
				<input   class="form-control" name="Senha" type="password" required >	
				<div class="invalid-feedback">
					Obrigatorio
				</div>
				<div class="valid-feedback">
					OK
				</div>
			 </div>	
					
			<input class="btn btn-primary" type="submit" value="Acessar" class="btn btn-primary">
	</form>
	
	<h5>${msg}</h4>



    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>

	<script type="text/javascript">
	
	(() => {
		  'use strict'

		  // Fetch all the forms we want to apply custom Bootstrap validation styles to
		  const forms = document.querySelectorAll('.needs-validation')

		  // Loop over them and prevent submission
		  Array.from(forms).forEach(form => {
		    form.addEventListener('submit', event => {
		      if (!form.checkValidity()) {
		        event.preventDefault()
		        event.stopPropagation()
		      }

		      form.classList.add('was-validated')
		    }, false)
		  })
		})()
	
	</script>

</body>
</html>