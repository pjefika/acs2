/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global Vue, Equipamento, eqpString, CheckOnline */

var url = "/acs/equipamento/";

Vue.config.devtools = true;
Vue.config.silent = true;

var data = {

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
    },
    methods: {
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
        factoryReset: function () {
            $("#modalFactory").modal("hide");
            $.ajax({
                type: "POST",
                url: url + "factoryReset/",
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
                        $("#chOn").addClass("alert-success");
                        $("#imgDetalhes").css("border", "3px solid green");
                    } else {
                        $("#chOn").addClass("alert-danger");
                        $("#imgDetalhes").css("border", "3px solid red");
                    }
                },
                error: function () {
                    $("#loadingModal").modal("hide");
                    $("#chOn").addClass("alert-danger");
                    $("#imgDetalhes").css("border", "3px solid red");
                }
            });
        }
    },
    data: function () {
        return data;
    }
});