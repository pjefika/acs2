/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global Vue, PortMapping, _ */
var url = "/acs/equipamento/";
Vue.component("portMapping", {
    mounted: function() {
        this.getPortMapping();
    },
    data: function() {
        return {mensagem: '', erro: '', ports: [], edit: false};
    },
    watch: {
        ports: function(h) {
            var self = this
            self.edit = true;
//            alert(self.edit)
        }
    },
    props: {
        equipamento: {
            type: Equipamento,
            default: function() {
                return new Equipamento();
            }
        },
        alertPanel: {
            type: Object
        }
    },
    methods: {
        getPortMapping: function() {
            var self = this;
            $.ajax({
                type: "POST",
                url: url + "getPortMapping/",
                data: JSON.stringify(new EquipamentoAdapted(self.equipamento)),
                dataType: "json",
                beforeSend: function(xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                    self.$parent.loading = true
                },
                success: function(data) {
                    self.ports = data.list;
                },
                error: function(e) {
                    self.mensagem = 'Falha ao buscar informações';
                    self.erro = 'true';
                },
                complete: function() {
                    self.$parent.loading = false;
                }
            });
        },
        setPortMapping: function() {
            var self = this;

            var _data = {};
            _data.nbiDeviceData = self.equipamento.flush();
            _data.ports = self.ports;

            $.ajax({
                type: "POST",
                url: url + "setPortMapping/",
                data: JSON.stringify(_data),
                dataType: "json",
                beforeSend: function(xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                    self.$parent.loading = true
                },
                success: function(data) {
                    self.mensagem = 'Sucesso na execução';
                    self.ports = data.list;
                },
                error: function(e) {
                    console.log(e)
                    self.mensagem = 'Falha ao buscar informações';
                    self.erro = 'true';
                },
                complete: function() {
                    self.$parent.loading = false;
                }
            });
        }
    },
    template: "<div>\n\
                <div class='modal-body'>\n\
                    <component is='alertpanel' :mensagem='mensagem' :erro='erro'></component>\n\
                    <div class='form-group'>\n\
                        <port-table :mappings='ports'></lan-table>\n\
                    </div>\n\
                </div>\n\
                <div class='modal-footer'>\n\
                    <button type='button' class='btn btn-default' data-dismiss='modal'>Cancelar</button>\n\
                </div>\n\
                <span v-text='ports'></span>\n\
            </div>"
}
);
Vue.component("PortTable", {
    props: ['mappings'],
    methods: {
        addPortMapping: function() {
            var self = this;
            self.$parent.ports.push(new PortMapping());
        }
    },
    template: "\
            <div>\n\
                <p>\n\
                    <button type='button' @click='addPortMapping()' class='btn btn-default btn-xs'>Adicionar</button>\n\
                </p>\n\
                <table class='table table-bordered small'>\n\
                    <thead>\n\
                        <tr>\n\
                            <th>Porta Externa</th>\n\
                            <th>Porta Interna</th>\n\
                            <th>IP Interno</th>\n\
                            <th>Protocolo</th>\n\
                            <th>Ativo</th>\n\
                            <th>Ações</th>\n\
                        </tr>\n\
                    </thead>\n\
                    <tbody>\n\
                        <tr is='port-row' v-for='port in mappings' :port='port'></tr>\n\
                    </tbody>\n\
                </table>\n\
            </div>"
});
Vue.component("PortRow", {
    props: ['port', 'edit'],
    methods: {
        remPortMapping: function(h) {
            var self = this;
            var ports = self.$parent.$parent.ports;
            ports.splice(ports.indexOf(h), 1);
        },
        editPort: function() {
            var self = this;
            self.edit = !self.edit;
        },
        doneEditPort: function() {
            var self = this;

            if (!self.port.externalPort || !self.port.internalPort || !self.port.internalClient) {
                alert('Campos não preenchidos');
                return;
            }
            self.edit = false;
            self.$parent.$parent.setPortMapping();
        }
    },
    template: "<tr>\n\
                    <td>\n\
                        <div v-if='edit'>\n\
                            <input v-model='port.externalPort' class='form-control input-sm' type='text' placeholder='Porta Externa'>\n\
                        </div>\n\
                        <div v-else>\n\
                            {{port.externalPort}}\n\
                        </div>\n\
                    </td>\n\
                    <td>\n\
                        <div v-if='edit'>\n\
                            <input v-model='port.internalPort' class='form-control input-sm' type='text' placeholder='Porta Interna'>\n\
                        </div>\n\
                        <div v-else>\n\
                            {{port.internalPort}}\n\
                        </div>\n\
                    </td>\n\
                    <td>\n\
                        <div v-if='edit'>\n\
                            <input v-model='port.internalClient' class='form-control input-sm' type='text' placeholder='IP Interno'>\n\
                        </div>\n\
                        <div v-else>\n\
                            {{port.internalClient}}\n\
                        </div>\n\
                    </td>\n\
                    <td>\n\
                        <div v-if='edit'>\n\
                            <select v-model='port.protocol' class='form-control input-sm'>\n\
                                <option>UDP</option>\n\
                                <option>TCP</option>\n\
                            </select>\n\
                        </div>\n\
                        <div v-else>\n\
                            {{port.protocol}}\n\
                        </div>\n\
                    </td>\n\
                    <td class='text-center'>\n\
                        <span v-if='port.enable'>\n\
                            <input v-model='port.enable' type='checkbox' checked>\n\
                        </span>\n\
                        <span v-else>\n\
                            <input v-model='port.enable' type='checkbox'>\n\
                        </span>\n\
                    </td>\n\
                    <td class='text-center'>\n\
                        <button type='button' @click='remPortMapping(port)' class='btn btn-danger btn-sm'>\n\
                            <span class='glyphicon glyphicon-trash' aria-hidden='true'></span>\n\
                        </button>\n\
                        \n\
                        <span v-if='edit'>\n\
                            <button type='button' @click='doneEditPort()' class='btn btn-primary btn-sm'>\n\
                                <span class='glyphicon glyphicon-ok' aria-hidden='true'></span>\n\
                            </button>\n\
                        </span>\n\
                        <span v-else>\n\
                            <button type='button' @click='editPort()' class='btn btn-warning btn-sm'>\n\
                                <span class='glyphicon glyphicon-pencil' aria-hidden='true'></span>\n\
                            </button>\n\
                        </span>\n\
                    </td>\n\
                </tr>"
});
