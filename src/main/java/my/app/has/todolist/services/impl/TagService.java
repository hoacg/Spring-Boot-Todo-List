package my.app.has.todolist.services.impl;

import my.app.has.todolist.models.Tag;
import my.app.has.todolist.repositories.ITagRepository;
import my.app.has.todolist.services.ITagService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class TagService implements ITagService {

    private ITagRepository tagRepository;

    TagService(ITagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public Iterable<Tag> getList() {
        return tagRepository.findAll();
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
    public Iterable<Tag> getAllByIds(Set<Long> ids) {
        return tagRepository.findAllById(ids);
    }
}
