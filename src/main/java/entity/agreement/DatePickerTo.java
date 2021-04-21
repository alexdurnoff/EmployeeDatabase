package entity.agreement;

import javafx.scene.control.DatePicker;

import java.time.LocalDate;

/**
 * Класс для получения даты окончания действия договора подряда от пользователя.
 * Вынес в отдельный класс, чтобы можно было узнать класс через
 * Reflection и выбрать этот элемент из таблицы.
 * В единственном методе возвращает строковое значение даты
 * заключения договора.
 */
public class DatePickerTo extends DatePicker {

    public DatePickerTo(){
        super();
    }

    public DatePickerTo(LocalDate localDate){
        super(localDate);
    }


    public String dateTo(){
        return this.getValue().toString();//Пока так. Потом подумаем над форматом.
    }
}
