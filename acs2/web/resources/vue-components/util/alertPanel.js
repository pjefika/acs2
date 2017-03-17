/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
Vue.component("alertpanel", {
    props: {
        mensagem: {
            type: String,
            default: ''
        },
        erro: {
            type: String
        }
    }, 
    template: "\
            <div>\n\
                <div v-show='mensagem' :class='leClass' @click='fecha()'>\n\
                    {{mensagem}}\n\
                </div>\n\
            </div>",
    computed: {
        leClass: function () {
            if (!this.erro) {
                return 'alert alert-success'
            }
            return 'alert alert-danger'
        }

    },
    mounted: function () {
        alert('oi')
//        var self = this;
//        if (!self.mensagem) {
//            if (self.mensagem == "device_could_not_be_found") {
//                self.mensagem = 'Equipamento inexistente'
//            }else{
//                self.mensagem =  'Falha na comunicação com a plataforma Hdm'
//            }
//        }
        
    },
    methods: {
        fecha: function () {
            this.mensagem = ''
            if(this.$parent.mensagem != null){
                this.$parent.mensagem = ''
            }

        }
    }
});
