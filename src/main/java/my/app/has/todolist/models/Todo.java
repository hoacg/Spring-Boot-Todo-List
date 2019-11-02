package my.app.has.todolist.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue
    private Long id;
    private String title;

    @ManyToOne
    private Category category;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Tag> tags = new HashSet<>();

    private boolean complete;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Todo)) return false;
        return id != null && id.equals(((Todo) o).getId());
    }

    public Todo() { }

    public Todo(String title, Category category, Set<Tag> tags, boolean complete) {
        this.title = title;
        this.category = category;
        this.tags = tags;
        this.complete = complete;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
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
