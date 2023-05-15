package everland.visitor.controller;

import everland.visitor.entitiy.Visitor;
import everland.visitor.service.VisitorCalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/")
public class VisitorApiController {

    @Autowired
    private VisitorCalServiceImpl visitorCalServiceImpl;

    @GetMapping("/visitors")
    List<Visitor> visitorList() {
        return visitorCalServiceImpl.getVisitorList();
    }

    @PostMapping("/visitors/enroll")
    Visitor visitorCount(@RequestBody Visitor enrollment) {
        return visitorCalServiceImpl.enrollVisitor(enrollment);
    }

    @PutMapping("/visitors/{id}")
    Visitor replaceList(@RequestBody Visitor newVisitor, @PathVariable Integer id) {
        return visitorCalServiceImpl.replaceVisitor(id, newVisitor);
    }

    @DeleteMapping("/visitors/{id}")
    void deleteList(@PathVariable Integer id) {
        visitorCalServiceImpl.deleteVisitor(id);
    }

    @GetMapping("/visitors/group-count")
    Integer countVisitors() {
        return visitorCalServiceImpl.countVisitors();
    }

    @GetMapping("/visitors/members-count")
    Integer sumGroupMembers() {
        return visitorCalServiceImpl.sumGroupMembers();
    }

    @GetMapping("/visitors/date/{date}/{hour}")
    Integer sumGroupMembersByDateAndHour(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @PathVariable int hour) {
        return visitorCalServiceImpl.sumGroupMembersByDateAndHour(date, hour);
    }

    @GetMapping("/visitors/date/{date}")
    Integer sumGroupMembersByDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return visitorCalServiceImpl.sumGroupMembersByDate(date);
    }

    @GetMapping("/visitors/week/{dayOfWeek}")
    Integer sumGroupMembersByDayOfWeek(@PathVariable int dayOfWeek) {
        return visitorCalServiceImpl.sumGroupMembersByDayOfWeek(dayOfWeek);
    }

}
