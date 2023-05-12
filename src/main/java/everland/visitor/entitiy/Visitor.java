package everland.visitor.entitiy;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.MetaValue;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Getter @Setter
@Table(name = "visitors")
@EntityListeners(AuditingEntityListener.class)
public class Visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String groupName;
    private int groupMembers;
    @Comment("날짜")
    @CreatedDate
    private LocalDateTime time;


    public Integer getId() {
        return id;
    }

//    public LocalDateTime getCurrentTime() {
//        return time;
//    }
//    public void setCurrentTime(LocalDateTime time) {
//        this.time = time;
//    }


}
