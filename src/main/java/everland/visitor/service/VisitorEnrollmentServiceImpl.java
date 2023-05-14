package everland.visitor.service;

import everland.visitor.entitiy.Visitor;
import everland.visitor.repository.VisitorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
@Transactional
public class VisitorEnrollmentServiceImpl {
    @Autowired
    private VisitorRepository visitorRepository;

    //현재시간 받아오기
//    public Visitor visitorEnrollment(Integer id, LocalDateTime time)  {
//        Visitor visitor = new Visitor();
//        visitor.setCurrentTime(time);
//
//
//        return visitorRepository.save(visitor);
//    }

//    public int countGroups(Integer id) {
//        Visitor visitor = new Visitor();
//        visitor.getId();
//
//
//
//
//    }


}
