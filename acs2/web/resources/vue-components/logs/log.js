/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global vm, Vue, moment */

var url = "/acs/log/";

var data = {
    input: null,
    pick: "matricula",
    logs: null,
    equipamento: null,
    valor: null,
    comp: null,
    wifiInfoFull: null,
    pPPoECred: null,
    portMapping: null
};

Vue.component("buscaLog", {
    template: "<div>\n\
                    <label class='radio-inline'>\n\
                        <input type='radio' name='optionspick' v-model='pick' value='matricula'/>\n\
                        Matrícula\n\
                    </label>\n\
                    <label class='radio-inline'>\n\
                        <input type='radio' name='optionspick' v-model='pick' value='parametro'/>\n\
                        Parâmetros\n\
                    </label>\n\
                    <div class='input-group'>\n\
                        <input type='text' class='form-control' v-model='input'/>\n\
                        <span class='input-group-btn'>\n\
                            <button type='button' class='btn btn-default' @click='buscar()'>Consultar</button>\n\
                        </span>\n\
                    </div>\n\
                    <tabela-log v-if='logs'></tabela-log>\n\
                </div>",
    data: function() {
        return data;
    },
    methods: {
        buscar: function() {
            var self = this;
            if (self.input) {
                if (self.pick === 'matricula') {
                    $.get(url + "usr/" + self.input, function(data) {
                        self.logs = data.list;
                        //console.log(data);
                    });
                } else {
                    $.get(url + "parametro/" + self.input, function(data) {
                        self.logs = data.list;
                        //console.log(data);
                    });
                }
            } else {

            }
        }
    }
});

Vue.component("tabelaLog", {
    template: "<div>\n\
                    <hr>\n\
                    <table class='table table-bordered'>\n\
                        <thead>\n\
                            <tr>\n\
                                <th>Login</th>\n\
                                <th>Ação</th>\n\
                                <th>Data</th>\n\
                                <th>Informações</th>\n\
                            </tr>\n\
                        </thead>\n\
                        <tbody>\n\
                            <tr v-for='log in logs' :key='log.id'>\n\
                                <td>{{log.login}}</td>\n\
                                <td>{{log.acao}}</td>\n\
                                <td>{{dateFormat(log.calendar)}}</td>\n\
                                <td>\n\
                                    <button type='button' class='btn btn-primary glyphicon glyphicon-menu-hamburger' @click='informacao(log)'></button>\n\
                                </td>\n\
                            </tr>\n\
                        </tbody>\n\
                    </table>\n\
                </div>",
    methods: {
        dateFormat: function(h) {
            return  moment(h).format('DD/MM/YYYY HH:mm:ss');
        },
        informacao: function(info) {
            var self = this;
            Vue.nextTick(function() {
                self.reset();
                self.splitInfos(info);
                self.validaValor(info);


                vm.modal = {
                    titulo: 'Carregando...',
                    comp: 'loading'
                };

                Vue.nextTick(function() {
                    vm.modal = {
                        titulo: 'Informações',
                        comp: 'info-log'
                    };
                    $("#actionModal").modal("show");
                })
            });
        },
        reset: function() {
            var self = this;
            self.comp = '';
        },
        splitInfos: function(info) {
            var self = this;
            if (info.equipamento) {
                self.equipamento = JSON.parse(info.equipamento);
            }
            if (info.valor) {
                self.valor = JSON.parse(info.valor);
            }
        },
        validaValor: function(info) {
            var self = this;
            if (info.acao === 'setWifiFull') {
                self.comp = 'info-wifi';
            } else if (info.acao === 'setPPPoECredentials') {
                self.comp = 'info-pppoe';
            } else if (info.acao === 'setPortMappingInfo') {
                self.comp = 'info-port-mapping';
            }
        }
    },
    data: function() {
        return data;
    }
});

Vue.component("infoLog", {
    template: "<div>\n\
                    <div class='modal-body'>\n\
                        <info-log-eqp></info-log-eqp>\n\
                        <hr/>\n\
                        <comp v-bind:is='comp'></comp>\n\
                    </div>\n\
                    <div class='modal-footer'>\n\
                        <button type='button' class='btn btn-default' data-dismiss='modal'>Fechar</button>\n\
                    </div>\n\
                </div>",
    data: function() {
        return data;
    }
});

