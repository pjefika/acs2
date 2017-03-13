/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global Vue, pPPoEC */

var url = "/acs/equipamento/";

Vue.component("pppoeCredentials", {
    data: function () {
        return {
            mensagem: '',
            erro: ''
        };
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
        },
        alertPanel: {
            type:Object
        }
    },
    methods: {
        getPPPoECredentials: function () {
            var self = this;
            $.ajax({
                type: "POST",
                url: url + "getPPPoe/",
                data: JSON.stringify(this.equipamento.flush()),
                dataType: "json",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                    self.$parent.loading = true;
                },
                success: function (data) {
                    self.pPPoEcred = new pPPoEC(data.ppPoECredentialsInfo);
                },
                error: function (e) {
                    self.mensagem = 'Falha ao buscar informações';
                    self.erro = 'true';
                    console.log(e);
                },
                complete: function () {
                    self.$parent.loading = false;
                }
            });
        },
        setPPPoECredentials: function () {
            var self = this;
            var _data = {};
            _data.nbiDeviceData = self.equipamento;
            _data.pPPoECredentialsInfo = self.pPPoEcred;

            $.ajax({
                type: "POST",
                url: url + "setPPPoe/",
                data: JSON.stringify(_data),
                dataType: "json",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                },
                success: function (data) {
                    console.log(data);
                },
                error: function (e) {
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
                                <label for='username'>Username</label>\n\
                                <input class='form-control' v-model='pPPoEcred.username'>\n\
                            </div>\n\
                            <div class='form-group'>\n\
                                <label for='password'>Password</label>\n\
                                <input class='form-control' v-model='pPPoEcred.password'>\n\
                            </div>\n\
                        </div>\n\
                        <div class='modal-footer'>\n\
                            <button type='button' class='btn btn-warning' @click='setPPPoECredentials'>Modificar</button>\n\
                        </div>\n\
                    </div>\n\
               </div>"
});