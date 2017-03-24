/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global Vue */
var url = "/acs/busca/listar/";

Vue.component("searchAcs", {
    template: "<div class='row'>\n\
                    <div v-show='!this.loading'>\n\
                        <div class='col-lg-4'>\n\
                            <search-action></search-action>\n\
                            </div>\n\
                        <div class='col-lg-8'>\n\
                            <search-table :render-table='this.renderTable' :lista-eqp='listaEqp'></search-table>\n\
                        </div>\n\
                    </div>\n\
                    <div v-show='this.loading'>\n\
                        <component is='loading'></component>\n\
                    </div>\n\
               </div>",
    data: function() {
        return {
            inputToSearch: null,
            listaEqp: [],
            picked: null,
            renderTable: true,
            currentView: 'searchAcs',
            loading: false
        };
    }
});

Vue.component("searchTable", {
    props: ['inputToSearch', 'listaEqp', 'picked', 'renderTable'],
    template: "<div v-show='this.renderTable'>\n\
                    <table v-show='this.listaEqp' id='leTable' cellspacing='0' class='table table-striped table-bordered small' >\n\
                        <thead>\n\
                            <tr>\n\
                                <th>Subscriber</th>\n\
                                <th>Serial</th>\n\
                                <th>IP</th>\n\
                                <th>MAC</th>\n\
                                <th>Fabricante</th>\n\
                                <th>Ações</th>\n\
                            </tr>\n\
                        </thead>\n\
                        <tbody>\n\
                            <tr is='searchTableRow' v-bind:equipamento='equipamento' v-for='equipamento in this.listaEqp'></tr>\n\
                        </tbody>\n\
                    </table>\n\
                    <div v-else class='alert alert-warning'>A pesquisa não obteve resultados</div>\n\
                </div>\n\
            </div>"
});

Vue.component("searchTableRow", {
    props: ['equipamento'],
    template: "<tr>\n\
                    <td>{{equipamento.subscriberID}}</td>\n\
                    <td>{{equipamento.deviceId.serialNumber}}</td>\n\
                    <td>{{equipamento.ipAddress}}</td>\n\
                    <td>{{equipamento.macAddress}}</td>\n\
                    <td>{{equipamento.manufacturer}}</td>\n\
                    <td><a v-if='equipamento.deviceGUID!=null' :href=\"'/acs/equipamento/detalhe/' + equipamento.deviceGUID\">Selecionar</a></td>\n\
                </tr>"
});

Vue.component("searchAction", {
    template: "<div>\n\
                <div class='row'>\n\
                    <div class='col-lg-12'>\n\
                        <div class='form-group'>\n\
                            <label>Designador</label>\n\
                            <input type='text' class='form-control' v-on:keyup.enter='busca()' autofocus placeholder='Buscar por Designador...' v-model='subscriber'>\n\
                        </div>\n\
                    </div>\n\
                </div>\n\
                <div class='row'>\n\
                    <div class='col-lg-12'>\n\
                        <div class='form-group'>\n\
                            <label>Serial</label>\n\
                            <input type='text' class='form-control' v-on:keyup.enter='busca()' placeholder='Buscar por Serial...' v-model='serial'>\n\
                        </div><!-- /input-group -->\n\
                    </div><!-- /.col-lg-6 -->\n\
                </div>\n\
                <div class='row'>\n\
                    <div class='col-lg-12'>\n\
                        <div class='form-group'>\n\
                            <label>MAC</label>\n\
                            <input type='text' class='form-control' v-on:keyup.enter='busca()' placeholder='Buscar por MAC...' v-model='mac'>\n\
                        </div><!-- /input-group -->\n\
                    </div><!-- /.col-lg-6 -->\n\
                </div>\n\
                <div class='row'>\n\
                    <div class='col-lg-12 form-group'>\n\
                        <button class='btn btn-primary' @click='busca()'>Buscar</button>\n\
                        <button class='btn btn-default' @click='limpar()'>Limpar</button>\n\
                    </div>\n\
                </div>\n\
            </div>\n\
        </div>",
    props: {
        inputToSearch: {
            type: String,
            default: ''
        },
        picked: {
            type: String
        },
        renderTable: {
            type: Boolean,
            default: false
        },
        subscriber: {
            type: String,
            default: ''
        },
        serial: {
            type: String,
            default: ''
        },
        mac: {
            type: String,
            default: ''
        },
        leOpt: {
            type: String,
            default: ''
        }
    },
    computed: {
        lecrazy: function() {
            if (this.subscriber.length > this.serial.length && this.subscriber.length > this.mac.length) {
                this.leOpt = "subscriber";
                return this.subscriber;
            }
            if (this.serial.length > this.subscriber.length && this.serial.length > this.mac.length) {
                this.leOpt = "serial";
                return this.serial;
            }
            if (this.mac.length > this.subscriber.length && this.mac.length > this.serial.length) {
                this.leOpt = "mac";
                return this.mac;
            }
        }
    },
    methods: {
        busca: function() {
            var self = this;
            self.inputToSearch = this.lecrazy;
            var picked = this.leOpt;
            if (!self.inputToSearch) {
                return;
            }
            vm.$emit('loadingBarLong');
            $.ajax({
                type: "GET",
                url: url + picked + "/" + self.inputToSearch,
                beforeSend: function() {
                    self.$parent.loading = true;
                },
                success: function(data) {
                    Vue.nextTick(function() {
                        console.log(data)
                        if(data.list != null && data.list.length>=1){
                            self.$parent.listaEqp = data.list;    
                        }else{
                            if(data.string){
                                vm.$emit("error", data.string);    
                            }
                        }
                    });
                    vm.$emit('loaded');
                },
                error: function(e) {
                    console.log(e);
                },
                complete: function() {
                    self.$parent.loading = false;
                    self.$parent.inputToSearch = null;

                    Vue.nextTick(function() {
                        $('#leTable').DataTable().destroy();
                        $('#leTable').DataTable({
                            "language": {
                                "url": "resources/data-table/pt-br.json"
                            }
                        });
                    });
                }
            });
        },
        limpar: function() {
            var self = this;
            self.subscriber = "";
            self.serial = "";
            self.mac = "";
        }
    }
});
