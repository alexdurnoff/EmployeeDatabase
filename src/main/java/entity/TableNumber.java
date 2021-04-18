package entity;

import java.util.function.Predicate;

/**
 * Класс инкапсулирует табельный номер сотрудника.
 * Реализует интерфейс Predicate<TableNumber> для фильтрации списка.
 */
public class TableNumber implements Predicate<TableNumber> {
    /**
     * Табельный номер сотрудника
     */
    private final int tableNumberValue;


    /**
     * Значение по умолчанию. Если пользователь в текстовом поле фильтра не указывает
     * табельный номер сотрудника, то присваивается это значение.
     * В этом случае считаем, что наш метод тест будет возвращать true,
     * если прилетит TableNumber с таким номером.
     */
    private final static int defaultTableNumber = -100;


    private final static int incorrectValue = -200;


    /**
     * Основной конструктор. Создается из текстового поля, заполняемого пользователем.
     * Порэтому в качестве аргумента у нас строка. Если строка не парсится в число,
     * мы присваиваем табельному номеру значение по умолчанию.
     * @param number - строка из введенных пользователем данных.
     */
    public TableNumber(String number){
        int value;
        try {
            value = Integer.parseInt(number);
        } catch (NumberFormatException exception){
            System.out.println("exception in parsing int value");
            value = incorrectValue;
        }
        this.tableNumberValue = value;
    }

    /**
     * Конструктор без параметров. Присваивается значение по умолчанию.
     */
    public TableNumber(){
        this.tableNumberValue = defaultTableNumber;
    }


    /**
     * @param tableNumber - TableNumber, с которым сравниванееся наш табельный номер.
     * @return true, если табельные номера совпадают, или если в качестве аргумента метода
     * прилетел табельный номер со значением по умолчанию, т.е. -100.
     */
    @Override
    public boolean test(TableNumber tableNumber) {
        if (tableNumber.tableNumberValue == defaultTableNumber) return true;
        if (this.tableNumberValue == incorrectValue) return false;
        return this.tableNumberValue == tableNumber.tableNumberValue;
    }
}
