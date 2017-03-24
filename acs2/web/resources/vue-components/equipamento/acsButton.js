/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global Vue, Equipamento, eqpString, CheckOnline, vm, Function */

var url = "/acs/equipamento/";

Vue.component("acsButton", {
    template: '<button type="button" class="list-group-item" @click="setComp()" v-bind:class="{disabled: !ativo}">{{acao}}</button>',
    props: {
        acao: {
            type: String,
            required: true,
            default: function() {
                return "Ação";
            }
        },
        comp: {
            type: String,
            required: true
        },
        ativo: {
            type: Boolean,
            required: true,
            default: function() {
                return true;
            }
        }
    },
    methods: {
        setComp: function() {
            var self = this;

            self.$emit('notif', 'setComp -> acsButton');

            if (self.ativo) {
                vm.modal = {
                    titulo: 'Carregando...',
                    comp: 'loading'
                };

                Vue.nextTick(function() {
                    self.ativo = false;
                    vm.modal = {
                        titulo: self.acao,
                        comp: self.comp
                    };

                    $("#actionModal").modal({
                        backdrop: 'static'
                    });
                    self.ativo = true;
                });
            }
        }
    }
});