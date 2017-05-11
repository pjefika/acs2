package auth.intercepter;

import auth.annotation.Admin;
import auth.controller.SessionUsuarioEfika;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.AcceptsWithAnnotations;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import controller.HomeController;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@Intercepts
@RequestScoped
@AcceptsWithAnnotations(Admin.class)
public class AdminInterceper {

    @Inject
    private Result result;

    @Inject
    private SessionUsuarioEfika session;

    /**
     * @deprecated CDI eyes only
     */
    protected AdminInterceper() {

    }

    @Inject
    public AdminInterceper(SessionUsuarioEfika session) {
        this.session = session;
    }

    @AroundCall
    public void around(SimpleInterceptorStack stack) {
        if (session.getUsuario() == null) {
            restrito();
            return;
        }

        if (session.getUsuario().getNivel() > 7) {
            stack.next();
        } else {
            restrito();
        }
    }

    public void restrito() {
        result.forwardTo(HomeController.class).restrito();
    }
}
