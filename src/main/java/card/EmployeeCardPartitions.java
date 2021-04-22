package card;

import dao.DataBase;

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
        cardPartitionList.add(new ImageCardPartition(this.dataBase, this.employeeId));
        cardPartitionList.add(new DocumentCardPartition(this.dataBase, this.employeeId));
        cardPartitionList.add(new ContactsCardPartition(this.dataBase, this.employeeId));
        cardPartitionList.add(new JobCardPartition(this.dataBase, this.employeeId));
        cardPartitionList.add(new MilitaryCardPartition(this.dataBase, this.employeeId));
        cardPartitionList.add(new EducationAndFamilyCardPartition(this.dataBase, this.employeeId));
        cardPartitionList.add(new CertificateCardPartition(this.dataBase, this.employeeId));
        cardPartitionList.add(new DossierCardPartition(this.dataBase, this.employeeId));
        return cardPartitionList;
    }
}
