create table language (
    id integer not null auto_increment,
    name varchar(255),
    primary key (id)
) engine=InnoDB;

insert into language
        (name)
values
        ("Angielski"),
        ("Hiszpański"),
        ("Włoski"),
        ("Szwedzki");