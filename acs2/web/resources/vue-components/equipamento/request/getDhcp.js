/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global Equipamento, Vue, XdslDiagnostics, vm */

Vue.component("getDhcp", {
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
        },
        info: {
            type: Dhcp,
            default: function () {
                return new Dhcp();
            }
        }
    },
    data: function () {
        return {mensagem: '', erro: ''};
    },
    methods: {
        getDhcp: function () {
            var self = this;
            $.ajax({
                type: "POST",
                url: "/acs/equipamento/getDhcp/",
                data: JSON.stringify(new EquipamentoAdapted(self.equipamento)),
                dataType: "json",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                    self.$parent.loading = true;
                },
                success: function (data) {
                    if (data.dhcp != null) {
                        self.info = new Dhcp(data.dhcp);
                        vm.$emit("success", "Informações de DHCP obtidas com sucesso.");
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
                    self.changeips();
                }
            });
        },
        setDhcp: function () {
            var self = this;
            /**
             * Utilizar este padrão para enviar duas variaveis json para a controller
             * @type type
             */
            var _data = {};
            _data.nbiDeviceData = new EquipamentoAdapted(self.equipamento);
            _data.info = self.info;

            $.ajax({
                type: "POST",
                url: "/acs/equipamento/setDhcp/",
                data: JSON.stringify(_data),
                dataType: "json",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                    self.$parent.loading = true
                },
                success: function (data) {
                    if (data.dhcp != null) {
                        self.info = new Dhcp(data.dhcp);
                        vm.$emit("success", "Alterações realizadas com sucesso.");
                    } else {
                        vm.$emit("error", data.string);
                        $("#actionModal").modal("hide");
                    }
                },
                error: function (e) {
                    console.log(e);
                    vm.$emit("error", "Falha ao realizar alterações.");
                },
                complete: function () {
                    self.$parent.loading = false
                }
            });
        },
        changeips: function () {
            var self = this;

            if (!self.info.MaxAddress.match(/^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$/g)) {
                vm.$emit("error", "MaxAddress incorreto por favor verifique.");
                $("#maxadressx").removeClass("has-success");
                $("#maxadressx").addClass("has-error");
                $("#maxadressx input").focus();
            } else {
                $("#maxadressx").removeClass("has-error");
                $("#maxadressx").addClass("has-success");
            }

            if (!self.info.MinAddress.match(/^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$/g)) {
                vm.$emit("error", "MinAddress incorreto por favor verifique.");
                $("#minadressx").removeClass("has-success");
                $("#minadressx").addClass("has-error");
                $("#minadressx input").focus();
            } else {
                $("#minadressx").removeClass("has-error");
                $("#minadressx").addClass("has-success");
            }
        }
    },
    mounted: function () {
        this.getDhcp();
    },
    template: "<div>\n\
                    <component is='alertpanel' :mensagem='mensagem' :erro='erro'></component>\n\
                    <div class='modal-body'>\n\
                        <div class='row'>\n\
                            <div class='col-md-4 form-group' id='maxadressx'>\n\
                                <label for='MaxAddress'>MaxAddress</label>\n\
                                <input class='form-control' v-model='info.MaxAddress' @change='changeips()'>\n\
                            </div>\n\
                            <div class='col-md-4 form-group' id='minadressx'>\n\
                                <label for='MinAddress'>MinAddress</label>\n\
                                <input class='form-control' v-model='info.MinAddress' @change='changeips()'>\n\
                            </div>\n\
                            <div class='col-md-4 form-group'>\n\
                                <label for='Estado'>Estado</label>\n\
                                <select class='form-control' v-model='info.DHCPServerEnable'>\n\
                                    <option value='1'>Habilitado</option>\n\
                                    <option value='0'>Desabilitado</option>\n\
                                </select>\n\
                            </div>\n\
                        </div>\n\
                    </div>\n\
                    <div class='modal-footer'>\n\
                        <button type='button' class='btn btn-default' data-dismiss='modal'>Fechar</button>\n\
                        <button type='button' class='btn btn-primary' @click='setDhcp()'>Alterar</button>\n\
                    </div>\n\
                </div>"
});