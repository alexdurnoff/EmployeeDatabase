package entity;

import card.EmployeeCard;

public interface EmployeeRecord {
    boolean filterByDocument(Document document);
    boolean filterByJob(Job job);
    boolean filterByEducationAndFamily(EducationAndFamily educationAndFamily);
    boolean filterByMilitaryRegistration(MilitaryRegistration militaryRegistration);
    boolean filterByCertificate(Certificate certificate);
    EmployeeCard employeeCard();
}
