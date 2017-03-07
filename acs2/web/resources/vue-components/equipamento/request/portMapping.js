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
            pMapping: {}
        }
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
        }
    },
    methods: {
        getPortMapping: function () {
            var self = this;
            $.ajax({
                type: "POST",
                url: url + "getPortMapping/",
                data: JSON.stringify(this.equipamento),
                dataType: "json",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                    $("#loadingModal").modal("show");
                },
                success: function (data) {
                    self.pMapping = new portMapping(data.portMappingInfo);   
                    console.log(self.pMapping);
                    $("#loadingModal").modal("hide");
                },
                error: function (e) {
                    console.log(e);
                    $("#loadingModal").modal("hide");
                }
            });
        },
        setPortMapping: function () {
            var self = this;
        }
    },    
    template: "<div class='form'>\n\
                    <div class='form-group'>\n\
                        <label for='username'>enable</label>\n\
                        <input class='form-control' v-model='pMapping.enable'>\n\
                    </div>\n\
                    <div class='form-group'>\n\
                        <label for='password'>externalPort</label>\n\
                        <input class='form-control' v-model='pMapping.externalPort'>\n\
                    </div>\n\
                    <div class='form-group'>\n\
                        <label for='password'>internalClient</label>\n\
                        <input class='form-control' v-model='pMapping.internalClient'>\n\
                    </div>\n\
                    <div class='form-group'>\n\
                        <label for='password'>internalPort</label>\n\
                        <input class='form-control' v-model='pMapping.internalPort'>\n\
                    </div>\n\
                    <div class='form-group'>\n\
                        <label for='password'>portMapName</label>\n\
                        <input class='form-control' v-model='pMapping.portMapName'>\n\
                    </div>\n\
                    <div class='form-group'>\n\
                        <label for='password'>protocol</label>\n\
                        <input class='form-control' v-model='pMapping.protocol'>\n\
                    </div>\n\
                    <div class='form-group'>\n\
                        <label for='password'>remoteHost</label>\n\
                        <input class='form-control' v-model='pMapping.remoteHost'>\n\
                    </div>\n\
                    <button type='button' class='btn btn-primary' @click='getPortMapping()'>Buscar</button>\n\
               </div>"
});