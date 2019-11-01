package my.app.has.todolist.services.impl;

import my.app.has.todolist.models.Tag;
import my.app.has.todolist.repositories.ITagRepository;
import my.app.has.todolist.repositories.ITagRepository;
import my.app.has.todolist.services.ITagService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService implements ITagService {

    private ITagRepository tagRepository;

    TagService(ITagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public List<Tag> getList() {
        return (List<Tag>) tagRepository.findAll();
    }

    @Override
    public Optional<Tag> getDetail(Long id) {
        return tagRepository.findById(id);
    }

    @Override
    public Tag save(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public Tag updateById(Long id, Tag tag) {
        Optional<Tag> existedCatOpt = tagRepository.findById(id);
        Tag updatedTag;
        if (existedCatOpt.isPresent()) {
            Tag existedCat = existedCatOpt.get();
            existedCat.setTitle(tag.getTitle());
            updatedTag = tagRepository.save(existedCat);
        } else {
            updatedTag = tagRepository.save(tag);
        }
        return updatedTag;
    }

    @Override
    public List<Tag> getAllByIds(List<Long> ids) {
        return (List<Tag>) tagRepository.findAllById(ids);
    }
}
