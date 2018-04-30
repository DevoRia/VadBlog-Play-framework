package controllers;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import repositories.MongoRepository;

import javax.inject.Inject;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    @Inject
    private MongoRepository repository;

    public Result index() {
        return ok(Json.toJson(repository.findAll()));
    }


}
