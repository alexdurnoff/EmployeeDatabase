package org.example.ui;

import card.CardPartition;
import card.CardPartitions;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.sql.SQLException;
import java.util.List;

public class CardPartitionsScrollPane extends ScrollPane {
    private final CardPartitions cardPartitions;


    public CardPartitionsScrollPane(CardPartitions cardPartitions) throws SQLException {
        this.cardPartitions = cardPartitions;
        VBox vBox = new VBox();
        List<CardPartition> cardPartitionList = cardPartitions.cardPartitionList();
        for (CardPartition cardPartition : cardPartitionList) {
            vBox.getChildren().add(cardPartition.node());
        }
    }
}
