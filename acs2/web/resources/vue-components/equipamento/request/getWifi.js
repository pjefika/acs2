/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
Vue.component("getWifi", {
    template: "<div class='modal fade'  tabindex='-1' role='dialog' aria-labelledby='myModalLabel'>\n\
                <div class='modal-dialog modal-sm' role='document'>\n\
                    <div class='modal-content'>\n\
                        <div class='modal-header'>\n\
                            <button type='button' class='close' data-dismiss='modal' aria-label='Close'><span aria-hidden='true'>&times;</span></button>\n\
                            <h4 class='modal-title' id='myModalLabel'>Configurações Rede WiFi</h4>\n\
                        </div>\n\
                        <div class='modal-body'>\n\
                            \n\
                        </div>\n\
                        <div class='modal-footer'>\n\
                            <button type='button' class='btn btn-default' data-dismiss='modal'>Fechar</button>\n\
                            <button type='button' class='btn btn-primary' @click='reboot()'>Resetar</button>\n\
                        </div>\n\
                    </div>\n\
                </div>\n\
            </div>",
    props: {
        wifi: {
            
        }
    }
});

