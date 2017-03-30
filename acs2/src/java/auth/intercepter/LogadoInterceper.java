package auth.intercepter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.AcceptsWithAnnotations;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import auth.annotation.Logado;
import auth.controller.SessionUsuarioEfika;
import auth.controller.UsuarioController;
import auth.dal.webservice.Usuario;

@Intercepts
@RequestScoped
@AcceptsWithAnnotations(Logado.class)
public class LogadoInterceper {

    @Inject
    private Result result;

    @Inject
    private SessionUsuarioEfika session;

    /**
     * @deprecated CDI eyes only
     */
    protected LogadoInterceper() {

    }

    @Inject
    public LogadoInterceper(SessionUsuarioEfika session) {
        this.session = new SessionUsuarioEfika(new Usuario("G0042204", 10, "AKJHD"));
    }

    @AroundCall
    public void around(SimpleInterceptorStack stack) {

        try {
            if (true) {
                stack.next();
            } else {
                result.forwardTo(UsuarioController.class).logar();
            }
        } catch (Exception e) {
            result.forwardTo(UsuarioController.class).logar();
        }
    }

}
