create table blob_data
(
    id   INTEGER
        constraint blob_data_pk
            primary key autoincrement,
    data varchar
);

create table relation
(
    uid     INTEGER,
    blob_id INTEGER,
    constraint relation_pk
        primary key (uid, blob_id)
);

create table user
(
    id       INTEGER
        constraint user_pk
            primary key autoincrement,
    username varchar,
    api_key  varchar not null
);

