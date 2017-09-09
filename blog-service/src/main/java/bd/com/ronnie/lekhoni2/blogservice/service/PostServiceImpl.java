package bd.com.ronnie.lekhoni2.blogservice.service;

import bd.com.ronnie.lekhoni2.blogservice.domain.Post;
import bd.com.ronnie.lekhoni2.blogservice.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.invoke.MethodHandles;

@Service
@Transactional
public class PostServiceImpl implements PostService {

    private final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Post findOne(Long id) {
        return postRepository.findOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Post> findAll(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Override
    public Post save(Post comment) {
        return postRepository.save(comment);
    }

    @Override
    public void delete(Long id) {
        postRepository.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Post> findByTagsName(String tagName, Pageable pageable) {
        Page<Post> page;
        if (tagName == null || tagName.length() == 0) {
            page = postRepository.findAll(pageable);
        } else {
            page = postRepository.findByTagsName(tagName, pageable);
        }
        return page;
    }
}
