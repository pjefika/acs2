<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator"%>
<div class="container">
    <script type="text/html" id="detalhequip">
        <div>
            <acs-modal v-bind:data='${equipamento}' v-bind:body="modal.comp" v-bind:titulo="modal.titulo"></acs-modal>
            <div class="page-header">
                <h1>Detalhes do Equipamento: <span v-text="eqp.deviceId.serialNumber"></span></h1>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <div class="row">
                        <div class="col-md-12">
                            <ul class="list-group">
                                <li v-bind:class="['list-group-item', eqp.checkOn ? 'alert-success' : 'alert-danger']">
                                    <label>Status: </label>
                                    <span v-if="eqp.checkOn">Ativo</span>
                                    <span v-else>Inativo</span>
                                </li>
                                <li class="list-group-item">
                                    <label>Serial:</label>
                                    <span v-text="eqp.deviceId.serialNumber"></span>
                                </li>
                                <li class="list-group-item">
                                    <label>MAC:</label>
                                    <span v-text="eqp.macAddress"></span>
                                </li>

                                <li class="list-group-item">
                                    <label>Subscriber Id:</label>
                                    <span v-text="eqp.subscriberID"></span>
                                </li>

                                <li class="list-group-item">
                                    <label>Firmware: </label>
                                    <span v-if="eqp.firmwareOk">Atualizado</span>
                                    <span v-else>Desatualizado</span>
                                    <button class="btn btn-danger" type="button" @click="updateFirmware()">Atualizar</button>
                                </li>
                                <li class="list-group-item">
                                    <label>Nome do Modelo:</label>
                                    <span v-text="eqp.modelName"></span>
                                </li>
                                <li class="list-group-item">
                                    <label>Fabricante:</label>
                                    <span v-text="eqp.manufacturer"></span>
                                </li>
                                <li class="list-group-item">
                                    <label>IP:</label>
                                    <span v-text="eqp.ipAddress"></span>
                                </li>
                                <li class="list-group-item">
                                    <label>Data Autenticação:</label>
                                    <span v-text="eqp.dataAutenticacao()"></span>
                                </li>

                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-md-8">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="list-group" v-if="eqp.isModem()">
                                <label class="list-group-item">Consultas</label>
                                <acs-button acao="Consultar WAN" v-bind:ativo="eqp.checkOn" @click="setComp('get-wifi','Consultar WAN')"></acs-button>
                                <acs-button acao="Consultar Interface" v-bind:ativo="eqp.checkOn"></acs-button>
                                <acs-button acao="Consultar LAN Host" v-bind:ativo="eqp.checkOn"></acs-button>
                                <acs-button acao="Consultar Port Mapping" v-bind:ativo="eqp.checkOn"></acs-button>
                                <acs-button acao="Consultar xDSL" v-bind:ativo="eqp.checkOn"></acs-button>
                                <acs-button acao="Consultar DNS" v-bind:ativo="eqp.checkOn"></acs-button>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="list-group" v-if="eqp.isModem()">
                                <label class="list-group-item">Ações</label>
                                <button type="button" class="list-group-item" data-toggle="modal" data-target="#modalReboot" data-backdrop="static">Reboot</button>
                                <button type="button" class="list-group-item" data-toggle="modal" data-target="#modalFactory" data-backdrop="static">Reset de Fábrica</button>
                                <button type="button" class="list-group-item">Efetuar Traceroute</button>
                                <button type="button" class="list-group-item">Gerenciar DMZ</button>
                                <button type="button" class="list-group-item">Efetuar Ping</button>
                                <button type="button" class="list-group-item">Gerenciar Port Mapping</button>
                                <acs-button acao="Configurar Wifi" v-bind:ativo="eqp.checkOn" v-on:click="setComp('get-wifi','Configurar Wifi')"></acs-button>

                                <button type="button" class="list-group-item">Configurar Autenticação PPPoE</button>
                                <button type="button" class="list-group-item">Alterar DNS</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </script>

    <detail v-bind:eqp-string='${equipamento}'></detail>



</div>
<script src="${pageContext.request.contextPath}/resources/vue-components/util/modal.js"></script>
<script src="${pageContext.request.contextPath}/resources/vue-components/equipamento/equipamento.js"></script>
<script src="${pageContext.request.contextPath}/resources/vue-components/equipamento/wifiInfo.js"></script>
<script src="${pageContext.request.contextPath}/resources/vue-components/equipamento/request/getWifi.js"></script>
<script src="${pageContext.request.contextPath}/resources/vue-components/equipamento/acsButton.js"></script>
<script src="${pageContext.request.contextPath}/resources/vue-components/equipamento/detalhe.js"></script>
