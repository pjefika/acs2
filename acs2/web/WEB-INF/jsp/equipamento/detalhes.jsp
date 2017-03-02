<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator"%>
<div class="container">
    <script type="text/html" id="detalhequip">
        <div class="row">
            <div class="col-md-4">
                <div class="row">
                    <div class="col-md-12">
                        <img src="http://lojadomodem.com.br/media/catalog/product/cache/1/small_image/300x/17f82f742ffe127f42dca9de82fb58b1/0/0/00_1_4.jpg" 
                             v-bind:class="['img-responsive', eqp.checkOn ? 'onlineGreen' : 'offLineRed']"
                             style="padding: 0; width: 100%;">                       
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <ul class="list-group">
                            <li v-bind:class="['list-group-item', eqp.checkOn ? 'alert-success' : 'alert-danger']">
                                <label>CheckOnline: </label> 
                                <span v-if="eqp.checkOn">Ativo</span>
                                <span v-else>Inativo</span>
                            </li>
                            <li class="list-group-item">
                                <label>Firmware: </label> 
                                <span v-if="eqp.firmwareOk">Atualizado</span>
                                <span v-else>Desatualizado</span>
                                <button class="btn btn-danger" type="button" @click="updateFirmware()">Atualizar</button>
                            </li>                            
                            <li class="list-group-item">
                                <label>Status: </label> 
                                <span v-text="eqp.activated"></span>
                            </li>
                            <li class="list-group-item">
                                <label>MAC:</label>
                                <span v-text="eqp.macAddress"></span>
                            </li>
                            <li class="list-group-item">
                                <label>DeviceGUID:</label> 
                                <span v-text="eqp.deviceGUID"></span>
                            </li>                          
                            <li class="list-group-item">
                                <label>Fabricante:</label> 
                                <span v-text="eqp.manufacturer"></span>
                            </li>
                            <li class="list-group-item">
                                <label>Modelo:</label> 
                                <span v-text="eqp.model"></span>
                            </li>
                            <li class="list-group-item">
                                <label>Nome do Modelo:</label> 
                                <span v-text="eqp.modelName"></span>
                            </li>
                            <li class="list-group-item">
                                <label>Serial:</label> 
                                <span v-text="eqp.deviceId.serialNumber"></span>
                            </li>
                            <li class="list-group-item">
                                <label>Autenticação:</label> 
                                <span v-text="eqp.dateFormat(eqp.dataAutenticacao)"></span>
                            </li>
                            <li class="list-group-item">
                                <label>IP:</label> 
                                <span v-text="eqp.ipAddress"></span>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-md-8">
                <div class="row">
                    <div class="col-md-6">
                        <div class="list-group">
                            <label class="list-group-item">Consulta</label>
                            <button type="button" class="list-group-item">Consultar WAN</button>
                            <button type="button" class="list-group-item">Consultar Interface</button>
                            <button type="button" class="list-group-item">Consultar LAN Host</button>
                            <button type="button" class="list-group-item">Consultar Port Mapping</button>
                            <button type="button" class="list-group-item">Consultar xDSL</button>
                            <button type="button" class="list-group-item">Consultar DNS</button>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="list-group">
                            <label class="list-group-item">Ação</label>
                            <button type="button" class="list-group-item" data-toggle="modal" data-target="#modalReboot" data-backdrop="static">Reboot</button>
                            <button type="button" class="list-group-item" data-toggle="modal" data-target="#modalFactory" data-backdrop="static">Reset de Fábrica</button>
                            <button type="button" class="list-group-item">Efetuar Traceroute</button>
                            <button type="button" class="list-group-item">Gerenciar DMZ</button>
                            <button type="button" class="list-group-item">Efetuar Ping</button>
                            <button type="button" class="list-group-item">Gerenciar Port Mapping</button>
                            <button type="button" class="list-group-item">Configurar Wifi</button>
                            <button type="button" class="list-group-item">Configurar Autenticação PPPoE</button>
                            <button type="button" class="list-group-item">Alterar DNS</button>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Modal -->
            <div class="modal fade" id="modalReboot" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog modal-sm" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="myModalLabel">Reset</h4>
                        </div>
                        <div class="modal-body">
                            Deseja resetar o modem?
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                            <button type="button" class="btn btn-primary" @click="reboot()">Resetar</button>
                        </div>
                    </div>
                </div>
            </div>   
            <!-- Modal -->
            <div class="modal fade" id="modalFactory" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog modal-sm" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="myModalLabel">Reset de Fábrica</h4>
                        </div>
                        <div class="modal-body">
                            Deseja realizar o reset de fabrica no modem?
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                            <button type="button" class="btn btn-primary" @click="factoryReset()">Resetar</button>
                        </div>
                    </div>
                </div>
            </div> 
        </div>        
    </script>

    <div class="page-header">
        <h1>Detalhes Equipamento</h1>
    </div>
    <detail v-bind:eqp-string='${equipamento}'></detail> 


</div>
<script src="${pageContext.request.contextPath}/resources/vue-components/equipamento/equipamento.js"></script>
<script src="${pageContext.request.contextPath}/resources/vue-components/equipamento/detalhe.js"></script>
