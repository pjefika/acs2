/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global Vue, Equipamento, eqpString, CheckOnline, vm, Function */

var url = "/acs/equipamento/";

Vue.component("acsButton", {
    template: '<button type="button" class="list-group-item" @click="setComp()" v-bind:class="{disabled: !ativo}">{{acao}}</button>',
    props: {
        acao: {
            type: String,
            required: true,
            default: function() {
                return "Ação";
            }
        },
        exec: {
            type: Function
        },
        comp: {
            type: String,
            required: true
        },
        ativo: {
            type: Boolean,
            required: true,
            default: function() {
                return true;
            }
        }
    },
    methods: {
        setComp: function() {
            var self = this;
            if (self.ativo) {
                self.ativo = false
                vm.modal = {
                    titulo: self.acao,
                    comp: self.comp
                };
                setTimeout(function(){
                    $("#actionModal").modal("show");    
                    self.ativo = true
                },500)
                

                
            }

            
        }
    }
});




Vue.component("loading", {
    template: '<div class="modal-body" style="text-align: center;">\n\
                    <img src="/acs/resources/imagens/loading.gif">\n\
               </div>'
});