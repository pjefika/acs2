/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global Vue */

Vue.component("acsModal", {
    props: {
        body: {
            type: String,
            default: function() {
                return 'loading';
            }
        },
        // a number with default value
        data: {
            type: Object
        },
        titulo: {
            type: String,
            required: true
        },
        loading: {
            type: Boolean,
            default: function(){
                return false;
            }
        }
    },
    template: "<div class='modal fade' id='actionModal' tabindex='-1' role='dialog' aria-labelledby='myModalLabel'>\n\
                <div class='modal-dialog' role='document'>\n\
                    <div class='modal-content'>\n\
                        <div class='modal-header'>\n\
                            <button type='button' class='close' data-dismiss='modal' aria-label='Close'><span aria-hidden='true'>&times;</span></button>\n\
                            <h4 class='modal-title' v-text='titulo'></h4>\n\
                        </div>\n\
                        <div v-show='loading'>\n\
                            <component is='loading'></component>\n\
                        </div>\n\
                        <div v-show='!loading'>\n\
                            <component v-bind:eqp-string='data' v-bind:is='body'></component>\n\
                        </div>\n\
                    </div>\n\
                </div>\n\
            </div>",
});

