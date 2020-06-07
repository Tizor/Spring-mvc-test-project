create table customer
(
    customer_number serial not null
        constraint customer_pkey
            primary key,
    name            text,
    age             bigint,
    city            text
);

alter table customer
    add gender text,
    add birthday date,
    add married boolean,
    add email text,
    add password text,
    add profession text,
    add note text
;