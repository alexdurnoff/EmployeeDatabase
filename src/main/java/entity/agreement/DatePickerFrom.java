package entity.agreement;


import javafx.scene.control.DatePicker;

import java.time.LocalDate;

/**
 * Класс для получения даты заключения договора от пользователя.
 * Вынес в отдельный класс, чтобы можно было узнать класс через
 * Reflection и выбрать этот элемент из таблицы.
 * В единственном методе возвращает строковое значение даты
 * заключения договора.
 */
public class DatePickerFrom extends DatePicker {

    public DatePickerFrom(){
        super();
    }

    public DatePickerFrom(LocalDate localDate){
        super(localDate);
    }

    public String dateFrom(){
        return this.getValue().toString();//Пока так. Потом подумаем над форматом.
    }
}
