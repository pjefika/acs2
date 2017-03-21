/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global Vue, vm, Equipamento */
var url = "/acs/equipamento/";
Vue.component("resetFactory", {
    data: function() {
        return {mensagem: '', erro: '', texto: 'Deseja resetar de fábrica o modem?'};
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
        }
    },
    methods: {
        factoryReset: function() {
            var self = this;
            $.ajax({
                type: "POST",
                url: url + "factoryReset/",
                data: JSON.stringify(new EquipamentoAdapted(self.equipamento)),
                dataType: "json",
                beforeSend: function(xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                    self.$parent.loading = true;
                },
                success: function() {
                    self.$parent.$parent.checkOnline();
                    vm.$emit('success', 'Reset de fábrica realizado com sucesso');
                },
                error: function() {
                    vm.$emit('error', 'Falha ao realizar Reset de fábrica');
                },
                complete: function() {
                    self.$parent.loading = false;
                }
            });
        }
    },
    template: "<div>\n\
                    <div class='modal-body'>\n\  \n\
                        <component is='alertpanel' :mensagem='mensagem' :erro='erro'></component>\n\
                        <span v-text='texto'></span>\n\
                    </div>\n\
                    <div class='modal-footer'>\n\
                        <button type='button' class='btn btn-default' data-dismiss='modal'>Fechar</button>\n\
                        <button type='button' class='btn btn-primary' data-dismiss='modal' @click='factoryReset()'>Resetar</button>\n\
                    </div>\n\
                </div>"
});

