package my.app.has;

import my.app.has.todolist.models.Category;
import my.app.has.todolist.services.ICategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MyApplication.class)
public class CategoryServiceTest {

    @Autowired
    ICategoryService categoryService;

    @Test
    public void savedCategoryOk() {

        Category category = new Category();
        category.setTitle("Danh mục mới");

        Category savedCategory = categoryService.save(category);

        // make sure that category's id > 0
        assertThat(savedCategory.getId()).isGreaterThan(0);

    }

    @Test
    public void testFindByIdOk() {
        Optional<Category> categoryOptional = categoryService.getDetail(new Long(2));
        Category category = categoryOptional.get();

        assertThat(category.getId()).isEqualTo(2);
        assertThat(category.getTitle()).isEqualTo("Inbox");
    }
}
