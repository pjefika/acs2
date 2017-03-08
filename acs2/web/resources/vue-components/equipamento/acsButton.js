/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global Vue, Equipamento, eqpString, CheckOnline, vm, Function */

var url = "/acs/equipamento/";

Vue.config.devtools = true;
Vue.config.silent = true;

Vue.component("acsButton", {
    template: '<button type="button" class="list-group-item" @click="run()" v-bind:class="{disabled: !ativo}">{{acao}}</button>',
    props: {
        acao: {
            type: String,
            required: true,
            default: function() {
                return "Ação";
            }
        },
        ativo: {
            type: Boolean,
            required: true,
            default: function() {
                return false;
            }
        }
    },
    methods: {
        run: function() {
            var self = this;
            if (!self.ativo) {
                return;
            }
            $("#actionModal").modal("show");
        }
    }
});