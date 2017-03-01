<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <title><decorator:title default="ACS"/></title>
        <meta charset="utf-8">

        <!-- import CSS -->
        <link href="${pageContext.request.contextPath}/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/resources/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/resources/custom/custom.css" rel="stylesheet" />

        <!-- import JavaScript -->
        <script src="${pageContext.request.contextPath}/resources/jquery-3.1.1/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/node_modules/vue/dist/vue.js"></script>
        <script src="${pageContext.request.contextPath}/resources/lodash/lodash.js"></script>
        <script src="${pageContext.request.contextPath}/resources/moment/moment.js"></script>
        <script src="${pageContext.request.contextPath}/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

        <decorator:head/>
    </head>
    <body>       
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="${linkTo[HomeController].index()}">ACS_2</a>
                </div>
                <div id="navbar" class="collapse navbar-collapse" v-cloak>
                    <c:if test="${sessionUsuarioEfika.logado}">
                        <ul class="nav navbar-nav">
                            <li><a href="${linkTo[SearchController].create()}">Busca</a></li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-user"></span>Perfil <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li>
                                        <div class="navbar-login">
                                            <div class="row">
                                                <div class="col-lg-4">
                                                    <p class="text-center">
                                                        <img src="http://portalcolaboradores/idc/portalcolaboradores/userimages/${sessionUsuarioEfika.usuario.login}.jpg" alt="User" class="img-rounded" style="width: 90px; height: 100px;">
                                                    </p>
                                                </div>
                                                <div class="col-lg-7">
                                                    <p class="text-left"><strong>Nome</strong></p>
                                                    <p class="text-left small">nome.sobrenome@telefonica.com</p>
                                                    <p class="text-left">
                                                        <a href="#" class="btn btn-primary btn-block btn-sm">Meu Perfil</a>
                                                    </p>
                                                </div>
                                                <div class="col-lg-1"></div>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="divider"></li>
                                    <li>
                                        <div class="navbar-login navbar-login-session">
                                            <div class="row">
                                                <div class="col-lg-12">
                                                    <p>
                                                        <a href="${linkTo[UsuarioController].logout()}" class="btn btn-danger btn-block">Sair</a>
                                                    </p>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </c:if>
                </div><!--/.nav-collapse -->                
            </div>            
        </nav>

        <div>
            <decorator:body/>
            <!-- Loading Modal -->
            <div class="modal fade" id="loadingModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static" data-keyboard="false">
                <div class="modal-dialog modal-sm" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title" id="myModalLabel">Aguarde ...</h4>
                        </div>
                        <div class="modal-body" style="text-align: center;">                    
                            <img src="${pageContext.request.contextPath}/resources/imagens/loading.gif">                    
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- /container -->                  
    </body>
</html>
