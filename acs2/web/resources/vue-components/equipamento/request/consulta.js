/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
Vue.component("consulta", {
    template: "<button type='button' class='btn btn-default'>{{titulo}}</button>",
    props: {
        titulo: {
            type: String
        }
    }
});
