<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator"%>

<div class="container" id="search" v-cloack>

    <div class="page-header">
        <h1>Buscar Equipamentos</h1>
    </div>
    <search-action></search-action>    
    <div>        
        <label class="radio-inline">            
            <input type="radio" Value="MAC" v-model="picked" name="pickedSearch"/> MAC
        </label>
        <label class="radio-inline">            
            <input type="radio" Value="GUID" v-model="picked" name="pickedSearch"/> GUID
        </label>
        <label class="radio-inline">            
            <input type="radio" Value="Subscriber" v-model="picked" name="pickedSearch"/> Subscriber
        </label>
        <label class="radio-inline">            
            <input type="radio" Value="Serial" v-model="picked" name="pickedSearch"/> Serial
        </label>
    </div>
    <br/>
    <br/>
    <search-table></search-table>

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
