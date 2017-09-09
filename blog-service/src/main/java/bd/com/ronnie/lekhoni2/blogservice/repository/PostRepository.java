package bd.com.ronnie.lekhoni2.blogservice.repository;

import bd.com.ronnie.lekhoni2.blogservice.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    Page<Post> findByTagsName(String tagName, Pageable pageable);

}
