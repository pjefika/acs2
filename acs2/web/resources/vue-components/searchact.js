/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global Vue */
var url = "/acs/busca/listar/";
var data = {
    inputToSearch: null,
    listaEqp: [],
    picked: null,
    renderTable: false
};

Vue.component("search-table", {
    props: ['inputToSearch', 'listaEqp', 'picked', 'renderTable'],
    template: "<div v-if='this.renderTable'>\n\
                    <table v-if='this.listaEqp' id='leTable' class='table table-bordered small' >\n\
                        <thead>\n\
                            <tr>\n\
                                <th>Subscriber</th>\n\
                                <th>Serial</th>\n\
                                <th>IP</th>\n\
                                <th>MAC</th>\n\
                                <th>Fabricante</th>\n\
                                <th>Ações</th>\n\
                            </tr>\n\
                        </thead>\n\
                        <tbody>\n\
                            <tr v-for='eqp in listaEqp' :key='eqp.deviceGUID' v-bind:class=''>\n\
                                <td>{{eqp.subscriberID}}</td>\n\
                                <td>{{eqp.deviceId.serialNumber}}</td>\n\
                                <td>{{eqp.ipAddress}}</td>\n\
                                <td>{{eqp.macAddress}}</td>\n\
                                <td>{{eqp.manufacturer}}</td>\n\
                                <td><a v-if='eqp.deviceGUID!=null' :href=\"'/acs/equipamento/detalhe/' + eqp.deviceGUID\">Selecionar</a></td>\n\
                            </tr>\n\
                        </tbody>\n\
                    </table>\n\
                    <div v-else class='alert alert-warning'>A pesquisa não obteve resultados</div>\n\
                    </div>\n\
                </div>\n\
                ",
    methods: {
    },
    data: function() {
        return data;
    }
});
Vue.component("search-action", {
    template: "<div class='row'>\n\
                    <div class='col-lg-4'>\n\
                        <div class='row'>\n\
                            <div class='col-lg-12'>\n\
                                <div class='form-group'>\n\
                                    <label>Designador</label>\n\
                                    <input type='text' class='form-control' @change='busca()' autofocus placeholder='Buscar por Designador...' v-model='subscriber'>\n\
                                </div><!-- /input-group -->\n\
                            </div><!-- /.col-lg-6 -->\n\
                        </div>\n\
                        <div class='row'>\n\
                            <div class='col-lg-12'>\n\
                                <div class='form-group'>\n\
                                    <label>Serial</label>\n\
                                    <input type='text' class='form-control' @change='busca()' autofocus placeholder='Buscar por Serial...' v-model='serial'>\n\
                                </div><!-- /input-group -->\n\
                            </div><!-- /.col-lg-6 -->\n\
                        </div>\n\
                        <div class='row'>\n\
                            <div class='col-lg-12'>\n\
                                <div class='form-group'>\n\
                                    <label>MAC</label>\n\
                                    <input type='text' class='form-control' @change='busca()' autofocus placeholder='Buscar por MAC...' v-model='mac'>\n\
                                </div><!-- /input-group -->\n\
                            </div><!-- /.col-lg-6 -->\n\
                        </div>\n\
                        <div class='row'>\n\
                            <div class='col-lg-12 form-group'>\n\
                                <label class='sr-only'>buscar</label>\n\
                                <button class='btn btn-default' @click='busca()'>Buscar</button>\n\
                            </div>\n\
                        </div>\n\
                </div>\n\
                <div class='col-lg-8'>\n\
                    <search-table v-bind:render-table='this.renderTable' v-bind:lista-eqp='listaEqp'></search-table>\n\
                </div>\n\
            </div>",
    props: {
        inputToSearch: {
            type: String,
            default: ''
        },
        listaEqp: {
            type: Array
        },
        picked: {
            type: String
        },
        renderTable: {
            type: Boolean,
            default: false
        },
        subscriber: {
            type: String,
            default: ''
        },
        serial: {
            type: String,
            default: ''
        },
        mac: {
            type: String,
            default: ''
        },
        leOpt: {
            type: String,
            default: ''
        }
    },
    computed: {
        lecrazy: function() {
            if (this.subscriber.length > this.serial.length && this.subscriber.length > this.mac.length) {
                this.leOpt = "subscriber";
                return this.subscriber;
            }
            if (this.serial.length > this.subscriber.length && this.serial.length > this.mac.length) {
                this.leOpt = "serial";
                return this.serial;
            }
            if (this.mac.length > this.subscriber.length && this.mac.length > this.serial.length) {
                this.leOpt = "mac";
                return this.mac;
            }
        }
    },
    methods: {
        busca: function() {
            var self = this;
            self.inputToSearch = this.lecrazy;
            var picked = this.leOpt;

            if (self.inputToSearch == null || self.inputToSearch == "") {
                return;
            }

            $("#loadingModal").modal({backdrop: "static"});
            $("#loadingModal").modal("show");

            //Consulta
            $.get(url + picked + "/" + self.inputToSearch, function(data) {
                self.listaEqp = data.list;
            }).done(function() {
                $("#loadingModal").modal("hide");
                self.renderTable = true;
                self.inputToSearch = null;
                $('#leTable').DataTable().destroy();
                $(document).ready(function() {
                    $('#leTable').DataTable({
                        "language": {
                            "url": "resources/data-table/pt-br.json"
                        }
                    });
                })
            });
        }
    }, created: function() {

    },
    data: function() {
        return data;
    }
});