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
</div>
<script src="${pageContext.request.contextPath}/resources/vue-components/searchact.js"></script>
