package everland.visitor.entitiy;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Visitors {

    @Id
    @GeneratedValue
    private Integer id;
    private String groupName;
    private int groupMembers;

}
