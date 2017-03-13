/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global Vue, portMapping */

var url = "/acs/equipamento/";

Vue.component("portMapping", {
    data: function () {
        return {
            mensagem: '',
            erro: ''
        };
    },
    mounted: function () {
        var self = this;
        self.getPortMapping();
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
        portingMappingE: {
            type: portMapping,
            default: function () {
                return new portMapping();
            }
        },
        alertPanel: {
            type:Object
        }
    },
    methods: {
        getPortMapping: function () {
            var self = this;
            $.ajax({
                type: "POST",
                url: url + "getPortMapping/",
                data: JSON.stringify(this.equipamento.flush()),
                dataType: "json",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                    self.$parent.loading = true;
                },
                success: function (data) {
                    self.portingMappingE = new portMapping(data.portMappingInfo);   
                },
                error: function (e) {
                    self.mensagem = 'Falha ao buscar informações';
                    self.erro = 'true';
                    //console.log(e);
                },
                complete: function () {
                    self.$parent.loading = false;
                }
            });
        },
        setPortMapping: function () {
            var self = this;
            var _data = {};
            _data.nbiDeviceData = self.equipamento;
            _data.pMapping = self.portingMappingE;            
            $.ajax({
                type: "POST",
                url: url + "setPortMapping/",
                data: JSON.stringify(_data),
                dataType: "json",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                },
                success: function (data) {
                    self.mensagem = 'Falha ao buscar informações';
                    self.erro = 'true';
                    console.log(data);
                },
                error: function (e) {
                    console.log(e);
                }
            }); 
        }
    },    
    template: "\
                <div>\n\
                    <div class='form'>\n\
                        <div class='modal-body'>\n\
                            <component is='alertpanel' :mensagem='mensagem' :erro='erro'></component>\n\
                            <div class='form-group'>\n\
                                <label for='username'>enable</label>\n\
                                <input class='form-control' v-model='portingMappingE.enable'>\n\
                            </div>\n\
                            <div class='form-group'>\n\
                                <label for='password'>externalPort</label>\n\
                                <input class='form-control' v-model='portingMappingE.externalPort'>\n\
                            </div>\n\
                            <div class='form-group'>\n\
                                <label for='password'>internalClient</label>\n\
                                <input class='form-control' v-model='portingMappingE.internalClient'>\n\
                            </div>\n\
                            <div class='form-group'>\n\
                                <label for='password'>internalPort</label>\n\
                                <input class='form-control' v-model='portingMappingE.internalPort'>\n\
                            </div>\n\
                            <div class='form-group'>\n\
                                <label for='password'>portMapName</label>\n\
                                <input class='form-control' v-model='portingMappingE.portMapName'>\n\
                            </div>\n\
                            <div class='form-group'>\n\
                                <label for='password'>protocol</label>\n\
                                <input class='form-control' v-model='portingMappingE.protocol'>\n\
                            </div>\n\
                            <div class='form-group'>\n\
                                <label for='password'>remoteHost</label>\n\
                                <input class='form-control' v-model='portingMappingE.remoteHost'>\n\
                            </div>\n\
                        </div>\n\
                        <div class='modal-footer'>\n\
                            <button type='button' class='btn btn-warning' @click='setPortMapping()'>Modificar</button>\n\
                        </div>\n\
                    </div>\n\
               </div>"
});