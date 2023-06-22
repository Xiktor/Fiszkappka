create table fiche (
    id integer not null auto_increment,
    word_in_mother_language varchar(255),
    word_in_foreign_language varchar(255),
    language_id integer,
    primary key (id)
) engine=InnoDB;

alter table fiche add constraint fiche_fk0 foreign key (language_id) references language (id);

insert into fiche
        (word_in_mother_language, word_in_foreign_language, language_id)
values
        ('Czerwony', 'Red', (select id from language where id = 1)),
        ('Czarny', 'Black', (select id from language where id = 1)),
        ('Żółty', 'Yellow', (select id from language where id = 1)),
        ('Fioletowy', 'Purple', (select id from language where id = 1)),
        ('Niebieski', 'Blue', (select id from language where id = 1)),
        ('Biały', 'White', (select id from language where id = 1)),
        ('Zielony', 'Green', (select id from language where id = 1)),
        ('Czerwony', 'Rojo', (select id from language where id = 2)),
        ('Czarny', 'Negro', (select id from language where id = 2)),
        ('Biały', 'Blanco', (select id from language where id = 2)),
        ('Azul', 'Azul', (select id from language where id = 2)),
        ('Czerwony', 'Rosso', (select id from language where id = 3));