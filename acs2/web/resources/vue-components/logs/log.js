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
                    <table class='table table-bordered small'>\n\
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
                console.log("entro info");
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
                        <div class='panel panel-default'>\n\
                            <div class='panel-heading'>Equipamento</div>\n\
                            <div class='panel-body'>\n\
                                <info-log-eqp></info-log-eqp>\n\
                            </div>\n\
                        </div>\n\
                        <div class='panel panel-default'>\n\
                            <div class='panel-heading'>Valor</div>\n\
                            <div class='panel-body'>\n\
                                <comp v-bind:is='comp'></comp>\n\
                            </div>\n\
                        </div>\n\
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
                    <!-- <div class='row'>\n\
                        <div class='col-md-2'><label>deviceGUID:</label></div>\n\
                        <div class='col-md-4'>{{equipamento.deviceGUID}}</div>\n\
                    </div> -->\n\
                    <div class='row'>\n\
                        <div class='col-md-2'><label>serialNumber:</label></div>\n\
                        <div class='col-md-4'>{{equipamento.serialNumber}}</div>\n\
                    </div>\n\
                    <div class='row'>\n\
                        <div class='col-md-2'><label>ipAddress:</label></div>\n\
                        <div class='col-md-4'>{{equipamento.ipAddress}}</div>\n\
                    </div>\n\
                    <div class='row'>\n\
                        <div class='col-md-2'><label>macAddress:</label></div>\n\
                        <div class='col-md-4'>{{equipamento.macAddress}}</div>\n\
                    </div>\n\
                    <div class='row'>\n\
                        <div class='col-md-2'><label>manufacturer:</label></div>\n\
                        <div class='col-md-4'>{{equipamento.manufacturer}}</div>\n\
                    </div>\n\
                    <div class='row'>\n\
                        <div class='col-md-2'><label>modelName:</label></div>\n\
                        <div class='col-md-4'>{{equipamento.modelName}}</div>\n\
                    </div>\n\
                    <div class='row'>\n\
                        <div class='col-md-2'><label>subscriberID:</label></div>\n\
                        <div class='col-md-4'>{{equipamento.subscriberID}}</div>\n\
                    </div>\n\
                </div>",
    data: function() {
        return data;
    }
});

Vue.component("infoWifi", {
    template: "<div>\n\
                    <div class='row'>\n\
                        <div class='col-md-3'><label>Estado da Rede Wifi:</label></div>\n\
                        <div class='col-md-4'>{{valor.operStatus}}</div>\n\
                    </div>\n\
                    <div class='row'>\n\
                        <div class='col-md-3'><label>SSID (Nome da Rede WiFi):</label></div>\n\
                        <div class='col-md-4'>{{valor.ssid}}</div>\n\
                    </div>\n\
                    <div class='row'>\n\
                        <div class='col-md-3'><label>Canal:</label></div>\n\
                        <div class='col-md-4'>{{valor.channel}}</div>\n\
                    </div>\n\
                    <div class='row'>\n\
                        <div class='col-md-3'><label>Senha:</label></div>\n\
                        <div class='col-md-4'>{{valor.key}}</div>\n\
                    </div>\n\
                </div>",
    data: function() {
        return data;
    }
});

Vue.component("infoPppoe", {
    template: "<div>\n\
                    <div class='row'>\n\
                        <div class='col-md-2'><label>Username:</label></div>\n\
                        <div class='col-md-4'>{{valor.username}}</div>\n\
                    </div>\n\
                    <div class='row'>\n\
                        <div class='col-md-2'><label>Password:</label></div>\n\
                        <div class='col-md-4'>{{valor.password}}</div>\n\
                    </div>\n\
                </div>",
    data: function() {
        return data;
    }
});

Vue.component("infoPortMapping", {
    template: "<div>\n\
                    <div class='row'>\n\
                        <div class='col-md-2'><label>Porta Externa:</label></div>\n\
                        <div class='col-md-4'>{{valor.externalPort}}</div>\n\
                    </div>\n\
                    <div class='row'>\n\
                        <div class='col-md-2'><label>Porta Interna:</label></div>\n\
                        <div class='col-md-4'>{{valor.internalPort}}</div>\n\
                    </div>\n\
                    <div class='row'>\n\
                        <div class='col-md-2'><label>IP Interno:</label></div>\n\
                        <div class='col-md-4'>{{valor.internalClient}}</div>\n\
                    </div>\n\
                    <div class='row'>\n\
                        <div class='col-md-2'><label>Protocolo:</label></div>\n\
                        <div class='col-md-4'>{{valor.protocol}}</div>\n\
                    </div>\n\
                    <div class='row'>\n\
                        <div class='col-md-2'><label>Ativo:</label></div>\n\
                        <div class='col-md-4'>{{valor.enable}}</div>\n\
                    </div>\n\
                </div>",
    data: function() {
        return data;
    }
});