package controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;

public abstract class AbstractController {

    @Inject
    protected Result result;

    @Inject
    protected Validator validation;

    public AbstractController() {

    }

    /**
     * from(a).recursive() - para todos os campos;
     *
     * @param a
     */
    public void includeSerializer(Object a) {
        result.use(Results.json()).from(a).serialize();
    }

}