Vue.component("infoLogEqp", {
    template: "<div>\n\
                    <table class='table table-bordered small'>\n\
                        <tbody>\n\
                            <tr>\n\
                                <td colspan='2' style='text-align: center;'><label>Equipamento</label></td>\n\
                            </tr>\n\
                            <tr>\n\
                                <td><label>deviceGUID</label></td>\n\
                                <td>{{equipamento.deviceGUID}}</td>\n\
                            </tr>\n\
                            <tr>\n\
                                <td><label>serialNumber</label></td>\n\
                                <td>{{equipamento.serialNumber}}</td>\n\
                            </tr>\n\
                            <tr>\n\
                                <td><label>ipAddress</label></td>\n\
                                <td>{{equipamento.ipAddress}}</td>\n\
                            </tr>\n\
                            <tr>\n\
                                <td><label>macAddress</label></td>\n\
                                <td>{{equipamento.macAddress}}</td>\n\
                            </tr>\n\
                            <tr>\n\
                                <td><label>manufacturer</label></td>\n\
                                <td>{{equipamento.manufacturer}}</td>\n\
                            </tr>\n\
                            <tr>\n\
                                <td><label>modelName</label></td>\n\
                                <td>{{equipamento.modelName}}</td>\n\
                            </tr>\n\
                            <tr>\n\
                                <td><label>subscriberID</label></td>\n\
                                <td>{{equipamento.subscriberID}}</td>\n\
                            </tr>\n\
                        </tbody>\n\
                    </table>\n\
                </div>",
    data: function() {
        return data;
    }
});

Vue.component("infoWifi", {
    template: "<div>\n\
                    <table class='table table-bordered small'>\n\
                        <tbody>\n\
                            <tr>\n\
                                <td colspan='2' style='text-align: center;'><label>Informação Wifi</label></td>\n\
                            </tr>\n\
                            <tr>\n\
                                <td><label>Estado da Rede Wifi:</label></td>\n\
                                <td>{{valor.operStatus}}</td>\n\
                            </tr>\n\
                            <tr>\n\
                                <td><label>SSID (Nome da Rede WiFi):</label></td>\n\
                                <td>{{valor.ssid}}</td>\n\
                            </tr>\n\
                            <tr>\n\
                                <td><label>Canal:</label></td>\n\
                                <td>{{valor.channel}}</td>\n\
                            </tr>\n\
                            <tr>\n\
                                <td><label>Senha:</label></td>\n\
                                <td>{{valor.key}}</td>\n\
                            </tr>\n\
                        </tbody>\n\
                    </table>\n\
                </div>",
    data: function() {
        return data;
    }
});

Vue.component("infoPppoe", {
    template: "<div>\n\
                    <table class='table table-bordered'>\n\
                        <tbody>\n\
                            <tr>\n\
                                <td colspan='2' style='text-align: center;'><label>Informações PPPoE</label></td>\n\
                            </tr>\n\
                            <tr>\n\
                                <td><label>Username:</label></td>\n\
                                <td>{{valor.username}}</td>\n\
                            </tr>\n\
                            <tr>\n\
                                <td><label>Password:</label></td>\n\
                                <td>{{valor.password}}</td>\n\
                            </tr>\n\
                        </tbody>\n\
                    </table>\n\
                </div>",
    data: function() {
        return data;
    }
});

Vue.component("infoPortMapping", {
    template: "<div>\n\
                    <table class='table table-bordered'>\n\
                        <tbody>\n\
                            <tr>\n\
                                <td colspan='2' style='text-align: center;'><label>Informações PPPoE</label></td>\n\
                            </tr>\n\
                            <tr>\n\
                                <td><label>Porta Externa:</label></td>\n\
                                <td>{{valor.externalPort}}</td>\n\
                            </tr>\n\
                            <tr>\n\
                                <td><label>Porta Interna:</label></td>\n\
                                <td>{{valor.internalPort}}</td>\n\
                            </tr>\n\
                            <tr>\n\
                                <td><label>IP Interno:</label></td>\n\
                                <td>{{valor.internalClient}}</td>\n\
                            </tr>\n\
                            <tr>\n\
                                <td><label>Protocolo:</label></td>\n\
                                <td>{{valor.protocol}}</td>\n\
                            </tr>\n\
                            <tr>\n\
                                <td><label>Ativo:</label></td>\n\
                                <td>{{valor.enable}}</td>\n\
                            </tr>\n\
                        </tbody>\n\
                    </table>\n\
                </div>",
    data: function() {
        return data;
    }
});