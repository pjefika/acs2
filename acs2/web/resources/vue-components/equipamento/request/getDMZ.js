/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global Equipamento, Vue, XdslDiagnostics */

Vue.component("getDmz", {
    props: {
        eqpString: {
            type: String,
            required: true
        },
        equipamento: {
            type: Equipamento,
            default: function() {
                return new Equipamento();
            }
        },
        dmz: {
            type: Dmz,
            default: function() {
                return new Dmz();
            }
        }
    },
    data: function() {
        return {mensagem: '', erro: ''};
    },
    methods: {
        getdmz: function() {
            var self = this;
            $.ajax({
                type: "POST",
                url: "/acs/equipamento/getDmzInfo/",
                data: JSON.stringify(new EquipamentoAdapted(self.equipamento)),
                dataType: "json",
                beforeSend: function(xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                    self.$parent.loading = true;
                },
                success: function(data) {
                    if(data.dmzInfo != null){
                        self.dmz = new Dmz(data.dmzInfo);    
                        vm.$emit("success", "Informações de DMZ obtidas com sucesso.");
                    }else{
                        vm.$emit("error", data.string);
                        $("#actionModal").modal("hide");
                    }                    
                },
                error: function(e) {
                    console.log(e);
                    self.mensagem = 'Falha ao buscar informações';
                    self.erro = 'true';
                },
                complete: function() {
                    self.$parent.loading = false;
                }
            });
        }
    },
    mounted: function() {
        this.getdmz();
    },
    template: "<div>\n\
                    <component is='alertpanel' :mensagem='mensagem' :erro='erro'></component>\n\
                    <div class='modal-body'>\n\
                        <table class='table table-bordered small'>\n\
                            <thead>\n\
                                <tr>\n\
                                    <th colspan='2' style='text-align: center;'>DMZ</th>\n\
                                </tr>\n\
                                <tr>\n\
                                    <th>Endereço de IP</th>\n\
                                    <td>{{dmz.IPAddress}}</td>\n\
                                </tr>\n\
                                <tr>\n\
                                    <th>Estado</th>\n\
                                    <td v-if='dmz.Enable'>Habilitado</td>\n\
                                    <td v-else>Desabilitado</td>\n\
                                </tr>\n\
                            </thead>\n\
                        </table>\n\
                    </div>\n\
                    <div class='modal-footer'>\n\
                        <button type='button' class='btn btn-default' data-dismiss='modal'>Fechar</button>\n\
                        <button type='button' class='btn btn-primary' @click='getdmz()'>Buscar</button>\n\
                    </div>\n\
                </div>"
});