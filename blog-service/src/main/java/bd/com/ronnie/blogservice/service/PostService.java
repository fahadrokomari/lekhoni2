package bd.com.ronnie.blogservice.service;

import bd.com.ronnie.blogservice.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {

    Post findOne(Long id);

    Page<Post> findAll(Pageable pageable);

    Post save(Post post);

    void delete(Long id);

}
