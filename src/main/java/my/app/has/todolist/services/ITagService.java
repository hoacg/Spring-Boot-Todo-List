package my.app.has.todolist.services;

import my.app.has.todolist.models.Tag;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public interface ITagService {
    Set<Tag> getList();
    Iterable<Tag> getAllByIds(Set<Long> ids);
    Optional<Tag> getDetail(Long id);
    Tag save(Tag Tag);
    Tag updateById(Long id, Tag Tag);
}
