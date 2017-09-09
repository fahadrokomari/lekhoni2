package bd.com.ronnie.lekhoni2.blogservice.repository;

import bd.com.ronnie.lekhoni2.blogservice.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
