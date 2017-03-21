/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

Vue.component("getWan", {
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
        info: {
            type: WanInfo,
            default: function() {
                return new WanInfo();
            }
        }
    },
    data: function() {
        return {mensagem: '', erro: ''}
    },
    mounted: function() {
        this.getWan();
    },
    methods: {
        getWan: function() {
            var self = this;
            $.ajax({
                type: "POST",
                url: url + "getWanInfo/",
                data: JSON.stringify(new EquipamentoAdapted(self.equipamento)),
                dataType: "json",
                beforeSend: function(xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                    self.$parent.loading = true
                },
                success: function(data) {
                    self.info = new WanInfo(data.wanInfo);
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
                                <td>{{info.EthernetBytesSent}}</td>\n\
                                <td>{{info.EthernetBytesReceived}}</td>\n\
                            </tr>\n\
                            <tr>\n\
                                <td>Packets</td>\n\
                                <td>{{info.EthernetPacketsSent}}</td>\n\
                                <td>{{info.EthernetPacketsReceived}}</td>\n\
                            </tr>\n\
                            <tr>\n\
                                <td>Errors</td>\n\
                                <td>{{info.EthernetErrorsSent}}</td>\n\
                                <td>{{info.EthernetErrorsReceived}}</td>\n\
                            </tr>\n\
                            <tr>\n\
                                <td>Discard Packets</td>\n\
                                <td>{{info.EthernetDiscardPacketsSent}}</td>\n\
                                <td>{{info.EthernetDiscardPacketsReceived}}</td>\n\
                            </tr>\n\
                        </tbody>\n\
                    </table>\n\
                </div>\n\
                <div class='modal-footer'>\n\
                    <button type='button' class='btn btn-default' data-dismiss='modal'>Fechar</button>\n\
                    <button type='button' class='btn btn-primary' @click='getWan()'>Consultar</button>\n\
                </div>\n\
            </div>"
})