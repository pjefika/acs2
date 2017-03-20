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
            type: String,
            default: ''
        }
    },
    template: "\
            <div>\n\
                <div v-show='mensagem' :class='leClass' style='font-size:15px' @click='fecha()'>\n\
                    {{leContent}}\n\
                </div>\n\
            </div>",
    computed: {
        leClass: function() {
            if (!this.erro) {
                return 'alert alert-danger';
            }
            return 'alert alert-success';
        },
        leContent: function(){
            switch (this.mensagem){
                case "device_could_not_be_found":
                    return "Equipamento não encontrado";
                    break;
                default:
                    return "Erro: "+this.mensagem;
                    break
            }
        }

    },
    methods: {
        fecha: function() {
            this.mensagem = '';
            if(this.$parent.mensagem != null){
                this.$parent.mensagem = '';
            }

        }
    }
});
