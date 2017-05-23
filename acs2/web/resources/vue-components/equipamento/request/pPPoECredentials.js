/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global Vue, pPPoEC, vm */

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
        equipamento: {
            type: Equipamento,
            default: function () {
                return new Equipamento();
            }
        },
        pPPoEcred: {
            type: pPPoEC,
            default: function () {
                return new pPPoEC();
            }
        },
        alertPanel: {
            type: Object
        }
    },
    methods: {
        getPPPoECredentials: function () {
            var self = this;
            $.ajax({
                type: "POST",
                url: url + "getPPPoe/",
                data: JSON.stringify(new EquipamentoAdapted(self.equipamento)),
                dataType: "json",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                    self.$parent.loading = true;
                },
                success: function (data) {
                    if (data.ppPoECredentialsInfo != null) {
                        self.pPPoEcred = new pPPoEC(data.ppPoECredentialsInfo);
                    } else {
                        vm.$emit("error", data.string);
                    }

                },
                error: function (e) {
                    self.mensagem = 'Falha ao buscar informações';
                    self.erro = 'true';
                    console.log(e);
                },
                complete: function () {
                    self.$parent.loading = false;
                    self.changeusername();
                }
            });
        },
        setPPPoECredentials: function () {
            var self = this;
            var _data = {};
            _data.nbiDeviceData = new EquipamentoAdapted(self.equipamento);
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
                    if (data.ppPoECredentialsInfo != null) {
                        self.pPPoEcred = new pPPoEC(data.ppPoECredentialsInfo);
                    } else {
                        vm.$emit("error", data.string);
                    }
                },
                error: function (e) {
                    console.log(e);
                }
            });
        },
        changeusername: function () {
            var self = this;
            console.log("entrou changename");
            if (!self.pPPoEcred.username.match(/[@]/g)) {
                $("#usernamex").removeClass("has-success");
                $("#usernamex").addClass("has-error");
                vm.$emit("error", "Username incorreto por favor verifique.");
                $("#usernamex input").focus();
            } else {
                $("#usernamex").removeClass("has-error");
                $("#usernamex").addClass("has-success");
            }
        }
    },
    template: "<div>\n\
                    <div class='form'>\n\
                        <div class='modal-body'>\n\
                            <component is='alertpanel' :mensagem='mensagem' :erro='erro'></component>\n\
                            <div class='form-group' id='usernamex'>\n\
                                <label for='username'>Username</label>\n\
                                <input class='form-control' v-model='pPPoEcred.username' @blur='changeusername()'>\n\
                            </div>\n\
                            <div class='form-group'>\n\
                                <label for='password'>Password</label>\n\
                                <input class='form-control' v-model='pPPoEcred.password'>\n\
                            </div>\n\
                        </div>\n\
                        <div class='modal-footer'>\n\
                            <button type='button' class='btn btn-default' data-dismiss='modal'>Fechar</button>\n\
                            <button type='button' class='btn btn-primary' @click='setPPPoECredentials'>Modificar</button>\n\
                        </div>\n\
                    </div>\n\
               </div>"
});