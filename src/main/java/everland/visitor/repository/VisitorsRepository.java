package everland.visitor.repository;

import everland.visitor.entitiy.Visitors;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class VisitorsRepository extends JpaRepository<Visitors,Integer> {

}
