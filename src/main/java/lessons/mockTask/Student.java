package lessons.mockTask;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Класс Student
 * Описание: Этот класс представляет студента.
 * Поля:
 * String id: уникальный идентификатор студента.
 * String name: имя студента.
 * Конструктор:
 * Принимает id и name.
 * Методы:
 * Геттеры для полей id и name.
 */
@Getter
@AllArgsConstructor
public class Student {
    private String id;
    private String name;

}