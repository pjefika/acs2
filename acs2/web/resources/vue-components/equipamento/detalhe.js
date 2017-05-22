/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global Vue, Equipamento, eqpString, CheckOnline, vm, _ */

var url = "/acs/equipamento/";

Vue.config.devtools = true;
Vue.config.silent = true;

Vue.component("detail", {
    template: '#detalhequip',
    props: {
        modal: {
            type: Object,
            required: true,
            default: function() {
                return {
                    comp: 'get-wifi',
                    titulo: 'Titulo Dev',
                    size: "normal"
                }
            }
        },
        eqpString: {
            type: String,
            required: true
        },
        equipamento: {
            type: Equipamento,
            default: function() {
                return new Equipamento(this.eqpString);
            }
        }
    },
    mounted: function() {
        var self = this;
        /**
         * Gerando exceção quando chamado durante uma executeFuncion
         */
//        setInterval(function() {
//            console.log("Check Online");
//            self.checkOnline();
//        }, 30000);
    },
    methods: {
        checkOnline: function() {
            var self = this;
            vm.$emit('loadingBarLong')
            self.checkOnlineRequest();
        },
        checkOnlineRequest: _.debounce(function() {
            var self = this;
            $.ajax({
                type: "POST",
                url: url + "checkOnline/",
                data: JSON.stringify(new EquipamentoAdapted(self.equipamento)),
                dataType: "json",
                beforeSend: function(xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                },
                success: function(data) {
                    if (data.boolean != null) {
                        self.equipamento.checkOn = data.boolean;
                        vm.$emit("success", "Status do equipamento atualizado.");
                    } else {
                        self.equipamento.checkOn = false;
                        vm.$emit("error", data.string);
                    }
                    vm.$emit('loaded');


                }
            });
        }, 2000),
        firmwareUpdate: function() {
            var self = this;
            /**
             * Utilizar este padrão para enviar duas variaveis json para a controller
             * @type type
             */
            var _data = {};
            _data.nbiDeviceData = new EquipamentoAdapted(self.equipamento);
            _data.info = self.equipamento.firmwareVersion;

            $.ajax({
                type: "POST",
                url: url + "updateFirmwareVersion/",
                data: JSON.stringify(_data),
                dataType: "json",
                beforeSend: function(xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                    vm.$emit('loadingBarLong')
                },
                success: function(data) {
                    vm.$emit("success", "Atualização de Firmware em execução.");
                    vm.$emit('loaded');
                },
                error: function(e) {
                    vm.$emit("error", "Falha ao realizar atualização.");
                },
                complete: function() {
                    self.$parent.loading = false;
                }
            });
        }
    }
});