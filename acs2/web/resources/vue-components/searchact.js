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
    listaEqp: []

};

Vue.component("search-action", {
    template: "<div class='row'>\n\
                    <div class='col-lg-6'>\n\
                        <div class='input-group'>\n\
                            <input type='text' class='form-control' placeholder='Search for...' v-model='inputToSearch'>\n\
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
            //Tira os espaços da varivel
            self.inputToSearch = self.inputToSearch.trim();
            //Regexs
            var regexMac = /^([0-9A-F]{2}[:-]){5}([0-9A-F]{2})$/;
            var regexID = /^[0-9]{5}/;
            var regexSubs = /[a-zA-Z]{3}[-]?[A-Z0-9]{9}[-]?\d{3}/;

            //Comparações
            if (regexMac.test(self.inputToSearch)) {
                console.log("Pesquisa por MAC");
                $.get(url + "mac/" + self.inputToSearch, function (data) {                    
                    self.listaEqp = data.list;                    
                }).done(function () {
                    $("#loadingModal").modal("hide");
                });
            } else if (regexSubs.test(self.inputToSearch)) {
                console.log("Pesquisa por Subscriber");
                $.get(url + "subscriber/" + self.inputToSearch, function (data) {
                    self.listaEqp = data.list;
                }).done(function () {
                    $("#loadingModal").modal("hide");
                });
            } else if (regexID.test(self.inputToSearch)) {
                console.log("Pesquisa por GUID");
                $.get(url + "guid/" + self.inputToSearch, function (data) {
                    self.listaEqp = data;                    
                }).done(function () {
                    $("#loadingModal").modal("hide");
                });
            } else {
                console.log("Pesquisa por Serial");
                $.get(url + "serial/" + self.inputToSearch, function (data) {
                    self.listaEqp = data;
                }).done(function () {
                    $("#loadingModal").modal("hide");
                });
            }
        }
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