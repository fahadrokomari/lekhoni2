package bd.com.ronnie.blogservice.repository;

import bd.com.ronnie.blogservice.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
}
