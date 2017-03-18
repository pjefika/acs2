/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global Vue */
var url = "/acs/equipamento/";
Vue.component("reboot", {
    data: function() {
        return {mensagem: '', erro: '', texto: 'Deseja reiniciar o modem?'}
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
        reboot: function() {
            var self = this;
            $.ajax({
                type: "POST",
                url: url + "reboot/",
                data: JSON.stringify(new EquipamentoAdapted(self.equipamento)),
                dataType: "json",
                beforeSend: function(xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                    self.$parent.loading = true
                },
                success: function(data) {
                    // self.info = new WifiInfo(data.wifiInfo);
                },
                error: function(e) {
                    self.mensagem = 'Falha ao buscar informações';
                    self.erro = 'true';
                },
                complete: function() {
                    self.$parent.loading = false
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
                        <button type='button' class='btn btn-primary' @click='reboot()'>Reiniciar</button>\n\
                    </div>\n\
                </div>"
});

