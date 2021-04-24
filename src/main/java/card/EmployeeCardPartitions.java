package card;

import dao.DataBase;
import entity.EntityView;
import entity.certificate.CertificateEntityViewList;
import entity.contacts.ContactsEntityViewList;
import entity.document.DocumentEntityViewList;
import entity.dossier.DossierEntityViewList;
import entity.educationandfamily.EducationAndFamilyEntityViewList;
import entity.image.ImageEntityViewList;
import entity.job.JobEntityViewList;
import entity.military.MilitaryEntityViewList;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeCardPartitions implements CardPartitions{
    private final DataBase dataBase;
    private final int employeeId;
    private final List<CardPartition> cardPartitionList;

    public EmployeeCardPartitions(DataBase dataBase, int employeeId) throws SQLException {
        this.dataBase = dataBase;
        this.employeeId = employeeId;
        this.cardPartitionList = new ArrayList<>();
        setupEntityViewList();
    }

    private void setupEntityViewList() throws SQLException {
        cardPartitionList.add(
                new CardPartitionImpl(
                        employeeId,
                        "images",
                        dataBase,
                        new ImageEntityViewList(dataBase, employeeId).entityViewList()
                )
        );
        cardPartitionList.add(
                new CardPartitionImpl(
                        employeeId,
                        "documents",
                        dataBase,
                        new DocumentEntityViewList(dataBase, employeeId).entityViewList()
                )
        );
        cardPartitionList.add(
                new CardPartitionImpl(
                        employeeId,
                        "contacts",
                        dataBase,
                        new ContactsEntityViewList(dataBase, employeeId).contactsEntityViewList()
                )
        );
        cardPartitionList.add(
                new CardPartitionImpl(
                        employeeId,
                        "jobs",
                        dataBase,
                        new JobEntityViewList(dataBase, employeeId).jobEntityViewList()
                )
        );
        cardPartitionList.add(
                new CardPartitionImpl(
                        employeeId,
                        "military",
                        dataBase,
                        new MilitaryEntityViewList(dataBase, employeeId).militaryEntityList()
                )
        );
        cardPartitionList.add(
                new CardPartitionImpl(
                        employeeId,
                        "education_and_family",
                        dataBase,
                        new EducationAndFamilyEntityViewList(dataBase, employeeId).entityViewList()
                )
        );
        cardPartitionList.add(
                new CardPartitionImpl(
                        employeeId,
                        "certificate",
                        dataBase,
                        new CertificateEntityViewList(dataBase, employeeId).entityViewList()
                )
        );
        cardPartitionList.add(
                new CardPartitionImpl(
                        employeeId,
                        "dossier",
                        dataBase,
                        new DossierEntityViewList(dataBase, employeeId).entityViewList()
                )
        );
    }

    @Override
    public List<CardPartition> cardPartitionList() throws SQLException {
        return cardPartitionList;
    }
}
