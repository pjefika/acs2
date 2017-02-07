<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator"%>

<div class="container">

    <div class="page-header">
        <h1>Buscar Equipamentos</h1>
    </div>

    <div class="row">
        <div class="col-lg-6">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Search for...">
                <span class="input-group-btn">
                    <button class="btn btn-default" type="button">Buscar</button>
                </span>
            </div><!-- /input-group -->
        </div><!-- /.col-lg-6 -->
    </div>
    
    <br/>
    <br/>
    
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>ID do Assinante</th>
                <th>Número de Série</th>
                <th>IP</th>
                <th>MAC</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td></td>
                <td>CTA-81E2J3HSS-013</td>
                <td>177.16.212.159</td>
                <td>8C:10:D4:DA:15:50</td>
                <td><a href="${linkTo[SearchController].action()}">Selecionar</a></td>
            </tr>
        </tbody>
    </table>

</div>