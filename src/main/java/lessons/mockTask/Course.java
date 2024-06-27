package lessons.mockTask;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Класс Course
 * Описание: Этот класс представляет курс.
 * Поля:
 * String id: уникальный идентификатор курса.
 * String name: название курса.
 * Конструктор:
 * Принимает id и name.
 * Методы:
 * Геттеры для полей id и name.
 */
@Getter
@AllArgsConstructor
public class Course {
    private String id;
    private String name;
}