package bd.com.ronnie.lekhoni2.blogservice.service;

import bd.com.ronnie.lekhoni2.blogservice.domain.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TagService {

    Tag findOne(Long id);

    Page<Tag> findAll(Pageable pageable);

    Tag save(Tag tag);

    void delete(Long id);

}
