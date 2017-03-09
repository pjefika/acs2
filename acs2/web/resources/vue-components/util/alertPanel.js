/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
Vue.component("alertpanel", {
    props: ['mensagem', 'erro'],
    template: '\
            <div v-if="mensagem" :class="leClass" @click="fecha()">\n\
                {{mensagem}}\n\
            </div>\n\
    ',
    computed: {
        leClass: function () {
            if (!this.erro) {
                return 'alert alert-success'
            }
            return 'alert alert-danger'
        }
    },
    methods: {
        fecha: function () {
            this.mensagem = ''
        }
    }
});
