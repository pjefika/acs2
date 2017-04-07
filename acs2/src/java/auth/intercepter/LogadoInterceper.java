package auth.intercepter;

import auth.annotation.Logado;
import auth.controller.SessionUsuarioEfika;
import auth.controller.UsuarioController;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.AcceptsWithAnnotations;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;


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
        this.session = session;
    }

    @AroundCall
    public void around(SimpleInterceptorStack stack) {

        try {
            if (!session.getUsuario().getLogin().isEmpty()) {
                stack.next();
            } else {
                result.forwardTo(UsuarioController.class).logar();                                
            }
        } catch (NullPointerException e) {
            result.forwardTo(UsuarioController.class).logar();
        }
    }

}
