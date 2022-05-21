package me.matamor.backend.models.likes;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "likes")
@EntityListeners(AuditingEntityListener.class)
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bookId")
    private long contentId;

    @Column(name = "userId")
    private long userId;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Like(long contentId, long userId) {
        this.contentId = contentId;
        this.userId = userId;
    }
}
