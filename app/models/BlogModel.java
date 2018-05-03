package models;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.util.Date;

@Entity(value = "blog.posts")
public class BlogModel{

    @Id
    private String _id;
    private String author;
    private String text;
    private Date date;
    private Boolean visiable;

    public BlogModel(String _id, String author, String text, Date date, Boolean visiable) {
        this._id = _id;
        this.author = author;
        this.text = text;
        this.date = date;
        this.visiable = visiable;
    }

    public BlogModel() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getVisiable() {
        return visiable;
    }

    public void setVisiable(Boolean visiable) {
        this.visiable = visiable;
    }
}
