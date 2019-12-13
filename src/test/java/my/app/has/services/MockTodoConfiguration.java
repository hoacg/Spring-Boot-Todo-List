package my.app.has.services;

import my.app.has.todolist.repositories.ITodoRepository;
import my.app.has.todolist.services.ITodoService;
import my.app.has.todolist.services.impl.TodoService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class MockTodoConfiguration {

    @Bean
    public ITodoRepository todoRepository() {
        return Mockito.mock(ITodoRepository.class);
    }

    @Bean
    public ITodoService todoService() {
        return new TodoService();
    }
}
