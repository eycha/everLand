package everland.visitor.service;

import everland.visitor.entitiy.Visitor;
import everland.visitor.repository.VisitorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
@Transactional
public class VisitorCalServiceImpl implements VisitorCalService{

    @Autowired
    private final VisitorRepository visitorRepository;

    @Override
    public List<Visitor> getVisitorList() {
        return visitorRepository.findAll();
    }

    @Override
    public Visitor enrollVisitor(Visitor enrollment) {
        return visitorRepository.save(enrollment);
    }

    @Override
    public Visitor replaceVisitor(Integer id, Visitor newVisitor) {
        return visitorRepository.findById(id)
                .map(visitor -> {
                    visitor.setGroupName(newVisitor.getGroupName());
                    visitor.setGroupMembers(newVisitor.getGroupMembers());
                    return visitorRepository.save(visitor);
                })
                .orElseThrow(()-> new NoSuchElementException("해당 id가 존재하지 않습니다."));
    }

    @Override
    public void deleteVisitor(Integer id) {
        visitorRepository.deleteById(id);
    }

    @Override
    public Integer countVisitors() {
        return visitorRepository.countVisitors();
    }

    @Override
    public Integer sumGroupMembers() {
        return visitorRepository.sumGroupMembers();
    }

    @Override
    public Integer sumGroupMembersByDateAndHour(LocalDate date, int hour) {
        LocalDateTime startDateTime = date.atTime(hour, 0);
        LocalDateTime endDateTime = date.atTime(hour, 59, 59, 999999);
        List<Visitor> visitors = visitorRepository.findByTimeBetween(startDateTime, endDateTime);
        return visitors.stream()
                .mapToInt(Visitor::getGroupMembers)
                .sum();
    }

    @Override
    public Integer sumGroupMembersByDate(LocalDate date) {
        LocalDateTime startDateTime = date.atTime(0, 0, 0);
        LocalDateTime endDateTime = date.atTime(23, 59, 59, 999999);
        List<Visitor> visitors = visitorRepository.findByTimeBetween(startDateTime, endDateTime);
        return visitors.stream()
                .mapToInt(Visitor::getGroupMembers)
                .sum();
    }

    @Override
    public Integer sumGroupMembersByDayOfWeek(int dayOfWeek) {
        return visitorRepository.sumGroupMembersByDayOfWeek(dayOfWeek);
    }
}