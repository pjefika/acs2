/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global Vue */

Vue.component("modal", {
    props: ['body', 'eqpString', 'titulo', 'leId'],
    template: "<div class='modal fade' :id='leId' tabindex='-1' role='dialog' aria-labelledby='myModalLabel'>\n\
                <div class='modal-dialog modal-sm' role='document'>\n\
                    <div class='modal-content'>\n\
                        <div class='modal-header'>\n\
                            <button type='button' class='close' data-dismiss='modal' aria-label='Close'><span aria-hidden='true'>&times;</span></button>\n\
                            <h4 class='modal-title'>{{titulo}}</h4>\n\
                        </div>\n\
                        <div class='modal-body text-center'>\n\
                            <div class='body-content'>\n\
                                <component v-bind:eqp-string='eqpString' v-bind:is='body'></component> \n\
                            </div>\n\
                            <div class='leLoading' style='display:none'>\n\
                                <img src='/acs/resources/imagens/loading.gif'><br>\n\
                                Aguarde...\n\
                            </div>\n\
                        </div>\n\
                    </div>\n\
                </div>\n\
            </div>",
    methods:{
        loadingRequest: function() {
            $('#'+this.leId).find('.body-content').toggle();
            $('#'+this.leId).find('.leLoading').toggle();
        }
    }
});

