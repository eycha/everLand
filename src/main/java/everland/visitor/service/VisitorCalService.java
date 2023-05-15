package everland.visitor.service;

import everland.visitor.entitiy.Visitor;

import java.time.LocalDate;
import java.util.List;

public interface VisitorCalService {
    List<Visitor> getVisitorList();

    Visitor enrollVisitor(Visitor enrollment);

    Visitor replaceVisitor(Integer id, Visitor newVisitor);

    void deleteVisitor(Integer id);

    Integer countVisitors();

    Integer sumGroupMembers();

    Integer sumGroupMembersByDateAndHour(LocalDate date, int hour);

    Integer sumGroupMembersByDate(LocalDate date);

    Integer sumGroupMembersByDayOfWeek(int dayOfWeek);

}
