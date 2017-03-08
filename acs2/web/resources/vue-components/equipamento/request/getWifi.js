/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global Vue */
var url = "/acs/equipamento/";


Vue.component("getWifi", {
    data: function() {
        return data;
    },
    mounted: function() {
        var self = this
        $('.modal').on('show.bs.modal', function() {
            self.getWifi();
        });

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
            type: WifiInfo,
            default: function() {
                return new WifiInfo();
            }
        },
        infoCache: {
            type: WifiInfo,
            default: function() {
                return new WifiInfo();
            }
        }
    },
    methods: {
        getWifi: function() {
            var self = this;

            self.modal.comp = 'get-wifi';

            $.ajax({
                type: "POST",
                url: url + "getWifiInfo/",
                data: JSON.stringify(self.equipamento.flush()),
                dataType: "json",
                beforeSend: function(xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                    // self.$parent.loadingRequest();
                },
                success: function(data) {
                    self.infoCache = new WifiInfo(data.wifiInfo);

                },
                error: function(e) {
                    console.log(e)
                },
                complete: function() {
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
            _data.info = self.infoCache;

            $.ajax({
                type: "POST",
                url: url + "setWifiInfo/",
                data: JSON.stringify(_data),
                dataType: "json",
                beforeSend: function(xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                    self.$parent.loadingRequest();
                },
                success: function(data) {
                    console.log(this.url)
                    self.infoCache = new WifiInfo(data.wifiInfo);
                },
                error: function(e) {
                    console.log(e)
                },
                complete: function() {
                    self.$parent.loadingRequest();
                }
            });
        }
    },
    template: "<div class='form'>\n\
                    <div id='leForm'>\n\
                        <div class='form-group'>\n\
                            <label for='ssid'>SSID (Nome da Rede WiFi)</label>\n\
                            <input class='form-control' v-model='infoCache.ssid'>\n\
                        </div>\n\
                        <div class='form-group'>\n\
                            <label for='ssid'>Senha</label>\n\
                            <input class='form-control' v-model='infoCache.ssidPassword'>\n\
                        </div>\n\
                        <div class='form-group'>\n\
                            <label for='ssid'>Encriptação</label>\n\
                            <input class='form-control' v-model='infoCache.encryptation'>\n\
                        </div>\n\
                        <div class='form-group'>\n\
                            <label for='ssid'>Status</label>\n\
                            <input class='form-control' v-model='infoCache.operStatus'>\n\
                        </div>\n\
                        <div class='form-group'>\n\
                            <label for='ssid'>Canal</label>\n\
                            <input class='form-control' v-model='infoCache.channel'>\n\
                        </div>\n\
                        <div class='form-group'>\n\
                            <label for='ssid'>Broadcast</label>\n\
                            <input class='form-control' v-model='infoCache.broadcastEnabled'>\n\
                        </div>\n\
                        <div class='form-group'>\n\
                            <label for='ssid'>Radio</label>\n\
                            <input class='form-control' v-model='infoCache.radioEnabled'>\n\
                        </div>\n\
                        <div class='modal-footer'>\n\
                            <button type='button' class='btn btn-default' data-dismiss='modal'>Cancelar</button>\n\
                            <button type='button' class='btn btn-primary' @click='setWifi()'>Alterar</button>\n\
                        </div>\n\
                    </div>\n\
               </div>"
});

