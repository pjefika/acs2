<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator"%>





<div class="container">

    <script type="text/html" id="detalhequip">
        <div>
            <acs-modal v-bind:data="equipamento" v-bind:body="modal.comp" v-bind:titulo="modal.titulo"></acs-modal>
            <div class="page-header">
                <h1>Detalhes do Equipamento: <span v-text="equipamento.deviceId.serialNumber"></span></h1>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <div class="row">
                        <div class="col-md-12">
                            <ul class="list-group">
                                <li v-bind:class="['list-group-item', equipamento.checkOn ? 'alert-success' : 'alert-danger']">
                                    <label>Status: </label>
                                    <span v-if="equipamento.checkOn">Ativo</span>
                                    <span v-else>Inativo</span>
                                </li>
                                <li class="list-group-item">
                                    <label>Serial:</label>
                                    <span v-text="equipamento.deviceId.serialNumber"></span>
                                </li>
                                <li class="list-group-item">
                                    <label>MAC:</label>
                                    <span v-text="equipamento.macAddress"></span>
                                </li>

                                <li class="list-group-item">
                                    <label>Subscriber Id:</label>
                                    <span v-text="equipamento.subscriberID"></span>
                                </li>

                                <li class="list-group-item">
                                    <label>Firmware: </label>
                                    <span v-if="equipamento.firmwareOk">Atualizado</span>
                                    <span v-else>Desatualizado</span>
                                    <button class="btn btn-danger" type="button">Atualizar</button>
                                </li>
                                <li class="list-group-item">
                                    <label>Nome do Modelo:</label>
                                    <span v-text="equipamento.modelName"></span>
                                </li>
                                <li class="list-group-item">
                                    <label>Fabricante:</label>
                                    <span v-text="equipamento.manufacturer"></span>
                                </li>
                                <li class="list-group-item">
                                    <label>IP:</label>
                                    <span v-text="equipamento.ipAddress"></span>
                                </li>
                                <li class="list-group-item">
                                    <label>Data Autenticação:</label>
                                    <span v-text="equipamento.dataAutenticacao()"></span>
                                </li>

                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-md-8">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="list-group" v-if="equipamento.isModem()">
                                <label class="list-group-item">Consultas</label>
                                <acs-button acao="Consultar WAN" comp="get-wan" v-bind:ativo="equipamento.checkOn"></acs-button>
                                <acs-button acao="Consultar Interface Statistics" comp="get-interface-statistics" v-bind:ativo="equipamento.checkOn"></acs-button>
                                <acs-button acao="Consultar LAN Host" comp="get-lan-hosts" v-bind:ativo="equipamento.checkOn"></acs-button>
                                <acs-button acao="Consultar xDSL" comp="get-xdsl-diagnostics" v-bind:ativo="equipamento.checkOn"></acs-button>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="list-group" v-if="equipamento.isModem()">
                                <label class="list-group-item">Ações</label>
                                <acs-button acao="Reiniciar" comp="reboot" v-bind:ativo="equipamento.checkOn"></acs-button>
                                <acs-button acao="Reset de Fábrica" comp="reset-factory" v-bind:ativo="equipamento.checkOn"></acs-button>
                                <!--                                <button type="button" class="list-group-item" data-toggle="modal" data-target="#modalFactory" data-backdrop="static">Reset de Fábrica</button>
                                                                <button type="button" class="list-group-item">Efetuar Traceroute</button>
                                                                <button type="button" class="list-group-item">Gerenciar DMZ</button>-->
                                <acs-button acao="Efetuar Ping" comp="get-ping" v-bind:ativo="equipamento.checkOn"></acs-button>
                                <acs-button acao="Gerenciar Port Mapping" comp="port-mapping" v-bind:ativo="equipamento.checkOn"></acs-button>
                                <acs-button acao="Configurar Wifi" comp="get-wifi" v-bind:ativo="equipamento.checkOn"></acs-button>
                                <acs-button acao="Configurar Autenticação PPPoE" comp="pppoe-credentials" v-bind:ativo="equipamento.checkOn"></acs-button>
                                <acs-button acao="Configurar DNS" comp="func-indisponivel" v-bind:ativo="equipamento.checkOn"></acs-button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </script>

    <div>
        <c:choose>
            <c:when test="${exception != null}">
                <alertpanel mensagem="Oi"></alertpanel>
                </c:when>
                <c:otherwise>
                <alertpanel v-bind:mensagem="'Oi'"></alertpanel>
                <detail v-bind:modal="modal" v-bind:eqp-string='${equipamento}'></detail>
                </c:otherwise>
            </c:choose>
    </div>
</div>

<script src="${pageContext.request.contextPath}/resources/vue-viewmodel/equipamento.js"></script>
<script src="${pageContext.request.contextPath}/resources/vue-viewmodel/equipamentoAdapter.js"></script>
<script src="${pageContext.request.contextPath}/resources/vue-viewmodel/xdslDiagnostics.js"></script>
<script src="${pageContext.request.contextPath}/resources/vue-viewmodel/wifiInfoFull.js"></script>
<script src="${pageContext.request.contextPath}/resources/vue-viewmodel/wanInfo.js"></script>
<script src="${pageContext.request.contextPath}/resources/vue-viewmodel/interfaceStatistics.js"></script>
<script src="${pageContext.request.contextPath}/resources/vue-viewmodel/portMappingInfo.js"></script>
<script src="${pageContext.request.contextPath}/resources/vue-viewmodel/pingInfo.js"></script>
<script src="${pageContext.request.contextPath}/resources/vue-viewmodel/pPPoECredentialsInfo.js"></script>

<script src="${pageContext.request.contextPath}/resources/vue-components/equipamento/request/getWifi.js"></script>
<script src="${pageContext.request.contextPath}/resources/vue-components/equipamento/request/getXdslDiagnostics.js"></script>
<script src="${pageContext.request.contextPath}/resources/vue-components/util/funcIndisponivel.js"></script>
<script src="${pageContext.request.contextPath}/resources/vue-components/equipamento/request/getInterfaceStatistics.js"></script>
<script src="${pageContext.request.contextPath}/resources/vue-components/equipamento/request/getWan.js"></script>
<script src="${pageContext.request.contextPath}/resources/vue-components/equipamento/request/reboot.js"></script>
<script src="${pageContext.request.contextPath}/resources/vue-components/equipamento/request/factoryReset.js"></script>
<script src="${pageContext.request.contextPath}/resources/vue-components/equipamento/request/getLanHosts.js"></script>
<script src="${pageContext.request.contextPath}/resources/vue-components/equipamento/request/pPPoECredentials.js"></script>
<script src="${pageContext.request.contextPath}/resources/vue-components/equipamento/request/portMapping.js"></script>
<script src="${pageContext.request.contextPath}/resources/vue-components/equipamento/request/getPing.js"></script>
<script src="${pageContext.request.contextPath}/resources/vue-components/equipamento/acsButton.js"></script>
<script src="${pageContext.request.contextPath}/resources/vue-components/equipamento/detalhe.js"></script>