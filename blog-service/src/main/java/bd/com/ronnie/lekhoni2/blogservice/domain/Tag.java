package bd.com.ronnie.lekhoni2.blogservice.domain;

import bd.com.ronnie.lekhoni2.commondomains.domain.AbstractAuditingEntity;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "tag")
public class Tag extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;

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

    @NotBlank
    @Length(max = 255)
    @Column(name = "name", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
