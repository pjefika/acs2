/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global Vue */

Vue.component("modal", {
    props: ['body', 'eqpString'],
    template: "<div class='modal fade' id='modaldefault' tabindex='-1' role='dialog' aria-labelledby='myModalLabel'>\n\
                <div class='modal-dialog modal-sm' role='document'>\n\
                    <div class='modal-content'>\n\
                        <div class='modal-header'>\n\
                            <button type='button' class='close' data-dismiss='modal' aria-label='Close'><span aria-hidden='true'>&times;</span></button>\n\
                            <h4 class='modal-title' id='myModalLabel'>Generic Modal</h4>\n\
                        </div>\n\
                        <div class='modal-body'>\n\
                          <component v-bind:eqp-string='eqpString' v-bind:is='body'></component> \n\
                        </div>\n\
                    </div>\n\
                </div>\n\
            </div>",
    mounted: function() {
//        if (this.body) {
//            $("#modaldefault").modal("show");
//        }

    }
});

