package org.example.ui;

import card.*;
import dao.DataBase;

import java.sql.SQLException;
import java.util.List;

public class AddEmployeeCard extends EmployeeCard {
    private final DataBase dataBase;

    public AddEmployeeCard(int employeeId, DataBase dataBase, EmployeeListVbox employeeListVbox) throws SQLException {
        super(employeeId, dataBase, employeeListVbox);
        this.cardPartitions = new DefaultCardPartitions(dataBase, employeeId);
        this.dataBase = dataBase;
    }

    @Override
    protected void update() throws SQLException {
        DocumentCardPartition documentCardPartition = getDocumentCardPartition();//Sql-запрос по документам должен быть выполнен первым.
        documentCardPartition.insertNewEmployee();
        this.cardPartitions.cardPartitionList().forEach(cardPartition -> {
            if (! (cardPartition.getClass() == DocumentCardPartition.class)) {
                try {
                    cardPartition.insertNewEmployee();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
        });
        this.setSaved(true);
    }

    private DocumentCardPartition getDocumentCardPartition() throws SQLException {
        List<CardPartition> cardPartitionList = this.cardPartitions.cardPartitionList();
        for (CardPartition cardPartition : cardPartitionList) {
            if (cardPartition.getClass() == DocumentCardPartition.class) return (DocumentCardPartition) cardPartition;
        }
        return new DocumentCardPartition(this.dataBase, employeeId);
    }
}
