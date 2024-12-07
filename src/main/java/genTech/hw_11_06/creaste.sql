-- Создать таблицу комментариев (comments) с использованием механизма валидации данных в SQL
create table comments
(
    id         int primary key auto_increment,
    created_at timestamp default current_timestamp,

    text       text not null,
    author_id  int  not null,
    track_id   int  not null,

    foreign key (author_id) references users (id),
    foreign key (track_id) references tracks (id)
);

-- Добавить в таблицу комментариев несколько записей

INSERT INTO comments (text, author_id, track_id)
VALUES ('Track 1', 5, 1),
       ('Track 2', 6, 2),
       ('Track 3', 5, 2),
       ('Track 4', 8, 3),
       ('Track 5', 3, 4)

-- Вывести ко-во комментариев на каждый трек (в упорядоченном виде)

SELECT COUNT(*)
from comments
GROUP BY track_id
ORDER BY track_id ASC