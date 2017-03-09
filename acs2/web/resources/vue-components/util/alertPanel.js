/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
Vue.component("alertpanel", {
    props: {
        msg: {}
    },
    template: '\
            <div :class="leClass" :style="leStyle" @click="fecha()">\n\
                {{mensagem}}\n\
            </div>\n\
    ',
    computed: {
        leClass: function(){
            return 'alert alert-'+this.tipo
        },
        leStyle: function(){
            return  {width: this.largura+'%', display: this.display, cursor: 'pointer'}
        },
        tipo: function(){
            if(this.msg.tipo){
                return this.msg.tipo;
            }else{
                return 'warning'
            }
        },
        mensagem: function(){
            if(this.msg.mensagem){
                return this.msg.mensagem;
            }else{
                return 'mensagem';
            }
        },
        largura: function(){
            if(this.msg.largura){
                return this.msg.largura;
            }else{
                return 100
            }
        },
        display: function(){
            if(this.msg.display){
                return this.msg.display
            }else{
                return 'none'
            }
        }
    },
    methods:{
        fecha: function(){
            this.msg = {}
        }
    }
});
