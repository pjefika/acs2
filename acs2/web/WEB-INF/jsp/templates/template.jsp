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
        <link href="${pageContext.request.contextPath}/resources/data-table/dataTables.min.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/resources/animateCss/animate.css" rel="stylesheet" />

        <!-- import JavaScript -->
        <script src="${pageContext.request.contextPath}/resources/jquery-3.1.1/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/node_modules/vue/dist/vue.js"></script>
        <script src="${pageContext.request.contextPath}/resources/lodash/lodash.js"></script>
        <script src="${pageContext.request.contextPath}/resources/moment/moment.js"></script>
        <script src="${pageContext.request.contextPath}/resources/progressbar/progressbar.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/bootstrap-3.3.7-dist/bootstrap-notify.js"></script>
        <script src="${pageContext.request.contextPath}/resources/data-table/dataTables.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/data-table/dataTables.bootstrap.min.js"></script>

        <script src="${pageContext.request.contextPath}/resources/vue-components/util/modal.js"></script>
        <script src="${pageContext.request.contextPath}/resources/vue-components/util/loading.js"></script>
        <script src="${pageContext.request.contextPath}/resources/vue-components/util/alertPanel.js"></script>
        <decorator:head/>
    </head>
    <body>

        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="${linkTo[HomeController].index()}">ACS</a>
                </div>
                <div id="navbar" class="collapse navbar-collapse" v-cloak>
                    <c:if test="${sessionUsuarioEfika.logado}">
                        <ul class="nav navbar-nav">
                            <li><a href="${linkTo[SearchController].create()}">Busca</a></li>
                            <li><a href="${linkTo[LogController].create()}">Logs</a></li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li>
                                <a href="${linkTo[UsuarioController].logout()}">Sair</a>
                            </li>
                        </ul>
                        </li>
                        </ul>
                    </c:if>
                </div><!--/.nav-collapse -->
            </div>
        </nav>
        <div id="instancia" v-cloak>
            <div id="bar"></div>
            <decorator:body/>
        </div>

    </div>
    <!-- /container -->
    <script src="${pageContext.request.contextPath}/resources/vue-components/template.js"></script>
</body>
</html>

