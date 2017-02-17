<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator"%>

<div class="container" id="search">

    <div class="page-header">
        <h1>Buscar Equipamentos</h1>
    </div>

    <search-action></search-action>

    <br/>
    <br/>

    <table class="table table-bordered" style="text-align: center;">
        <thead>
            <tr>
                <th>ID do Assinante</th>
                <th>Subscriber</th>
                <th>IP</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="eqp in listaEqp" :key="eqp.deviceGUID">
                <td>{{eqp.deviceGUID}}</td>
                <td>{{eqp.subscriberID}}</td>
                <td>{{eqp.ipAddress}}</td>
                <td><a href="${linkTo[SearchController].action()}">Selecionar</a></td>
            </tr>
        </tbody>
    </table>

    <!-- Modal -->
    <div class="modal fade" id="loadingModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog modal-sm" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title" id="myModalLabel">Aguarde...</h4>
                </div>
                <div class="modal-body" style="text-align: center;">                    
                    <img src="${pageContext.request.contextPath}/resources/imagens/loading.gif">                    
                </div>
            </div>
        </div>
    </div>

</div>
<script src="${pageContext.request.contextPath}/resources/vue-components/searchact.js"></script>
