package everland.visitor.repository;

import everland.visitor.entitiy.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor,Integer> {

    @Query("SELECT COUNT(v.id) FROM Visitor v")
    Long countVisitors();

    @Query("SELECT SUM(v.groupMembers) FROM Visitor v")
    Integer sumGroupMembers();

    @Query("SELECT SUM(v.groupMembers) FROM Visitor v WHERE DAYOFWEEK(v.time) = :dayOfWeek")
    Integer sumGroupMembersByDayOfWeek(@Param("dayOfWeek") int dayOfWeek);

    List<Visitor> findByTimeBetween(LocalDateTime startDateTime, LocalDateTime endDateTime);


}
