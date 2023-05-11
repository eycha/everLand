package everland.visitor.repository;

import everland.visitor.entitiy.Visitors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitorRepository extends JpaRepository<Visitors,Integer> {
}
