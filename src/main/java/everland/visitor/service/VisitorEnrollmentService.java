package everland.visitor.service;

import everland.visitor.entitiy.Visitor;
import everland.visitor.repository.VisitorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class VisitorEnrollmentService {
    @Autowired
    private VisitorRepository visitorRepository;

    
    //현재시간 받아오기
    public void currentDate()  {

        LocalDateTime now = LocalDateTime.now();
        System.out.println("시간==================="+now);




    }
}
