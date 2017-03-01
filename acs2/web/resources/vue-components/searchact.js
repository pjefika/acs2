/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global Vue */
var url = "/acs/busca/listar/";
Vue.config.devtools = true;
Vue.config.silent = true;

var data = {
    inputToSearch: null,
    listaEqp: [],
    picked: null,
    renderTable: false
};
Vue.component("search-table", {
    template: "<table v-if='renderTable' class='table table-bordered' style='text-align: center;'>\n\
                    <thead>\n\
                        <tr>\n\
                            <th>Subscriber</th>\n\
                            <th>IP</th>\n\
                            <th>MAC</th>\n\
                            <th>Fabricante</th>\n\
                            <th>Ações</th>\n\
                        </tr>\n\
                    </thead>\n\
                    <tbody>\n\
                        <tr v-for='eqp in listaEqp' :key='eqp.deviceGUID' v-bind:class=''>\n\
                            <td>{{eqp.subscriberID}}</td>\n\
                            <td>{{eqp.ipAddress}}</td>\n\
                            <td>{{eqp.macAddress}}</td>\n\
                            <td>{{eqp.manufacturer}}</td>\n\
                            <td><a :href=\"'/acs/equipamento/detalhe/' + eqp.deviceGUID\">Selecionar</a></td>\n\
                        </tr>\n\
                    </tbody>\n\
                </table>",
    methods: {
    },
    data: function () {
        return data;
    }
});
Vue.component("search-action", {
    template: "<div class='row'>\n\
                    <div class='col-lg-6'>\n\
                        <div class='input-group'>\n\
                            <input type='text' class='form-control' autofocus placeholder='Buscar...' v-model='inputToSearch' @change='searchChange()' >\n\
                            <span class='input-group-btn'>\n\
                                <button class='btn btn-default' type='button' @click='busca()'>Buscar</button>\n\
                            </span>\n\
                        </div><!-- /input-group -->\n\
                    </div><!-- /.col-lg-6 -->\n\
                </div>",
    methods: {
        busca: function () {
            var self = this;
            $("#loadingModal").modal({backdrop: "static"});
            $("#loadingModal").modal("show");

            //Consulta
            if (self.picked === "MAC") {
                console.log("Pesquisa por MAC");
                $.get(url + "mac/" + self.inputToSearch, function (data) {
                    self.listaEqp = data.list;
                }).done(function () {
                    $("#loadingModal").modal("hide");
                    self.renderTable = true;
                });
            } else if (self.picked === "GUID") {
                console.log("Pesquisa por GUID");
                $.get(url + "guid/" + self.inputToSearch, function (data) {
                    self.listaEqp = data;
                }).done(function () {
                    $("#loadingModal").modal("hide");
                    self.renderTable = true;
                });
            } else if (self.picked === "Subscriber") {
                console.log("Pesquisa por Subscriber");
                $.get(url + "subscriber/" + self.inputToSearch, function (data) {
                    self.listaEqp = data.list;
                }).done(function () {
                    $("#loadingModal").modal("hide");
                    self.renderTable = true;
                });
            } else if (self.picked === "Serial") {
                console.log("Pesquisa por Serial");
                $.get(url + "serial/" + self.inputToSearch, function (data) {
                    self.listaEqp = data;
                }).done(function () {
                    $("#loadingModal").modal("hide");
                    self.renderTable = true;
                });
            }

        },
        searchChange: function () {
            var self = this;
            //Tira os espaços da varivel
            self.inputToSearch = self.inputToSearch.trim();
            //Regexs
            var regexMac = /^([0-9A-F]{2}[:-]){5}([0-9A-F]{2})$/;
            var regexID = /^[0-9]{5}/;
            var regexSubs = /[a-zA-Z]{3}[-]?[A-Z0-9]{9}[-]?\d{3}/;
            if (regexMac.test(self.inputToSearch)) {
                self.picked = "MAC";
            } else if (regexSubs.test(self.inputToSearch)) {
                self.picked = "Subscriber";
            } else if (regexID.test(self.inputToSearch)) {
                self.picked = "GUID";
            } else {
                self.picked = "Serial";
            }
            self.busca();

        }
    },created: function() {
        
    },
    data: function () {
        return data;
    }
});
new Vue({
    el: "#search",
    data: data,
    created: function () {

    },
    methods: {
    }
});