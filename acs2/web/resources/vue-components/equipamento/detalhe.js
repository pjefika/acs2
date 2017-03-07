/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global Vue, Equipamento, eqpString, CheckOnline, vm */

var url = "/acs/equipamento/";

Vue.config.devtools = true;
Vue.config.silent = true;

Vue.component("detail", {
    template: '#detalhequip',
    props: {
        eqpString: {
            type: String,
            required: true
        },
        eqp: {
            type: Equipamento,
            default: function() {
                return new Equipamento(this.eqpString);
            }
        }
    },
    methods: {
        reboot: function() {
            $("#modalReboot").modal("hide");
            $.ajax({
                type: "POST",
                url: url + "reboot/",
                data: JSON.stringify(this.eqp),
                dataType: "json",
                beforeSend: function(xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                    $("#loadingModal").modal("show");
                },
                success: function() {
                    $("#loadingModal").modal("hide");
                    alert("success");
                },
                error: function() {
                    $("#loadingModal").modal("hide");
                    alert("Erro");
                }
            });
        },
        factoryReset: function() {
            $("#modalFactory").modal("hide");
            $.ajax({
                type: "POST",
                url: url + "factoryReset/",
                data: JSON.stringify(this.eqp),
                dataType: "json",
                beforeSend: function(xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                    $("#loadingModal").modal("show");
                },
                success: function() {
                    $("#loadingModal").modal("hide");
                    alert("success");
                },
                error: function() {
                    $("#loadingModal").modal("hide");
                    alert("Erro");
                }
            });
        },
        getFirmware: function() {
            $.ajax({
                type: "POST",
                url: url + "getFirmwareVersion/",
                data: JSON.stringify(this.eqp),
                dataType: "json",
                beforeSend: function(xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                    $("#loadingModal").modal("show");
                },
                success: function() {
                    $("#loadingModal").modal("hide");
                    $("#modalGetFirmware").modal("show");
                },
                error: function() {
                    $("#loadingModal").modal("hide");
                    alert("Erro");
                }
            });
        },
        updateFirmware: function() {
            $.ajax({
                type: "POST",
                url: url + "updateFirmwareVersion/",
                data: JSON.stringify(this.eqp),
                dataType: "json",
                beforeSend: function(xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                    $("#loadingModal").modal("show");
                },
                success: function() {
                    $("#loadingModal").modal("hide");
                },
                error: function() {
                    $("#loadingModal").modal("hide");
                }
            });
        },        
        getDdns: function () {
            $.ajax({
                type: "POST",
                url: url + "getDdns/",
                data: JSON.stringify(this.eqp),
                dataType: "json",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                    $("#loadingModal").modal("show");
                },
                success: function (data) {
                    console.log(data);
                    $("#loadingModal").modal("hide");
                },
                error: function () {
                    $("#loadingModal").modal("hide");
                }
            });
        },
        checkOnline: function () {
            var self = this;
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
                    console.log(data);                    
                    self.eqp.checkOn = data.boolean;                    
                    $("#loadingModal").modal("hide");
                },
                error: function () {
                    $("#loadingModal").modal("hide");
                }
            });
        }
    },
    data: function() {
        return data;
    }
});