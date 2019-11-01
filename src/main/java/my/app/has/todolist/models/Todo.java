package my.app.has.todolist.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Todo {

    @Id
    @GeneratedValue
    private Long id;
    private String title;

    @ManyToOne
    private Category category;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Tag> tags;

    private boolean complete;

    public Todo() { }

    public Todo(String title, Category category, List<Tag> tags, boolean complete) {
        this.title = title;
        this.category = category;
        this.tags = tags;
        this.complete = complete;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
