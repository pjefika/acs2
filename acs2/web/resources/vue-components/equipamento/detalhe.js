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
                },
                success: function () {                   
                    alert("success");
                },
                error: function () {
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
                },
                success: function () {

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
                },
                success: function () {

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
                },
                success: function () {

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