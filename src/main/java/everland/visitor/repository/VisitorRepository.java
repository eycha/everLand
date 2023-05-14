package everland.visitor.repository;

import everland.visitor.entitiy.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor,Integer> {

    @Query("SELECT COUNT(v.id) FROM Visitor v")
    Long countVisitors();

    @Query("SELECT SUM(v.groupMembers) FROM Visitor v")
    Integer sumGroupMembers();
}
