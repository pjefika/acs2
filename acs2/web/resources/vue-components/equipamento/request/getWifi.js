/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global Vue */
var url = "/acs/equipamento/";


Vue.component("getWifi", {
    data: function() {
        return {infoCache: {}}
    },
    mounted: function(){
      this.getWifi();  
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
        }
    },
    methods: {
        getWifi: function() {
            var self = this;
            $.ajax({
                type: "POST",
                url: url + "getWifiInfo/",
                data: JSON.stringify(this.equipamento),
                dataType: "json",
                beforeSend: function(xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                    $('#leForm').hide();
                    $('#leLoading').show();
                },
                success: function(data) {
                    console.log(this.url)
                    self.infoCache = new WifiInfo(data.wifiInfo);
                    $('#leForm').show();
                    $('#leLoading').hide();
                },
                error: function(e) {
                    console.log(e)
                }
            });
        },
        setWifi: function(){
            var self = this;
            $.ajax({
                type: "POST",
                url: url + "setWifiInfo/",
                data: JSON.stringify(this.equipamento),
                dataType: "json",
                beforeSend: function(xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                    $('#leForm').hide();
                    $('#leLoading').show();
                },
                success: function(data) {
                    console.log(this.url)
                    self.infoCache = new WifiInfo(data.wifiInfo);
                    $('#leForm').show();
                    $('#leLoading').hide();
                },
                error: function(e) {
                    console.log(e)
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
                        <div class='form-group'>\n\
                            <button type='button' class='btn btn-primary col-sm-4 ' @click='getWifi()'>getWifi</button>\n\
                            <button type='button' class='btn btn-default col-sm-4 pull-right' @click='setWifi()'>setWifi</button>\n\
                        </div>\n\
                    </div>\n\
                    <div id='leLoading' style='display:none'><img src='/acs/resources/imagens/loading.gif'><br>Aguarde...</div>\n\
               </div>"
});

