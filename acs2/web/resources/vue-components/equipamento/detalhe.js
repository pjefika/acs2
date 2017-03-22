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
        equipamento: {
            type: Equipamento,
            default: function() {
                return new Equipamento(this.eqpString);
            }
        }
    },
    mounted: function() {
        var self = this;
        /**
         * Gerando exceção quando chamado durante uma executeFuncion
         */
//        setInterval(function() {
//            console.log("Check Online");
//            self.checkOnline();
//        }, 30000);
    },
    methods: {
        checkOnline: _.debounce(function() {
            var self = this;
            $.ajax({
                type: "POST",
                url: url + "checkOnline/",
                data: JSON.stringify(new EquipamentoAdapted(self.equipamento)),
                dataType: "json",
                beforeSend: function(xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                },
                success: function(data) {
                    if(data.boolean != null){
                        self.equipamento.checkOn = data.boolean;    
                    }else{
                        self.equipamento.checkOn = false;    
                        vm.$emit("error", data.string);
                    }
                }
            });
        }, 1000)
    }
});