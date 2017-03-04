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
            $.ajax({
                type: "POST",
                url: url + "getWifiInfo/",
                data: JSON.stringify(this.equipamento),
                dataType: "json",
                beforeSend: function(xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                },
                success: function(data) {
                    console.log(data.wifiInfo)
                    this.infoCache = new WifiInfo(data.wifiInfo);
                },
                error: function(e) {
                    console.log(e)
                }
            });
        }
    },
    template: "<div>\n\
                    <button type='button' class='btn btn-primary' @click='getWifi()'>getWifi</button>\n\
                    <span v-text='infoCache'></span>\n\
               </div>"
});

