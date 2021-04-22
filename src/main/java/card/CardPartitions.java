package card;

import java.sql.SQLException;
import java.util.List;

public interface CardPartitions {
    List<CardPartition> cardPartitionList() throws SQLException;
}
