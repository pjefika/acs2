/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global ping, Vue, Ping, Equipamento */

var url = "/acs/equipamento/";

Vue.component("getPing", {
    data: function() {
        return {
            mensagem: '',
            erro: '',
            infoPing: {}
        };
    },
    props: {
        eqpString: {
            type: String,
            required: true
        },
        equipamento: {
            type: Equipamento,
            default: function() {
                return new Equipamento();
            }
        },
        request: {
            type: String,
            required: true,
            default: "www.google.com"
        },
        alertPanel: {
            type: Object
        }
    },
    methods: {
        getPing: function() {
            var self = this;
            var _data = {};
            _data.nbiDeviceData = new EquipamentoAdapted(self.equipamento);
            _data.request = self.request;
            $.ajax({
                type: "POST",
                url: url + "pingDiagnostic/",
                data: JSON.stringify(_data),
                dataType: "json",
                beforeSend: function(xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                    self.$parent.loading = true;
                },
                success: function(data) {
                    self.infoPing = data.pingResponse;
                    console.log(data);
                },
                error: function(e) {
                    self.mensagem = 'Falha ao buscar informações';
                    self.erro = 'true';
                    console.log(e);
                },
                complete: function() {
                    self.$parent.loading = false;
                }
            });


        }
    },
    template: "<div>\n\
                    <div class='form'>\n\
                        <div class='modal-body'>\n\
                            <component is='alertpanel' :mensagem='mensagem' :erro='erro'></component>\n\
                            <div class='form-group'>\n\
                                <label for='username'>Endereço</label>\n\
                                <input class='form-control' v-model='request'>\n\
                            </div>\n\
                            <tabela-ping v-bind:info-ping='this.infoPing'></tabela-ping>\n\
                        </div>\n\
                        <div class='modal-footer'>\n\
                            <button type='button' class='btn btn-default' data-dismiss='modal'>Cancelar</button>\n\
                            <button class='btn btn-primary' type='button' @click='getPing()'>Ping</button>\n\
                        </div>\n\
                    </div>\n\
               </div>"
});

Vue.component("tabelaPing", {
    props: ["infoPing"],
    template: "<div v-show='this.infoPing'>\n\
                <hr/>\n\
                <table class='table table-bordered small'>\n\
                    <thead>\n\
                        <tr>\n\
                            <th colspan='2' style='text-align: center;'>Resposta Ping</th>\n\
                        </tr>\n\
                        <tr>\n\
                            <th>Endereço</th>\n\
                            <td>{{this.infoPing.hostAddress}}</td>\n\
                        </tr>\n\
                        <tr>\n\
                            <th>Repetições</th>\n\
                            <td>{{this.infoPing.repetitions}}</td>\n\
                        </tr>\n\
                        <tr>\n\
                            <th>Quantidade Falha</th>\n\
                            <td>{{this.infoPing.qtdFailures}}</td>\n\
                        </tr>\n\
                        <tr>\n\
                            <th>Quantidade Sucesso</th>\n\
                            <td>{{this.infoPing.qtdSuccess}}</td>\n\
                        </tr>\n\
                        <tr>\n\
                            <th>Tempo de resposta</th>\n\
                            <td>{{this.infoPing.avgRespTime}}</td>\n\
                        </tr>\n\
                        <tr>\n\
                            <th>Status</th>\n\
                            <td>{{this.infoPing.status}}</td>\n\
                        </tr>\n\
                    </thead>\n\
                </table>\n\
            </div>"
});