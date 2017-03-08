/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

Vue.config.devtools = true;
Vue.config.silent = true;

var data = {
    modal: {
        comp: 'get-wifi',
        titulo: 'Titulo Dev'
    }
};

var vm = new Vue({
    el: "#instancia",
    data: data
});
