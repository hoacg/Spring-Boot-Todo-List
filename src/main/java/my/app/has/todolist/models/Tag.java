package my.app.has.todolist.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tags")
@Data public class Tag {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @JsonIgnore
    @ManyToMany( cascade = CascadeType.ALL , fetch = FetchType.EAGER, mappedBy = "tags")
    private Set<Todo> todos = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return Objects.equals(title, tag.title);
    }
}
