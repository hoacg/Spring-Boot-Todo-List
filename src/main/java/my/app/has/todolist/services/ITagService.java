package my.app.has.todolist.services;

import my.app.has.todolist.models.Tag;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ITagService {
    List<Tag> getList();
    List<Tag> getAllByIds(List<Long> ids);
    Optional<Tag> getDetail(Long id);
    Tag save(Tag Tag);
    Tag updateById(Long id, Tag Tag);
}
