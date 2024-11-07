CREATE TABLE TODO (
                      id INT PRIMARY KEY,
                      done BOOLEAN,
                      target_date DATE,
                      description VARCHAR(255),
                      username VARCHAR(255)
);

insert into to_do (done, id, target_date, description, username)
values (false, 10001, CURRENT_DATE(), 'Learn AWS', 'test1234');

insert into to_do (done, id, target_date, description, username)
values (false, 10002, CURRENT_DATE(), 'Learn Spring Boot 3 & 6', 'test1234');

insert into to_do (done, id, target_date, description, username)
values (false, 10003, CURRENT_DATE(), 'Learn AI & Photoshop 2024', 'test1234');