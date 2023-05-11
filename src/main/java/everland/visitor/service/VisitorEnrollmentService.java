package everland.visitor.service;

import everland.visitor.entitiy.Visitor;
import everland.visitor.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitorEnrollmentService {
    @Autowired
    private VisitorRepository visitorRepository;

    public void visitMembers(Visitor visitor) throws Exception {
        String groupName;
        int groupMembers;


    }
}
