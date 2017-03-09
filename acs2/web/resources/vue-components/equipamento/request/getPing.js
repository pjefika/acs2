/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global ping, Vue */

var url = "/acs/equipamento/";

Vue.component("getPing", {    
    data: function () {
        return {
            mensagem: '',
            erro: ''
        };
    },
    mounted: function () {
        var self = this;
        self.getPing();
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
        info: {
            type: ping,
            default: function () {
                return new ping();
            }
        },
        alertPanel: {
            type: Object
        }
    },
    methods: {
        getPing: function () {
            var self = this;
            $.ajax({
                type: "POST",
                url: url + "ping/",
                data: JSON.stringify(this.equipamento.flush()),
                dataType: "json",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                },
                success: function (data) {
                    self.info = new pPPoEC(data.ppPoECredentialsInfo);
                    console.log(self.info);
                },
                error: function (e) {
                    self.mensagem = 'Falha ao buscar informações';
                    self.erro = 'true';
                    console.log(e);
                }
            });
        }
    },
    template: "<div>\n\
                    <div class='form'>\n\
                        <div class='modal-body'>\n\
                            <component is='alertpanel' :mensagem='mensagem' :erro='erro'></component>\n\
                            <div class='form-group'>\n\
                                <label for='username'>Repetitions</label>\n\
                                <input class='form-control' v-model='info.repetitions'>\n\
                            </div>\n\
                            <div class='form-group'>\n\
                                <label for='username'>HostAddress</label>\n\
                                <input class='form-control' v-model='info.hostAddress'>\n\
                            </div>\n\
                            <div class='form-group'>\n\
                                <label for='username'>QtdFailures</label>\n\
                                <input class='form-control' v-model='info.qtdFailures'>\n\
                            </div>\n\
                            <div class='form-group'>\n\
                                <label for='username'>QtdSuccess</label>\n\
                                <input class='form-control' v-model='info.qtdSuccess'>\n\
                            </div>\n\
                            <div class='form-group'>\n\
                                <label for='username'>AvgRespTime</label>\n\
                                <input class='form-control' v-model='info.avgRespTime'>\n\
                            </div>\n\
                            <div class='form-group'>\n\
                                <label for='username'>Status</label>\n\
                                <input class='form-control' v-model='info.status'>\n\
                            </div>\n\
                        </div>\n\
                        <div class='modal-footer'>\n\
                        </div>\n\
                    </div>\n\
               </div>"
});