package controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;

public abstract class AbstractController {

    @Inject
    protected Result result;

    @Inject
    protected Validator validation;

    public AbstractController() {

    }

}
