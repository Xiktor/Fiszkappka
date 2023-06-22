create table test (
    id integer not null auto_increment,
    score integer,
    resolved datetime,
    language_name varchar(255),
    question1 varchar(255),
    question2 varchar(255),
    question3 varchar(255),
    correct_answer1 varchar(255),
    correct_answer2 varchar(255),
    correct_answer3 varchar(255),
    user_answer1 varchar(255),
    user_answer2 varchar(255),
    user_answer3 varchar(255),
    primary key (id)
) engine=InnoDB;

insert into test
        (score, resolved, language_name)
values
        ('60', '2022-06-25 09:34:21', 'Angielski'),
        ('95', '2021-06-10 12:34:24', 'Angielski'),
        ('80', '2018-04-27 17:56:21', 'Włoski'),
        ('100', '2021-11-11 23:23:56', 'Norweski'),
        ('23', now(), 'Włoski'),
        ('37', now(), 'Japoński');