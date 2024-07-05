CREATE TABLE reactions
(
    id         int primary key auto_increment,
    created_at timestamp,
    video_id   int,
    value      varchar(128),
    author_id  int
);

INSERT INTO reactions(created_at,
                      video_id,
                      value,
                      author_id)
VALUES (current_timestamp(), 2, "like", 12),
       (current_timestamp(), 3, "like", 3),
       (current_timestamp(), 4, "dislike", 12),
       (current_timestamp(), 2, "like", 10),
       (current_timestamp(), 2, "dislike", 5);


CREATE TABLE comments
(
    id         int primary key auto_increment,
    created_at timestamp,
    video_id   int,
    content    varchar(128),
    author_id  int
);

INSERT INTO comments(created_at,
                     video_id,
                     content,
                     author_id)
VALUES (current_timestamp(), 2, "I like the video", 12),
       (current_timestamp(), 3, "likaldkfjhsjdhf dssfe", 3),
       (current_timestamp(), 4, "No, it is not!", 12),
       (current_timestamp(), 2, "like  that!", 10),
       (current_timestamp(), 2, "dislike for the opinion", 5);