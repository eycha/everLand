package everland.visitor.controller;

import everland.visitor.entitiy.Visitor;
import everland.visitor.repository.VisitorRepository;
import everland.visitor.service.VisitorEnrollmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class VisitorApiController {

    @Autowired
    private VisitorRepository visitorRepository;
    @Autowired
    private VisitorEnrollmentServiceImpl visitorEnrollmentServiceImpl;


    @GetMapping("/visitors")
    List<Visitor> visitorList() {
        return visitorRepository.findAll();
    }

    @PostMapping("/visitors/enoroll")
    Visitor visitorCount(@RequestBody Visitor enollment) {
//        enollment.setCurrentTime(LocalDateTime.now());
        return visitorRepository.save(enollment);
    }

    @PutMapping("/visitors/{id}")
    Visitor replaceList(@RequestBody Visitor newVisitor, @PathVariable Integer id) {
        return visitorRepository.findById(id)
                .map(visitor -> {
                    visitor.setGroupName(newVisitor.getGroupName());
                    visitor.setGroupMembers(newVisitor.getGroupMembers());
                    return visitorRepository.save(visitor);
                })
                .orElseGet(() -> {
                    newVisitor.setId(id);
                    return visitorRepository.save(newVisitor);
                });
    }

    @DeleteMapping("/visitors/{id}")
    void deleteList(@PathVariable Integer id) {
        visitorRepository.deleteById(id);
    }

    @GetMapping("/visitors/group-count")
    Long countVisitors() {
        return visitorRepository.countVisitors();
    }

    @GetMapping("/visitors/members-count")
    Integer sumGroupMembers() {
        return visitorRepository.sumGroupMembers();
    }

    @GetMapping("/visitors/{date}/{hour}")
    Integer sumGroupMembersByDateAndHour(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @PathVariable int hour) {
        LocalDateTime startDateTime = date.atTime(hour, 0);
        LocalDateTime endDateTime = date.atTime(hour, 59, 59);
        List<Visitor> visitors = visitorRepository.findByTimeBetween(startDateTime, endDateTime);
        return visitors.stream()
                .mapToInt(Visitor::getGroupMembers)
                .sum();
    }


}
