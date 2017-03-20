/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var url = "/acs/log/";

var data = {
    input: null,
    pick: "matricula",
    logs: null

}

Vue.component("buscaLog", {
    template: "<div>\n\
                    <label class='radio-inline'>\n\
                        <input type='radio' name='optionspick' v-model='pick' value='matricula'/>\n\
                        Matrícula\n\
                    </label>\n\
                    <label class='radio-inline'>\n\
                        <input type='radio' name='optionspick' v-model='pick' value='parametro'/>\n\
                        Parâmetros\n\
                    </label>\n\
                    <div class='input-group'>\n\
                        <input type='text' class='form-control' v-model='input'/>\n\
                        <span class='input-group-btn'>\n\
                            <button type='button' class='btn btn-default' @click='buscar()'>Consultar</button>\n\
                        </span>\n\
                    </div>\n\
                    <tabela-log>></tabela-log>\n\
                </div>",
    data: function () {
        return data;
    },
    methods: {
        buscar: function () {
            var self = this;
            if (self.input) {
                if (self.pick === 'matricula') {
                    $.get(url + "usr/" + self.input, function (data) {
                        self.logs = data.list;
                        console.log(data);
                    });
                } else {
                    $.get(url + "parametro/" + self.input, function (data) {
                        self.logs = data.list;
                        console.log(data);
                    });
                }
            } else {

            }
        }
    }
});

Vue.component("tabelaLog", {
    template: "<table class='table table-bordered'>\n\
                    <thead>\n\
                        <tr>\n\
                            <th>Login</th>\n\
                            <th>Ação</th>\n\
                            <th>Data</th>\n\
                            <th>Informações</th>\n\
                        </tr>\n\
                    </thead>\n\
                    <tbody>\n\
                        <tr v-for='log in logs'>\n\
                            <td>{{log.login}}</td>\n\
                            <td>{{log.acao}}</td>\n\
                            <td>{{dateFormat(log.calendar)}}</td>\n\
                            <td></td>\n\
                        </tr>\n\
                    </tbody>\n\
                </table>",
    methods: {
        dateFormat: function (h) {
            return  moment(h).format('DD/MM/YYYY HH:mm:ss');
        }
    },
    data: function () {
        return data;
    }
});