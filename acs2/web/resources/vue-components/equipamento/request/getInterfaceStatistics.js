/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global InterfaceStatistics */

Vue.component("getInterfaceStatistics", {
    props:{
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
            type: InterfaceStatistics,
            default: function(){
                    return new InterfaceStatistics();
            }
        }
    },
    data: function(){
      return {mensagem: '', erro: ''}  
    },
    mounted: function(){
        this.getInterfaceStatistics();
    },
    methods: {
        getInterfaceStatistics: function() {
            var self = this;
            $.ajax({
                type: "POST",
                url: url + "getInterfaceStatistics/",
                data: JSON.stringify(self.equipamento.flush()),
                dataType: "json",
                beforeSend: function(xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                    self.$parent.loading = true
                },
                success: function(data) {
                    self.info = new InterfaceStatistics(data.interfaceStatistics);
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
        }
    },
    template: "\
            <div>\n\
                <component is='alertpanel' :mensagem='mensagem' :erro='erro'></component>\n\
                <div class='modal-body'>\n\
                    <div class='form-inline row'>\n\
                        <div class='form-group col-md-6'>\n\
                            <label for='ifType'>ifType</label>\n\
                            {{info.ifType}}\n\
                        </div>\n\
                    <div class='form-inline row'>\n\
                        <div class='form-group col-md-6'>\n\
                            <label for='ifName'>ifName</label>\n\
                            {{info.ifName}}\n\
                        </div>\n\
                        <div v-show='\"operStatus\" != \"Up\"' class='form-group col-md-6'>\n\
                            <label for='adminStatus'>adminStatus</label>\n\
                            {{info.adminStatus}}\n\
                        </div>\n\
                        <div v-show='\"operStatus\" == \"Up\"' class='form-group col-md-6'>\n\
                            <label for='operStatus'>operStatus</label>\n\
                            {{info.operStatus}}\n\
                        </div>\n\
                        <div class='form-group col-md-6'>\n\
                            <label for='ipAddress'>ipAddress</label>\n\
                            {{info.ipAddress}}\n\
                        </div>\n\
                        <div class='form-group col-md-6'>\n\
                            <label for='ipAddrType'>ipAddrType</label>\n\
                            {{info.ipAddrType}}\n\
                        </div>\n\
                        <div class='form-group col-md-6'>\n\
                            <label for='macAddress'>macAddress</label>\n\
                            {{info.macAddress}}\n\
                        </div>\n\
                    </div>\n\
                    <table class='table table-bordered table-condensed'>\n\
                        <thead>\n\
                            <tr>\n\
                                <th></th>\n\
                                <th>Sent</th>\n\
                                <th>Received</th>\n\
                            </tr>\n\
                        </thead>\n\
                        <tbody>\n\
                            <tr>\n\
                                <td>Bytes</td>\n\
                                <td>{{info.bytesSent}}</td>\n\
                                <td>{{info.bytesRecv}}</td>\n\
                            </tr>\n\
                            <tr>\n\
                                <td>Pcts</td>\n\
                                <td>{{info.pctSent}}</td>\n\
                                <td>{{info.pctRecv}}</td>\n\
                            </tr>\n\
                            <tr>\n\
                                <td>Errors</td>\n\
                                <td>{{info.errSent}}</td>\n\
                                <td>{{info.errRecv}}</td>\n\
                            </tr>\n\
                            <tr>\n\
                                <td>MC</td>\n\
                                <td>{{info.mcSent}}</td>\n\
                                <td>{{info.mcRecv}}</td>\n\
                            </tr>\n\
                            <tr>\n\
                                <td>BC</td>\n\
                                <td>{{info.bcSent}}</td>\n\
                                <td>{{info.bcRecv}}</td>\n\
                            </tr>\n\
                        </tbody>\n\
                    </table>\n\
                </div>\n\
                <div class='modal-footer'>\n\
                    <button type='button' class='btn btn-default' data-dismiss='modal'>Cancelar</button>\n\
                    <button type='button' class='btn btn-primary' @click='getWan()'>Consultar</button>\n\
                </div>\n\
            </div>"
})