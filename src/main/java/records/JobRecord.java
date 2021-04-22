package records;

public class JobRecord implements EntityRecord {
    @Override
    public boolean test(EntityRecord entityRecord) {
        return false;
    }
}
