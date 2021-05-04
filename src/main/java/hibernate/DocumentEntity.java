package hibernate;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "documents")
public class DocumentEntity implements HibernateEntity{
    @Id
    @Column(name = "employee_id")
    private int EmployeeId;

    @Column(name = "name")
    private String name;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "birth_date")
    private String birthDate;

    @Column(name = "document_type")
    private String documentType;

    @Column(name = "document_serial")
    private String documentSerial;

    @Column(name = "document_number")
    private int documentNumber;

    @Column(name = "document_publisher")
    private String documentPublisher;

    @Column(name = "document_release_date")
    private String releaseDate;

    @Column(name = "patronymic_name")
    private String patronymicName;

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int employeeId) {
        EmployeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentSerial() {
        return documentSerial;
    }

    public void setDocumentSerial(String documentSerial) {
        this.documentSerial = documentSerial;
    }

    public int getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(int documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getDocumentPublisher() {
        return documentPublisher;
    }

    public void setDocumentPublisher(String documentPublisher) {
        this.documentPublisher = documentPublisher;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPatronymicName() {
        return patronymicName;
    }

    public void setPatronymicName(String patronymicName) {
        this.patronymicName = patronymicName;
    }
}
