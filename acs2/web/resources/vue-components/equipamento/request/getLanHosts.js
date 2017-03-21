/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global Vue */
var url = "/acs/equipamento/";
Vue.component("getLanHosts", {
    mounted: function() {
        this.getLanHosts();
    },
    data: function() {
        return {mensagem: '', erro: '', hosts: []}
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
                url: url + "getLanHosts/",
                data: JSON.stringify(new EquipamentoAdapted(self.equipamento)),
                dataType: "json",
                beforeSend: function(xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                    self.$parent.loading = true
                },
                success: function(data) {
                    if(data.list != null){
                        self.hosts = data.list;    
                    }else{
                        vm.$emit("error", data.string);
                        $("#modalAction").modal("hide");
                    }
                    
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
                        <lan-table :hosts='hosts'></lan-table>\n\
                    </div>\n\
                </div>\n\
                <div class='modal-footer'>\n\
                    <button type='button' class='btn btn-default' data-dismiss='modal'>Fechar</button>\n\
                    <button type='button' class='btn btn-primary' @click='getLanHosts()'>Consultar</button>\n\
                </div>\n\
            </div>"
});


Vue.component("LanTable", {
    props: {
        hosts: {
            type: Array,
            required: true
        }
    },
    template: "\
            <div>\n\
                <table class='table table-bordered small'>\n\
                    <thead>\n\
                        <tr>\n\
                            <th>IP</th>\n\
                            <th>MAC</th>\n\
                            <th>Nome Host</th>\n\
                            <th>Interface</th>\n\
                            <th>Estado</th>\n\
                        </tr>\n\
                    </thead>\n\
                    <tbody>\n\
                        <tr is='lan-row' v-for='host in hosts' :host='host'></tr>\n\
                    </tbody>\n\
                </table>\n\
            </div>"
});

Vue.component("LanRow", {
    props: ['host'],
    template: "<tr>\n\
                    <td>{{host.ipAddress}}</td>\n\
                    <td>{{host.macAddress}}</td>\n\
                    <td>{{host.hostName}}</td>\n\
                    <td>{{host.interfaceType}}</td>\n\
                    <td>\n\
                        <div>\n\
                            <div v-if=\"ativo == 'Ativo'\">Ativo</div>\n\
                            <div v-else>Inativo</div>\n\
                        </div>\n\
                    </td>\n\
                </tr>"
});