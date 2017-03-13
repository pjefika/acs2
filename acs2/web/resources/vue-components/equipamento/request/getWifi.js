/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global Vue, WifiInfoFull, Equipamento */
var url = "/acs/equipamento/";


Vue.component("getWifi", {
    mounted: function() {
        this.getWifi();
    },
    data: function(){
      return {mensagem: '', erro: ''}  
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
        info: {
            type: Object,
            default: function() {
                return new WifiInfoFull();
            }
        },
        alertPanel: {
            type:Object
        }
    },
    methods: {
        getWifi: function() {
            var self = this;
            $.ajax({
                type: "POST",
                url: url + "getWifiInfoFull/",
                data: JSON.stringify(self.equipamento.flush()),
                dataType: "json",
                beforeSend: function(xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                    self.$parent.loading = true
                },
                success: function(data) {
                    self.info = new WifiInfoFull(data.wifiInfoFull);
                },
                error: function(e) {
                    console.log(e)
                    self.mensagem = 'Falha ao buscar informações';
                    self.erro = 'true';
                },
                complete: function() {
                    self.$parent.loading = false
                }
            });
        },
        setWifi: function() {
            var self = this;
            /**
             * Utilizar este padrão para enviar duas variaveis json para a controller
             * @type type
             */
            var _data = {};
            _data.nbiDeviceData = self.equipamento;
            _data.info = self.info;

            $.ajax({
                type: "POST",
                url: url + "setWifiInfoFull/",
                data: JSON.stringify(_data),
                dataType: "json",
                beforeSend: function(xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                    self.$parent.loading = true
                },
                success: function(data) {
                    self.info = new WifiInfoFull(data.wifiInfoFull);
                    self.mensagem = 'Sucesso na execução';
                    self.erro = '';
                },
                error: function(e) {
                    self.mensagem = 'Falha ao executar ação.';
                    self.erro = 's';
                },
                complete: function() {
                    self.$parent.loading = false
                }
            });
        }
    },
    template: "<div>\n\
                <component is='alertpanel' :mensagem='mensagem' :erro='erro'></component>\n\
                <div class='modal-body row'>\n\
                    <div class='form-group col-md-6'>\n\
                        <label for='ssid'>Estado da Rede Wifi</label>\n\
                        <input class='form-control' disabled v-model='info.operStatus'>\n\
                    </div>\n\
                    <div class='form-group col-md-6'>\n\
                        <label for='ssid'>SSID (Nome da Rede WiFi)</label>\n\
                        <input class='form-control' v-model='info.ssid'>\n\
                    </div>\n\
                    <div class='form-group col-md-6'>\n\
                        <label for='ssid'>Canal</label>\n\
                        <input class='form-control' type='number' min='1' max='13' v-model='info.channel'>\n\
                    </div>\n\
                    <div class='form-group col-md-6'>\n\
                        <label for='senha'>Senha</label>\n\
                        <input class='form-control' v-model='info.key'>\n\
                    </div>\n\
                </div>\n\
                <div class='modal-footer'>\n\
                    <button type='button' class='btn btn-default' data-dismiss='modal'>Cancelar</button>\n\
                    <button type='button' class='btn btn-primary' @click='setWifi()'>Alterar</button>\n\
                </div>\n\
            </div>"
});

