/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global Equipamento, Vue, XdslDiagnostics */

Vue.component("getDhcp", {
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
        info: {
            type: Dhcp,
            default: function() {
                return new Dhcp();
            }
        }
    },
    data: function() {
        return {mensagem: '', erro: ''};
    },
    methods: {
        getDhcp: function() {
            var self = this;
            $.ajax({
                type: "POST",
                url: "/acs/equipamento/getDhcp/",
                data: JSON.stringify(new EquipamentoAdapted(self.equipamento)),
                dataType: "json",
                beforeSend: function(xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                    self.$parent.loading = true;
                },
                success: function(data) {
                    if(data.dhcp != null){
                        self.info = new Dhcp(data.dhcp);    
                        vm.$emit("success", "Informações de DHCP obtidas com sucesso.");
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
        this.getDhcp();
    },
    template: "\
            <div class='modal-body'>\n\
                <component is='alertpanel' :mensagem='mensagem' :erro='erro'></component>\n\
                <div class='row'>\n\
                    <table class='table table-bordered table-condensed'>\n\
                        <thead>\n\
                            <tr>\n\
                                <th>MaxAddress</th>\n\
                                <th>MinAddress</th>\n\
                                <th>Estado</th>\n\
                            </tr>\n\
                        </thead>\n\
                        <tbody>\n\
                            <tr>\n\
                                <td>{{info.MaxAddress}}</td>\n\
                                <td>{{info.MinAddress}}</td>\n\
                                <td>\n\
                                    <div v-if='info.DHCPServerEnable == 1' style='color:green'>Up</div>\n\
                                    <div v-else style='color:red'>Down</div>\n\
                                </td>\n\
                            </tr>\n\
                        </tbody>\n\
                    </table>\n\
                </div>\n\
                <div class='modal-footer'>\n\
                    <button type='button' class='btn btn-default' data-dismiss='modal'>Fechar</button>\n\
                    <button type='button' class='btn btn-primary' @click='getDhcp()'>Consultar</button>\n\
                </div>\n\
            </div>"
});