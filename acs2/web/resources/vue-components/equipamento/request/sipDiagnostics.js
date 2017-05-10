/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global Vue, Integer, SipDiagnostics, vm, SipActivation, Equipamento */

var url = "/acs/equipamento/";

Vue.component("getSip", {
    mounted: function () {
    },
    props: {
        eqpString: {
            type: String,
            required: true
        },
        equipamento: {
            type: Equipamento,
            default: function () {
                return new Equipamento();
            }
        },
        alertPanel: {
            type: Object
        },
        diagnostics: {
            type: SipDiagnostics,
            default: function () {
                return new SipDiagnostics();
            }
        },
        phyref: {
            type: Number,
            required: true,
            default: 1
        }
    },
    data: function () {
        return {mensagem: '', erro: ''}
    },
    template: "<div>\n\
                    <component is='alertpanel' :mensagem='mensagem' :erro='erro'></component>\n\
                    <div class='modal-body'>\n\
                        <div class='form-group'>\n\
                            <label>Phyref</label>\n\
                            <input class='form-control' v-model='phyref'>\n\
                        </div>\n\
                        <hr/>\n\
                        <div v-if='diagnostics.DirectoryNumber'>\n\
                            <table class='table table-bordered'>\n\
                                <thead>\n\
                                    <tr>\n\
                                        <th colspan='2'>Informações</th>\n\
                                    </tr>\n\
                                </thead>\n\
                                <tbody>\n\
                                    <tr>\n\
                                        <td>Status</td>\n\
                                        <td>{{diagnostics.Status}}</td>\n\
                                    </tr>\n\
                                    <tr>\n\
                                        <td>AuthUserName</td>\n\
                                        <td>{{diagnostics.AuthUserName}}</td>\n\
                                    </tr>\n\
                                    <tr>\n\
                                        <td>DirectoryNumber</td>\n\
                                        <td>{{diagnostics.DirectoryNumber}}</td>\n\
                                    </tr>\n\
                                    <tr>\n\
                                        <td>URI</td>\n\
                                        <td>{{diagnostics.URI}}</td>\n\
                                    </tr>\n\
                                    <tr>\n\
                                        <td>ProxyServer</td>\n\
                                        <td>{{diagnostics.ProxyServer}}</td>\n\
                                    </tr>\n\
                                    <tr>\n\
                                        <td>OutboundProxy</td>\n\
                                        <td>{{diagnostics.OutboundProxy}}</td>\n\
                                    </tr>\n\
                                    <tr>\n\
                                        <td>RegistrarServer</td>\n\
                                        <td>{{diagnostics.RegistrarServer}}</td>\n\
                                    </tr>\n\
                                    <tr>\n\
                                        <td>UserAgentDomain</td>\n\
                                        <td>{{diagnostics.UserAgentDomain}}</td>\n\
                                    </tr>\n\
                                    <tr>\n\
                                        <td>CallState</td>\n\
                                        <td>{{diagnostics.CallState}}</td>\n\
                                    </tr>\n\
                                    <tr>\n\
                                        <td>Codec</td>\n\
                                        <td>{{diagnostics.Codec}}</td>\n\
                                    </tr>\n\
                                    <tr>\n\
                                        <td>ConferenceCallURI</td>\n\
                                        <td>{{diagnostics.ConferenceCallURI}}</td>\n\
                                    </tr>\n\
                                    <tr>\n\
                                        <td>DTMFMethod</td>\n\
                                        <td>{{diagnostics.DTMFMethod}}</td>\n\
                                    </tr>\n\
                                    <tr>\n\
                                        <td>DigitMap</td>\n\
                                        <td>{{diagnostics.DigitMap}}</td>\n\
                                    </tr>\n\
                                    <tr>\n\
                                        <td>LineEnable</td>\n\
                                        <td>{{diagnostics.LineEnable}}</td>\n\
                                    </tr>\n\
                                    <tr>\n\
                                        <td>PacketsLost</td>\n\
                                        <td>{{diagnostics.PacketsLost}}</td>\n\
                                    </tr>\n\
                                    <tr>\n\
                                        <td>ProfileEnable</td>\n\
                                        <td>{{diagnostics.ProfileEnable}}</td>\n\
                                    </tr>\n\
                                    <tr>\n\
                                        <td>ProxyServerPort</td>\n\
                                        <td>{{diagnostics.ProxyServerPort}}</td>\n\
                                    </tr>\n\
                                    <tr>\n\
                                        <td>T38Enable</td>\n\
                                        <td>{{diagnostics.T38Enable}}</td>\n\
                                    </tr>\n\
                                    <tr>\n\
                                        <td>UserAgentPort</td>\n\
                                        <td>{{diagnostics.UserAgentPort}}</td>\n\
                                    </tr>\n\
                                </tbody>\n\
                            </table>\n\
                        </div>\n\
                    </div>\n\
                    <div class='modal-footer'>\n\
                        <button type='button' class='btn btn-default' data-dismiss='modal'>Fechar</button>\n\
                        <button type='button' class='btn btn-primary' @click='getSipDiagnostics()'>Consultar</button>\n\
                    </div>\n\
                </div>",
    create: function () {

    },
    methods: {
        getSipDiagnostics: function () {
            var self = this;
            var _data = {};
            _data.nbiDeviceData = new EquipamentoAdapted(self.equipamento);
            _data.phyref = self.phyref;
            $.ajax({
                type: "POST",
                url: url + "getSipDiagnostics/",
                data: JSON.stringify(_data),
                dataType: "json",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                    self.$parent.loading = true;
                },
                success: function (data) {
                    //console.log(data);
                    if (data.sipDiagnostics != null) {
                        self.diagnostics = new SipDiagnostics(data.sipDiagnostics);
                    } else {
                        vm.$emit("error", data.string);
                    }
                },
                error: function (e) {
                    console.log(e);
                },
                complete: function () {
                    self.$parent.loading = false;
                }
            });
        }
    }
});

