package card;

import dao.DataBase;
import entity.certificate.CertificateEntityViewList;
import entity.contacts.ContactsEntityViewList;
import entity.document.DocumentEntityViewList;
import entity.dossier.DossierEntityViewList;
import entity.educationandfamily.EducationAndFamilyEntityViewList;
import entity.image.ImageEntityViewList;
import entity.job.JobEntityViewList;
import entity.military.MilitaryEntityViewList;

import java.sql.SQLException;


/**
 * Класс будет возвращать дефолтный список CardPartitions
 */
public class DefaultCardPartitions extends EmployeeCardPartitions {
    public DefaultCardPartitions(DataBase dataBase, int employeeId) throws SQLException {
        super(dataBase, employeeId);
        this.cardPartitionList.clear();
        this.setupEntityViewList();
    }

    @Override
    protected void setupEntityViewList() throws SQLException {
        cardPartitionList.add(
                new CardPartitionImpl(
                        employeeId,
                        "images",
                        dataBase,
                        new ImageEntityViewList(dataBase, employeeId).defaultList()
                )
        );
        cardPartitionList.add(
                new CardPartitionImpl(
                        employeeId,
                        "documents",
                        dataBase,
                        new DocumentEntityViewList(dataBase, employeeId).defaultList()
                )
        );
        cardPartitionList.add(
                new CardPartitionImpl(
                        employeeId,
                        "contacts",
                        dataBase,
                        new ContactsEntityViewList(dataBase, employeeId).defaultList()
                )
        );
        cardPartitionList.add(
                new CardPartitionImpl(
                        employeeId,
                        "jobs",
                        dataBase,
                        new JobEntityViewList(dataBase, employeeId).defaultList()
                )
        );
        cardPartitionList.add(
                new CardPartitionImpl(
                        employeeId,
                        "military",
                        dataBase,
                        new MilitaryEntityViewList(dataBase, employeeId).defaultList()
                )
        );
        cardPartitionList.add(
                new CardPartitionImpl(
                        employeeId,
                        "education_and_family",
                        dataBase,
                        new EducationAndFamilyEntityViewList(dataBase, employeeId).defaultList()
                )
        );
        cardPartitionList.add(
                new CardPartitionImpl(
                        employeeId,
                        "certificate",
                        dataBase,
                        new CertificateEntityViewList(dataBase, employeeId).defaultList()
                )
        );
        cardPartitionList.add(
                new CardPartitionImpl(
                        employeeId,
                        "dossier",
                        dataBase,
                        new DossierEntityViewList(dataBase, employeeId).defaultList()
                )
        );
    }
}
