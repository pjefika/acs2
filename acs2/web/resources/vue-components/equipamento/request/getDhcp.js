/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global Equipamento, Vue, XdslDiagnostics */

Vue.component("getDhcp", {
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
            type: Dhcp,
            default: function() {
                return new Dhcp();
            }
        }
    },
    data: function() {
        return {mensagem: '', erro: ''};
    },
    methods: {
        getDhcp: function() {
            var self = this;
            $.ajax({
                type: "POST",
                url: "/acs/equipamento/getDhcp/",
                data: JSON.stringify(new EquipamentoAdapted(self.equipamento)),
                dataType: "json",
                beforeSend: function(xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                    self.$parent.loading = true;
                },
                success: function(data) {
                    if(data.dhcp != null){
                        self.info = new Dhcp(data.dhcp);    
                        vm.$emit("success", "Informações de DHCP obtidas com sucesso.");
                    }else{
                        vm.$emit("error", data.string);
                        $("#actionModal").modal("hide");
                    }
                    
                },
                error: function(e) {
                    console.log(e);
                    self.mensagem = 'Falha ao buscar informações';
                    self.erro = 'true';
                },
                complete: function() {
                    self.$parent.loading = false;
                }
            });
        },
        setDhcp: function() {
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
                beforeSend: function(xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                    self.$parent.loading = true
                },
                success: function(data) {
                     if(data.dhcp != null){
                        self.info = new Dhcp(data.dhcp);    
                        vm.$emit("success", "Alterações realizadas com sucesso.");
                    }else{
                        vm.$emit("error", data.string);
                        $("#actionModal").modal("hide");
                    }
                },
                error: function(e) {
                    console.log(e);
                    vm.$emit("error", "Falha ao realizar alterações.");
                },
                complete: function() {
                    self.$parent.loading = false
                }
            });
        }
    },
    mounted: function() {
        this.getDhcp();
    },
    template: "\
            <div class='modal-body'>\n\
                <component is='alertpanel' :mensagem='mensagem' :erro='erro'></component>\n\
                <div class='row'>\n\
                    <div class='col-md-4 form-group'>\n\
                        <label for='MaxAddress'>MaxAddress</label>\n\
                        <input class='form-control' v-model='info.MaxAddress'>\n\
                    </div>\n\
                    <div class='col-md-4 form-group'>\n\
                        <label for='MinAddress'>MinAddress</label>\n\
                        <input class='form-control' v-model='info.MinAddress'>\n\
                    </div>\n\
                    <div class='col-md-4 form-group'>\n\
                        <label for='Estado'>Estado</label>\n\
                        <select class='form-control' v-model='info.DHCPServerEnable'>\n\
                            <option value='1'>Habilitado</option>\n\
                            <option value='0'>Desabilitado</option>\n\
                        </select>\n\
                    </div>\n\
                </div>\n\
                <div class='modal-footer'>\n\
                    <button type='button' class='btn btn-default' data-dismiss='modal'>Fechar</button>\n\
                    <button type='button' class='btn btn-primary' @click='setDhcp()'>Alterar</button>\n\
                </div>\n\
            </div>"
});