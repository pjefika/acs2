<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator"%>

<div class="container">

    <div class="page-header">
        <h1>Login</h1>
    </div>
    <div id="login" class="boxlogin">
        <form action="${linkTo[UsuarioController].login}" method="post">
            <div class="form-group">
                <label>Login:</label>
                <input type="text" class="form-control" placeholder="Insira seu login" name="u.login">
            </div>
            <div class="form-group">
                <label >Senha:</label>
                <input type="password" class="form-control" placeholder="Insira sua Senha" name="u.senha">
            </div>            
            <button type="submit" class="btn btn-default" id="enterButton">Entrar</button>
            
            <br/>
            <br/>
            
            <c:if test="${not empty mensagemFalha}">                
                <div class="alert alert-danger">${mensagemFalha}</div>
            </c:if>           

        </form>
    </div>
</div>