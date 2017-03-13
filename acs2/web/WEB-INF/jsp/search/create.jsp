<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator"%>

<div class="container">
    <div class="page-header">
        <h1>Buscar Equipamentos</h1>
    </div>
    <div class="row">
        <component :is="currentView"></component>
    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/vue-components/searchact.js"></script>
