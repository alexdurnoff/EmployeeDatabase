package records;

/**
 * Запись по сотруднику в базе данных
 */
public interface EmployeeRecord {
    boolean filterByDocuments(DocumentRecord documentRecord);
    boolean filterByJob(JobRecord jobRecord);
    boolean filterByMilitary(MilitaryRecord militaryRecord);
    boolean filterByEducation(EducationRecord educationRecord);
    boolean filterByCertificate(CertificateRecord certificateRecord);

}
