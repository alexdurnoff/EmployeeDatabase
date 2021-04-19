package entity;

import card.*;

public class Employee implements EmployeeEntity {
    private final int id;
    private final Image image;
    private final Job job;
    private final Document document;
    private final EducationAndFamily educationAndFamily;
    private final MilitaryRegistration militaryRegistration;
    private final Certificate certificate;
    private final Contacts contacts;
    private final Dossier dossier;

    public Employee(int id,
                    Image image,
                    Job job,
                    Document document,
                    EducationAndFamily educationAndFamily,
                    MilitaryRegistration militaryRegistration,
                    Certificate certificate,
                    Contacts contacts,
                    Dossier dossier) {
        this.id = id;
        this.image = image;
        this.job = job;
        this.document = document;
        this.educationAndFamily = educationAndFamily;
        this.militaryRegistration = militaryRegistration;
        this.certificate = certificate;
        this.contacts = contacts;
        this.dossier = dossier;
    }

    @Override
    public boolean filterByDocument(Document document) {
        return this.document.test(document);
    }

    @Override
    public boolean filterByJob(Job job) {
        return this.job.test(job);
    }

    @Override
    public boolean filterByEducationAndFamily(EducationAndFamily educationAndFamily) {
        return false;
    }

    @Override
    public boolean filterByMilitaryRegistration(MilitaryRegistration militaryRegistration) {
        return false;
    }

    @Override
    public boolean filterByCertificate(Certificate certificate) {
        return false;
    }

    @Override
    public EmployeeCard employeeCard() {
        return null;
    }


}
