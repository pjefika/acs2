/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global Vue */

Vue.config.devtools = true;
Vue.config.silent = true;


var vm = new Vue({
    el: "#instancia",
    data: {
        modal: {
            comp: '',
            titulo: 'Carregando...'
        },
        currentView: 'searchAction',
        notif: {
            mensagem: 'Default',
            tipo: 'danger'
        }
    },
    created: function() {
    },
    watch: {
        notif: function(val) {
            $.notify({
                // options
                message: val.mensagem
            }, {
                // settings
                type: val.tipo,
                z_index: 9999,
                newest_on_top: true,
                delay: 8000,
                timer: 1000,
                spacing: 10,
                animate: {
                    enter: 'animated zoomInUp',
                    exit: 'animated zoomOutDown',
                },
                placement: {
                    from: "top",
                    align: "center"
                }
            });
        }
    }
});



vm.$on('error', function(msg) {
    this.notif = {
        mensagem: msg,
        tipo: 'danger'
    };
});

vm.$on('info', function(msg) {
    this.notif = {
        mensagem: msg,
        tipo: 'info'
    };
});

vm.$on('success', function(msg) {
    this.notif = {
        mensagem: msg,
        tipo: 'success'
    };
});

vm.$on('loading', function(int) {
    loadingBar(int);
});

vm.$on('loadingBarLong', function(int) {
    loadingBarLong(int);
});

vm.$on('loaded', function() {
    loadedBar();
});



var bar = new ProgressBar.Line('#bar', {
    strokeWidth: 4,
    easing: 'easeInOut',
    duration: 5000,
    color: '#FFEA82',
    trailColor: '#eee',
    trailWidth: 1,
    svgStyle: {width: '100%', height: '100%'}
    ,
    from: {
        color: '#FFEA82'
    }
    ,
    to: {
        color: '#ED6A5A'
    }
}
);

function loadingBar(val) {
    bar.animate(0.96);
}

function loadingBarLong(val) {
    if (val) {
        bar.animate(0.98, {duration: val});
    } else {
        bar.animate(0.98, {duration: 12000});
    }
}
function loadedBar() {
    Vue.nextTick(function() {
        bar.animate(1, {duration: 500});
    })
}
