/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global Equipamento, Vue, XdslDiagnostics */

Vue.component("getDevicesLogs", {
    props: {
        eqpString: {
            type: String,
            required: true
        },
        equipamento: {
            type: Equipamento,
            default: function () {
                return new Equipamento();
            }
        }
    },
    data: function () {
        return {mensagem: '', erro: '', deviceslogs: []};
    },
    methods: {
        getDevicesLogs: function () {
            var self = this;
            $.ajax({
                type: "POST",
                url: "/acs/equipamento/getDeviceLogR/",
                data: JSON.stringify(new EquipamentoAdapted(self.equipamento)),
                dataType: "json",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                    self.$parent.loading = true;
                },
                success: function (data) {
                    //console.log(data);                    
                    if (data.list != null) {
                        self.deviceslogs = data.list;
                        vm.$emit("success", "Log do equipamento obtido com sucesso.");
                    } else {
                        vm.$emit("error", data.string);
                        $("#actionModal").modal("hide");
                    }
                },
                error: function (e) {
                    console.log(e);
                    self.mensagem = 'Falha ao buscar informações';
                    self.erro = 'true';
                },
                complete: function () {
                    self.$parent.loading = false;
                    //console.log(self.deviceslogs);
                }
            });
        }
    },
    mounted: function () {
        this.getDevicesLogs();
    },
    template: "<div>\n\
                    <component is='alertpanel' :mensagem='mensagem' :erro='erro'></component>\n\
                    <div class='modal-body'>\n\
                        <table class='table table-bordered' id='logstable'>\n\
                            <thead>\n\
                                <tr>\n\
                                    <th>Index</th>\n\
                                    <th>Time</th>\n\
                                    <th>Type</th>\n\
                                    <th>Servity</th>\n\
                                    <th>LogInformation</th>\n\
                                </tr>\n\
                            </thead>\n\
                            <tbody>\n\
                                <tr v-for='devicelog in deviceslogs'>\n\
                                    <td>{{devicelog.Index}}</td>\n\
                                    <td>{{devicelog.Time}}</td>\n\
                                    <td>{{devicelog.Type}}</td>\n\
                                    <td>{{devicelog.Servity}}</td>\n\
                                    <td>{{devicelog.LogInformation}}</td>\n\
                                </tr>\n\
                            </tbody>\n\
                        </table>\n\
                    </div>\n\
                    <div class='modal-footer'>\n\
                        <button type='button' class='btn btn-default' data-dismiss='modal'>Fechar</button>\n\
                        <button type='button' class='btn btn-primary' @click='getDevicesLogs()'>Buscar</button>\n\
                    </div>\n\
                </div>",
    watch: {
        deviceslogs: function (v) {
            $("#logstable").DataTable().destroy();
            Vue.nextTick(function () {
                if (v.length > 0) {
                    $("#logstable").DataTable({
                        "language": {
                            "url": "/acs/resources/data-table/pt-br.json"
                        }
                    });
                }
            });
        }
    }
});