/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global Vue */
var url = "/acs/equipamento/";
Vue.component("reboot", {
    props: {
        eqpString: {
            type: String,
            required: true
        },
        equipamento: {
            type: Equipamento,
            default: function() {
                return new Equipamento(this.eqpString);
            }
        },
        texto: {
            type: String,
            required: true,
            default: function() {
                return "Deseja resetar o modem?";
            }
        }
    },
    methods: {
        reboot: function() {
            $.ajax({
                type: "POST",
                url: url + "reboot/",
                data: JSON.stringify(this.equipamento.flush()),
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
        }
    },
    template: "<div>\n\
                <div class='modal-body'>\n\  \n\
                    <component is='alertpanel' :msg='alertPanel'></component>\n\
                    <span v-text='texto'></span>\n\
                </div>\n\
                <div class='modal-footer'>\n\
                    <button type='button' class='btn btn-default' data-dismiss='modal'>Fechar</button>\n\
                    <button type='button' class='btn btn-primary' @click='reboot()'>Resetar</button>\n\
                </div>\n\
            </div>"
});

