package everland.visitor.controller;

import everland.visitor.entitiy.Visitor;
import everland.visitor.repository.VisitorRepository;
import everland.visitor.service.VisitorEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/visitors/enroll")
    Visitor visitorCount(@RequestBody Visitor enollment) {
        visitorEnrollmentService.currentDate();
        return visitorRepository.save(enollment);

    }




}
