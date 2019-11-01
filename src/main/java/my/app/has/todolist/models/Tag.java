package my.app.has.todolist.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Tag {
    @Id
    @GeneratedValue()
    private Long id;
    private String title;

    @JsonIgnore
    @ManyToMany( cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private List<Todo> todos;

    public Tag() { }

    public Tag(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }

    public Tag(String title, List<Todo> todos) {
        this.title = title;
        this.todos = todos;
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
