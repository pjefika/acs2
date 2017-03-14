/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global Vue */

Vue.config.devtools = true;
Vue.config.silent = true;

var vm = new Vue({
    el: "#instancia",
    data: {
        modal: {
            comp: 'loading',
            titulo: 'Carregando...'
        },
        currentView: 'searchAction'
    },
    watch: {
        modal: function(m, oldVal) {
//            if (m.comp === "get-wifi") {
//                var _comp = vm.$children[0].$children[0].$children[0];
//                _comp.getWifi();
//            }
        }
    }
});
