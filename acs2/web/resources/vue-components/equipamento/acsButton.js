/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global Vue, Equipamento, eqpString, CheckOnline, vm, Function */

var url = "/acs/equipamento/";
var data = {};

Vue.config.devtools = true;
Vue.config.silent = true;

Vue.component("acsButton", {
    template: '<button type="button" class="list-group-item" @click="run()" v-bind:class="{disabled: !ativo}" data-toggle="modal" data-target="#modal" data-backdrop="static">{{acao}}</button>',
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
        },
        action: {
            type: Function,
            required: false,
            default: function() {
                alert('run')
            }
        }
    },
    methods: {
        getWifi: function() {
        },
        run: function() {
            var self = this;
            if (!ativo) {
                return;
            }
            self.action();
        }
    },
    data: function() {
        return data;
    }
});