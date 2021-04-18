package entity;

import java.time.LocalDate;
import java.util.function.Predicate;

/**
 * Класс инкапсулирует дату начала работы сотрудника.
 * Реализует интерфейс Predicate<GettingStarted> для фильтрации списка.
 */
public class GettingStarted implements Predicate<GettingStarted> {
    /**
     * Дата начала работы сотрудника
     */
    private final LocalDate localDate;


    /**
     * Значение по умолчанию. Если пользователь в текстовом поле фильтра не указывает
     * дату начала работы, то присваивается эта дата. В этом случае считаем, что наш метод
     * тест будет возвращать true, если прилетит GettingStarted с такой датой.
     */
    private final static LocalDate defaultDate = LocalDate.of(1900, 1, 1);

    /**
     * Основной конструктор
     * @param localDate - дата начала работы.
     */
    public GettingStarted(LocalDate localDate) {
        this.localDate = localDate;
    }

    /**
     * Конструктор без параметров. Присваивается значение по умолчанию.
     */
    public GettingStarted(){
        this.localDate = defaultDate;
    }

    /**
     *
     * @param gettingStarted - GettingStarte, с которым сравнивается наша дата начала работы.
     * @return true, если даты начала совпадают, или если в качестве аргумента метода прилетело
     * GettingStarted со значением даты начала работы по умолчанию, т.е. 01 января 190ё0 года
     */
    @Override
    public boolean test(GettingStarted gettingStarted) {
        if (gettingStarted.localDate.equals(defaultDate)) return true;
        return this.localDate.equals(gettingStarted.localDate);
    }
}
