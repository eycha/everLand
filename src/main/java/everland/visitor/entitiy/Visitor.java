package everland.visitor.entitiy;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "visitors")
@EntityListeners(AuditingEntityListener.class)
public class Visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String groupName;
    private int groupMembers;
//    @CreatedDate
    private LocalDateTime time;

    @PrePersist
    public void prePersist() {
        if (time == null) {
            time = LocalDateTime.now();


        }
    }
}
