/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global Vue, pPPoEC */

var url = "/acs/equipamento/";

Vue.component("pppoeCredentials", {
    data: function () {
        return {
            infoPPPoE: {}
        };
    },
    props: {
        eqpString: {
            type: String,
            required: true
        },
        equipamento: {
            type: Equipamento,
            default: function () {
                return new Equipamento(this.eqpString);
            }
        },
        pPPoEcred: {
            type: pPPoEC,
            default: function () {
                return new pPPoEC();
            }
        }
    },
    methods: {
        getPPPoECredentials: function () {
            $.ajax({
                type: "POST",
                url: url + "getPPPoe/",
                data: JSON.stringify(this.equipamento),
                dataType: "json",
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Content-Type", "application/json");
                    $("#loadingModal").modal("show");
                },
                success: function (data) {
                    this.infoPPPoE = new pPPoEC(data.ppPoECredentialsInfo);
                    console.log(this.infoPPPoE);
                    $("#loadingModal").modal("hide");
                },
                error: function () {
                    $("#loadingModal").modal("hide");
                }
            });
        }
    },
    template: "<div class='form'>\n\
                    <div class='form-group'>\n\
                        <label for='username'>Username</label>\n\
                        <input class='form-control' v-model='infoPPPoE.username'>\n\
                    </div>\n\
                    <div class='form-group'>\n\
                        <label for='password'>Password</label>\n\
                        <input class='form-control' v-model='infoPPPoE.password'>\n\
                    </div>\n\
                    <button type='button' class='btn btn-primary' @click='getPPPoECredentials'>Buscar</button>\n\
               </div>"
});