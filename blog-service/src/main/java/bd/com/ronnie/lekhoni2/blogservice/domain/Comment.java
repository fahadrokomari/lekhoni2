package bd.com.ronnie.lekhoni2.blogservice.domain;

import bd.com.ronnie.lekhoni2.blogservice.enumvalue.CommentStatus;
import bd.com.ronnie.lekhoni2.commondomains.domain.AbstractAuditingEntity;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "comment")
public class Comment extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long postId;
    private String title;
    private String content;
    private CommentStatus status;

    private Post post;

    @Id
    @NotNull
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @Column(name = "post_id", insertable = false, updatable = false)
    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    @NotBlank
    @Length(max = 255)
    @Column(name = "title", nullable = false, length = 255)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @NotBlank
    @Length(max = 65535)
    @Column(name = "content", nullable = false, length = 65535)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    public CommentStatus getStatus() {
        return status;
    }

    public void setStatus(CommentStatus status) {
        this.status = status;
    }

    @ManyToOne
    @JoinColumn(name = "post_id")
    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
