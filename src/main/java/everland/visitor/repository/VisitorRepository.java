package everland.visitor.repository;

import everland.visitor.entitiy.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor,Integer> {

    @Query("SELECT COUNT(v.id) FROM Visitor v")
    Long countVisitors();

    @Query("SELECT SUM(v.groupMembers) FROM Visitor v")
    Integer sumGroupMembers();

    List<Visitor> findByTimeBetween(LocalDateTime startDateTime, LocalDateTime endDateTime);

    @Query("SELECT SUM(v.groupMembers) FROM Visitor v WHERE DATE(v.time) = :date")
    Integer sumGroupMembersByDate(@Param("date") LocalDate date);

    @Query("SELECT SUM(v.groupMembers) FROM Visitor v WHERE DAYOFWEEK(v.time) = :dayOfWeek")
    Integer sumGroupMembersByDayOfWeek(@Param("dayOfWeek") int dayOfWeek);

}
