package everland.visitor.controller;

import everland.visitor.entitiy.Visitor;
import everland.visitor.repository.VisitorRepository;
import everland.visitor.service.VisitorEnrollmentService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class VisitorApiController {

    @Autowired
    private VisitorRepository visitorRepository;
    @Autowired
    private VisitorEnrollmentService visitorEnrollmentService;


    @GetMapping("/visitors")
    List<Visitor> visitorList() {
        return visitorRepository.findAll();
    }

    @PostMapping("/visitors/e")
    Visitor visitorCount(@RequestBody Visitor enollment) {
//        enollment.setCurrentTime(LocalDateTime.now());
        return visitorRepository.save(enollment);
    }
//    @PostMapping("/visitors/e")
//    Visitor date(@RequestBody Visitor date) {
//        return visitorEnrollmentService.visitorEnrollment(date.getId(), date.getCurrentTime() );
//    }









}
