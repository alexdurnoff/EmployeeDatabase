package org.example.ui;

import card.CardPartition;
import card.CardPartitions;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.sql.SQLException;
import java.util.List;

public class CardPartitionsScrollPane extends ScrollPane {
    private final CardPartitions cardPartitions;


    public CardPartitionsScrollPane(CardPartitions cardPartitions) throws SQLException {
        super();
        this.cardPartitions = cardPartitions;
        VBox vBox = new VBox();
        List<CardPartition> cardPartitionList = cardPartitions.cardPartitionList();
        for (CardPartition cardPartition : cardPartitionList) {
            vBox.getChildren().add(cardPartition.node());
        }
        this.setContent(vBox);
        this.setPrefViewportHeight(700);
        this.setPrefViewportWidth(1300);
        this.setVbarPolicy(ScrollBarPolicy.ALWAYS);
    }

    public ScrollPane scrollPane() throws SQLException {
        VBox vBox = new VBox();
        List<CardPartition> cardPartitionList = cardPartitions.cardPartitionList();
        for (CardPartition cardPartition : cardPartitionList) {
            vBox.getChildren().add(cardPartition.node());
        }
        return new ScrollPane(vBox);

    }
}