Vue.component("setSip", {
    mounted: function () {
    },
    props: {
        eqpString: {
            type: String,
            required: true
        },
        equipamento: {
            type: Equipamento,
            default: function () {
                return new Equipamento();
            }
        },
        alertPanel: {
            type: Object
        },
        sipAct: {
            type: SipActivation,
            default: function () {
                return new SipActivation();
            }
        }
    },
    data: function () {
        return {mensagem: '', erro: ''};
    },
    template: "<div>\n\
                    <component is='alertpanel' :mensagem='mensagem' :erro='erro'></component>\n\
                    <div class='modal-body'>\n\
                        <div class='form-group'>\n\
                            <label>DirectoryNumber</label>\n\
                            <input class='form-control' v-model='sipAct.DirectoryNumber' placeholder='+55 Instância' @change='changes()'>\n\
                        </div>\n\
                        <div class='form-group'>\n\
                            <label>AuthUserName</label>\n\
                            <input class='form-control' v-model='sipAct.AuthUserName' placeholder='+55 Instância'>\n\
                        </div>\n\
                        <div class='form-group'>\n\
                            <label>AuthPassword</label>\n\
                            <input class='form-control' v-model='sipAct.AuthPassword' placeholder='Senha'>\n\
                        </div>\n\
                        <div class='form-group'>\n\
                            <label>ProxyServer</label>\n\
                            <input class='form-control' v-model='sipAct.ProxyServer' placeholder='Proxy' @change='changes()'>\n\
                        </div>\n\
                         <div class='form-group'>\n\
                            <label>OutboundProxy</label>\n\
                            <input class='form-control' v-model='sipAct.OutboundProxy' placeholder='Proxy'>\n\
                        </div>\n\
                        <div class='form-group'>\n\
                            <label>RegistrarServer</label>\n\
                            <input class='form-control' v-model='sipAct.RegistrarServer' placeholder='Domain IMS' @change='changes()'>\n\
                        </div>\n\
                        <div class='form-group'>\n\
                            <label>UserAgentDomain</label>\n\
                            <input class='form-control' v-model='sipAct.UserAgentDomain' placeholder='Domain IMS'>\n\
                        </div>\n\
                        <div class='form-group'>\n\
                            <label>phyReferenceList</label>\n\
                            <input class='form-control' v-model='sipAct.phyReferenceList' placeholder='Phy Reference List'>\n\
                        </div>\n\
                    </div>\n\
                    <div class='modal-footer'>\n\
                        <button type='button' class='btn btn-default' data-dismiss='modal'>Fechar</button>\n\
                        <button type='button' class='btn btn-primary' @click='setSip()'>Enviar</button>\n\
                    </div>\n\
                </div>",
    create: function () {
    },
    methods: {
        setSip: function () {
            var self = this;
            var _data = {};
            _data.nbiDeviceData = new EquipamentoAdapted(self.equipamento);
            _data.sipAct = self.sipAct;
            $.ajax({
                type: "POST",
                url: url + "setSipActivation/",
                data: JSON.stringify(_data),
                dataType: "json",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                    self.$parent.loading = true;
                },
                success: function (data) {
                    if (data.boolean) {
                        vm.$emit("success", "Alterações realizadas com sucesso.");
                        $("#actionModal").modal("hide");
                    } else {
                        vm.$emit("error", data.string);
                    }
                },
                error: function (e) {
                    console.log(e);
                    vm.$emit("error", "Falha ao realizar alterações.");
                },
                complete: function () {
                    self.$parent.loading = false;
                }
            });
        },
        changes: function () {
            var self = this;
            this.$set(self.sipAct, "AuthUserName", self.sipAct.DirectoryNumber);
            var pass = self.sipAct.DirectoryNumber.substring(self.sipAct.DirectoryNumber.length - 4);
            this.$set(self.sipAct, "AuthPassword", pass);
            this.$set(self.sipAct, "OutboundProxy", self.sipAct.ProxyServer);
            this.$set(self.sipAct, "UserAgentDomain", self.sipAct.RegistrarServer);

        }
    }
});