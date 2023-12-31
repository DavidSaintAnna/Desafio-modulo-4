<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="icon" href="./assets/img/book-2-fill.svg" type="image/svg" />
<link rel="stylesheet" href="./assets/css/style.css" />
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
<title>Booki | Atualizar Passagem</title>
</head>
<body>
	<main>
		<header class="header">
			<h1>Atualizar Passagem</h1>
		</header>
		
		
		<div class="container py-3">
            <form action="./passagem-update">
	            <h2 class="text-center">Atualizar</h2>
	            <input type="hidden" id="id" name="id" class="form-control" value="${passagem.id}" />
<!-- 	            <div class="form-group mb-3"> -->
<!-- 	                <label for="nome" class="form-label"> -->
<!-- 	                    id -->
<!-- 	                </label> -->
<%-- 	                <input type="text" id="id" name="id" class="form-control" value="${usuario.id}" readonly/> --%>
<!-- 	            </div> -->
	            <div class="form-group mb-3">
	                <label for="nome" class="form-label">
	                    Nome
	                </label>
	                <input type="text" id="nome" name="nome" class="form-control" value="${passagem.nome}" />
	            </div>
	            
	            <div class="form-group mb-3">
	                <label for="dataDeChegada" class="form-label">
	                    dataDeChegada
	                </label>
	                <input type="date" id="dataDeChegada" name="dataDeChegada" class="form-control" value="${passagem.dataDeChegada}" />
	            </div>
	            
	            <div class="form-group mb-3">
	                <label for="dataDeSaida" class="form-label">
	                   dataDeSaida
	                </label>
	                <input type="date" id="dataDeSaida" name="dataDeSaida" class="form-control" value="${passagem.dataDeSaida}" />
	            </div>
	            
	             <div class="form-group mb-3">
	                <label for="dataDeRetorno" class="form-label">
	                dataDeRetorno
	                </label>
	                <input type="date" id="dataDeRetorno" name="dataDeRetorno" class="form-control" value="${passagem.dataDeRetorno}" />
	            </div>
	            
	            <div class="form-group mb-3">
	                <label for="preco" class="form-label">
	                    Pre�o
	                </label>
	                <input type="number" id="preco" name="preco" class="form-control" step="0.01" value="${passagem.preco}" />
	            </div>
	            
	            <button type="submit" class="btn btn-primary">
	                Enviar
	            </button>
	            <a href="./passagem" class="btn btn-danger" style="margin-left: 10px">
	                Cancelar
	            </a>
            </form>
        </div>
		
    </main>
    

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>