package everland.visitor.entitiy;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.MetaValue;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Getter @Setter
@Table(name = "visitors")
public class Visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String groupName;
    private int groupMembers;
    public LocalDateTime time;

    public Integer getId() {
        return id;
    }

    public LocalDateTime getCurrentTime() {
        return time;
    }
    public void setCurrentTime(LocalDateTime time) {
        this.time = time;
    }


}
