/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global Vue, Equipamento, eqpString */

var url = "/acs/equipamento/";

Vue.config.devtools = true;
Vue.config.silent = true;

var data = {
    inputToSearch: null
};
Vue.component("detail", {
    template: '#detalhequip',
    props: {
        eqpString: {
            type: String,
            required: true
        },
        eqp: {
            type: Equipamento,
            default: function () {
                return new Equipamento(this.eqpString);
            }
        }
    },
    created: function () {
        this.checkOnline();
    },
    methods: {
        /*
         * Comando engatilhado
         */
        reboot: function () {
            $("#modalReboot").modal("hide");
            $.ajax({
                type: "POST",
                url: url + "reboot/",
                data: JSON.stringify(this.eqp),
                dataType: "json",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                    $("#loadingModal").modal("show");
                },
                success: function () {
                    $("#loadingModal").modal("hide");
                    alert("success");
                },
                error: function () {
                    $("#loadingModal").modal("hide");
                    alert("Erro");
                }
            });
        },
        getFirmware: function () {
            /*
             * Comando engatilhado
             */
            $.ajax({
                type: "POST",
                url: url + "getFirmwareVersion/",
                data: JSON.stringify(this.eqp),
                dataType: "json",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                    $("#loadingModal").modal("show");
                },
                success: function () {
                    $("#loadingModal").modal("hide");
                    $("#modalGetFirmware").modal("show");
                },
                error: function () {
                    $("#loadingModal").modal("hide");
                    alert("Erro");
                }
            });
        },
        updateFirmware: function () {
            /*
             * Comando engatilhado
             */
            $.ajax({
                type: "POST",
                url: url + "updateFirmwareVersion/",
                data: JSON.stringify(this.eqp),
                dataType: "json",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                    $("#loadingModal").modal("show");
                },
                success: function () {
                    $("#loadingModal").modal("hide");
                },
                error: function () {
                    $("#loadingModal").modal("hide");
                }
            });
        },
        checkOnline: function () {
            /*
             * Comando engatilhado
             */
            $.ajax({
                type: "POST",
                url: url + "checkOnline/",
                data: JSON.stringify(this.eqp),
                dataType: "json",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                    $("#loadingModal").modal("show");
                },
                success: function (data) {
                    $("#loadingModal").modal("hide");
                    if (data.boolean) {
                        $("#imgDetalhes").css("border", "3px solid green");
                    } else {
                        $("#imgDetalhes").css("border", "3px solid red");
                    }
                },
                error: function () {
                    $("#loadingModal").modal("hide");
                    $("#imgDetalhes").css("border", "3px solid red");
                }
            });
        }
    },
    data: function () {
        return data;
    }
});

new Vue({
    el: "#detalhe",
    data: data,
    created: function () {

    },
    methods: {
    }
});