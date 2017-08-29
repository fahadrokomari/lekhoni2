package bd.com.ronnie.blogservice.service;

import bd.com.ronnie.blogservice.domain.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TagService {

    Tag findOne(Long id);

    Page<Tag> findAll(Pageable pageable);

    Tag save(Tag tag);

    void delete(Long id);

}
