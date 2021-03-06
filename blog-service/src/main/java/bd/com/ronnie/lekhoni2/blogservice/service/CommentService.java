package bd.com.ronnie.lekhoni2.blogservice.service;

import bd.com.ronnie.lekhoni2.blogservice.domain.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentService {

    Comment findOne(Long id);

    Page<Comment> findAll(Pageable pageable);

    Comment save(Comment comment);

    void delete(Long id);

}
