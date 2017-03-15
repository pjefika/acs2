/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global Vue, PortMapping */
var url = "/acs/equipamento/";
Vue.component("portMapping", {
    mounted: function() {
        this.getLanHosts();
    },
    data: function() {
        return {mensagem: '', erro: '', ports: []}
    },
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
        alertPanel: {
            type: Object
        }
    },
    methods: {
        getLanHosts: function() {
            var self = this;
            $.ajax({
                type: "POST",
                url: url + "getPortMapping/",
                data: JSON.stringify(self.equipamento.flush()),
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
                    self.$parent.loading = false
                }
            });
        }
    },
    template: "<div>\n\
                <div class='modal-body'>\n\
                    <component is='alertpanel' :mensagem='mensagem' :erro='erro'></component>\n\
                    <div class='form-group'>\n\
                        <port-table :ports='ports'></lan-table>\n\
                    </div>\n\
                </div>\n\
                <div class='modal-footer'>\n\
                    <button type='button' class='btn btn-default' data-dismiss='modal'>Cancelar</button>\n\
                </div>\n\
            </div>"
});
Vue.component("PortTable", {
    props: {
        ports: {
            type: Array,
            required: true
        }
    },
    template: "\
            <div>\n\
                <table class='table table-bordered small'>\n\
                    <thead>\n\
                        <tr>\n\
                            <th>Porta Externa</th>\n\
                            <th>Porta Interna</th>\n\
                            <th>IP Interno</th>\n\
                            <th>Protocolo</th>\n\
                            <th>Estado</th>\n\
                        </tr>\n\
                    </thead>\n\
                    <tbody>\n\
                        <tr is='port-row' v-for='port in ports' :port='port'></tr>\n\
                    </tbody>\n\
                </table>\n\
            </div>"
});
Vue.component("PortRow", {
    props: ['port'],
    template: "<tr>\n\
                    <td>{{port.externalPort}}</td>\n\
                    <td>{{port.internalPort}}</td>\n\
                    <td>{{port.internalClient}}</td>\n\
                    <td>{{port.protocol}}</td>\n\
                    <td>\n\
                        <div>\n\
                            <div v-if='port.enable'>Ativo</div>\n\
                            <div v-else>Inativo</div>\n\
                        </div>\n\
                    </td>\n\
                </tr>"
});
