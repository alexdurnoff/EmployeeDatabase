package daoservice;

import dao.DataBase;
import entity.Employee;
import entity.EmployeeEntity;
import java.sql.SQLException;
import java.util.*;

public class EmployeeDaoService implements EmployeeService{
    private final EmployeeRecordService employeeRecordService;
    private final JobService jobService;
    private final CertificateService certificateService;
    private final DocumentService documentService;
    private final DossierService dossierService;
    private final EducationAndFamilyService educationAndFamilyService;
    private final ImageService imageService;
    private final ContactService contactService;
    private final MilitaryRegistrationService militaryRegistrationService;
    private final Map<Integer, EmployeeEntity> employeeMap;

    public EmployeeDaoService(DataBase dataBase) {
        this.employeeRecordService = new EmployeeRecordDaoService(dataBase);
        this.jobService = new JobDaoService(dataBase);
        this.certificateService = new CertificateDaoService(dataBase);
        this.documentService = new DocumentDaoService(dataBase);
        this.dossierService = new DossierDaoService(dataBase);
        this.imageService = new ImageDaoService(dataBase);
        this.contactService = new ContactDaoService(dataBase);
        this.educationAndFamilyService = new EducationAndFamilyDaoService(dataBase);
        this.militaryRegistrationService = new MilitiryRegistrationDaoService(dataBase);
        this.employeeMap = new HashMap<>();
        updateEmployeeList();
    }

    private void updateEmployeeList() {
        this.employeeRecordService.employeeIdList().forEach(id -> {
            EmployeeEntity employeeEntity = new Employee(
                    id,
                    this.imageService.findByEmployeeId(id),
                    this.jobService.findByEmployeeId(id),
                    this.documentService.findByEmployeeId(id),
                    this.educationAndFamilyService.findByEmployeeId(id),
                    this.militaryRegistrationService.findByEmployeeId(id),
                    this.certificateService.findByEmployeeId(id),
                    this.contactService.findByEmployeeId(id),
                    this.dossierService.findByEmployeeId(id)
            );
            this.employeeMap.put(id, employeeEntity);
        });
    }


    @Override
    public List<EmployeeEntity> employeeList() {
        return new ArrayList<>(this.employeeMap.values());
    }

    @Override
    public EmployeeEntity findById(int employeeId) {
        return this.employeeMap.get(employeeId);
    }
}
