package org.example.ui;

import card.DefaultCardPartitions;
import card.EmployeeCard;
import card.EmployeeCardPartitions;
import dao.DataBase;

import java.sql.SQLException;

public class AddEmployeeCard extends EmployeeCard {
    public AddEmployeeCard(int employeeId, DataBase dataBase, EmployeeListVbox employeeListVbox) throws SQLException {
        super(employeeId, dataBase, employeeListVbox);
        this.cardPartitions = new DefaultCardPartitions(dataBase, employeeId);
    }

    @Override
    protected void update() throws SQLException {
        this.cardPartitions.cardPartitionList().forEach(cardPartition -> {
            try {
                cardPartition.insertNewEmployee();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        });
        this.setSaved(true);
    }
}
