package records;

public class MilitaryRecord implements EntityRecord{
    @Override
    public boolean test(EntityRecord entityRecord) {
        return false;
    }
}
