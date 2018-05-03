package services;

import com.fasterxml.jackson.databind.JsonNode;
import models.BlogFieldNames;
import models.BlogModel;
import org.mongodb.morphia.query.UpdateOperations;
import play.libs.Json;
import repositories.MongoRepository;

import javax.inject.Inject;

public class TransferDataService {

    @Inject
    private MongoRepository repository;

    public JsonNode show () {
        return Json.toJson(repository.findAll());
    }

    public void add (BlogModel model) {
        repository.save(model);
    }

    public void edit (String title, String text) {
        BlogModel oldBlogModel = repository.findById(title);
        UpdateOperations<BlogModel> operation = repository.createOperation().set(BlogFieldNames.TEXT, text);
        repository.edit(oldBlogModel, operation);
    }

    public void remove (String id) {
        repository.remove(id);
    }

}
