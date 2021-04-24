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
import java.util.ArrayList;
import java.util.List;

public class EmployeeCardPartitions implements CardPartitions{
    private final DataBase dataBase;
    private final int employeeId;

    public EmployeeCardPartitions(DataBase dataBase, int employeeId) {
        this.dataBase = dataBase;
        this.employeeId = employeeId;
    }

    @Override
    public List<CardPartition> cardPartitionList() throws SQLException {
        List<CardPartition> cardPartitionList = new ArrayList<>();
        cardPartitionList.add(new CardPartitionImpl(employeeId, "images", dataBase, new ImageEntityViewList(this.dataBase, this.employeeId).entityViewList()));
        cardPartitionList.add(new CardPartitionImpl(employeeId, "documents", dataBase, new DocumentEntityViewList(this.dataBase, this.employeeId).entityViewList()));
        cardPartitionList.add(new CardPartitionImpl(employeeId, "contacts", dataBase, new ContactsEntityViewList(this.dataBase, this.employeeId).contactsEntityViewList()));
        cardPartitionList.add(new CardPartitionImpl(employeeId, "jobs", dataBase, new JobEntityViewList(this.dataBase, this.employeeId).jobEntityViewList()));
        cardPartitionList.add(new CardPartitionImpl(employeeId, "military", dataBase, new MilitaryEntityViewList(this.dataBase, this.employeeId).militaryEntityList()));
        cardPartitionList.add(new CardPartitionImpl(employeeId, "education_and_family", dataBase, new EducationAndFamilyEntityViewList(this.dataBase, this.employeeId).entityViewList()));
        cardPartitionList.add(new CardPartitionImpl(employeeId, "certificate", dataBase, new CertificateEntityViewList(this.dataBase, this.employeeId).entityViewList()));
        cardPartitionList.add(new CardPartitionImpl(employeeId, "dossier", dataBase, new DossierEntityViewList(this.dataBase, this.employeeId).entityViewList()));
       /* cardPartitionList.add(new ImageCardPartition(this.dataBase, this.employeeId));
        cardPartitionList.add(new DocumentCardPartition(this.dataBase, this.employeeId));
        cardPartitionList.add(new ContactsCardPartition(this.dataBase, this.employeeId));
        cardPartitionList.add(new JobCardPartition(this.dataBase, this.employeeId));
        cardPartitionList.add(new MilitaryCardPartition(this.dataBase, this.employeeId));
        cardPartitionList.add(new EducationAndFamilyCardPartition(this.dataBase, this.employeeId));
        cardPartitionList.add(new CertificateCardPartition(this.dataBase, this.employeeId));
        cardPartitionList.add(new DossierCardPartition(this.dataBase, this.employeeId));*/
        return cardPartitionList;
    }
}
