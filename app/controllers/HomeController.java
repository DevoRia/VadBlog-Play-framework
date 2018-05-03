package controllers;

import models.BlogFieldNames;
import models.BlogModel;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import services.TransferDataService;

import javax.inject.Inject;
import java.util.Date;

public class HomeController extends Controller {

    @Inject
    private FormFactory formFactory;

    @Inject
    private TransferDataService dataService;

    public Result index() {
        return ok(dataService.show());
    }

    public Result add() {
        DynamicForm dynamicForm = formFactory.form().bindFromRequest();
        BlogModel blogModel = new BlogModel(
                dynamicForm.get(BlogFieldNames.TITLE),
                dynamicForm.get(BlogFieldNames.AUTHOR),
                dynamicForm.get(BlogFieldNames.TEXT),
                new Date(),
                false );
        dataService.add(blogModel);
        return ok();
    }

    public Result edit(){
        DynamicForm dynamicForm = formFactory.form().bindFromRequest();
        dataService.edit(
                dynamicForm.get(BlogFieldNames.TITLE),
                dynamicForm.get(BlogFieldNames.TEXT)
        );
        return ok();
    }

    public Result remove(String id){
        dataService.remove(id);
        return ok();
    }


}
