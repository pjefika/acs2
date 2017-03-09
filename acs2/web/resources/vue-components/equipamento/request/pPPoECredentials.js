/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global Vue, pPPoEC */

var url = "/acs/equipamento/";

Vue.component("pppoeCredentials", {
    data: function () {
        return {pppoeusrepass: {}}
    },
    mounted: function () {
        var self = this;
        self.getPPPoECredentials();
    },
    props: {
        eqpString: {
            type: String,
            required: true
        },
        equipamento: {
            type: Equipamento,
            default: function () {
                return new Equipamento(this.eqpString);
            }
        },
        pPPoEcred: {
            type: pPPoEC,
            default: function () {
                return new pPPoEC();
            }
        }
    },
    methods: {
        getPPPoECredentials: function () {
            var self = this;
            $.ajax({
                type: "POST",
                url: url + "getPPPoe/",
                data: JSON.stringify(this.equipamento),
                dataType: "json",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                    $("#loadingModal").modal("show");
                },
                success: function (data) {
                    self.pppoeusrepass = new pPPoEC(data.ppPoECredentialsInfo);
                    $("#loadingModal").modal("hide");
                },
                error: function (e) {
                    console.log(e);
                    $("#loadingModal").modal("hide");
                }
            });
        },
        setPPPoECredentials: function () {
            var self = this;
            var _data = {};
            _data.nbiDeviceData = self.equipamento;
            _data.pPPoECredentialsInfo = self.pppoeusrepass;

            $.ajax({
                type: "POST",
                url: url + "setPPPoe/",
                data: JSON.stringify(_data),
                dataType: "json",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                    $("#loadingModal").modal("show");
                },
                success: function (data) {
                    console.log(data);
                    $("#loadingModal").modal("hide");
                },
                error: function (e) {
                    console.log(e);
                    $("#loadingModal").modal("hide");
                }
            });
        }
    },
    template: "<div class='form'>\n\
                    <div class='form-group'>\n\
                        <label for='username'>Username</label>\n\
                        <input class='form-control' v-model='pppoeusrepass.username'>\n\
                    </div>\n\
                    <div class='form-group'>\n\
                        <label for='password'>Password</label>\n\
                        <input class='form-control' v-model='pppoeusrepass.password'>\n\
                    </div>\n\
                    <button type='button' class='btn btn-primary' @click='getPPPoECredentials'>Buscar</button>\n\
                    <button type='button' class='btn btn-warning' @click='setPPPoECredentials'>Modificar</button>\n\
               </div>"

});