/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global Vue, Equipamento, eqpString */
Vue.config.devtools = true;
Vue.config.silent = true;

var data = {
    inputToSearch: null
};


Vue.component("detail", {
    template: '#detalhequip',
    props: {
        eqpString: {
            type: String,
            required: true
        },
        eqp: {
            type: Equipamento,
            default: function() {
                return new Equipamento(this.eqpString);
            },
        }
    },
    data: function() {
        return data;
    }
});

new Vue({
    el: "#detalhe",
    data: data,
    created: function() {

    },
    methods: {
    }
});