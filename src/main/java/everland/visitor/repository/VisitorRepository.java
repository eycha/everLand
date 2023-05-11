package everland.visitor.repository;

import everland.visitor.entitiy.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitorRepository extends JpaRepository<Visitor,Integer> {
}
