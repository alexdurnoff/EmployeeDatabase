package records;

import java.util.function.Predicate;

public class DocumentRecord implements EntityRecord {

    @Override
    public boolean test(EntityRecord entityRecord) {
        return false;
    }
}
