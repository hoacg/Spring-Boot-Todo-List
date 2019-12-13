package my.app.has;

import my.app.has.todolist.models.Todo;
import my.app.has.todolist.services.ITodoService;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MyApplication.class)
public class TodoServiceTest {

    @Autowired
    private ITodoService todoService;

    @DisplayName("Saved todo has id greater than zero")
    @Test
    public void savedTodoHasId() {
        Todo todo = new Todo();
        todo.setTitle("Test new todo");
        Todo savedTodo = todoService.save(todo);
        assertThat(savedTodo.getId()).isGreaterThan(0);
    }
}
