/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global Vue, Equipamento, eqpString, CheckOnline, vm */

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
                    titulo: 'Titulo Dev'
                }
            }
        },
        eqpString: {
            type: String,
            required: true
        },
        eqp: {
            type: Equipamento,
            default: function() {
                return new Equipamento(this.eqpString);
            }
        }
    },
    methods: {
    }
});