create table public.rating
(
    id            bigserial not null,
    date          date,
    original_name varchar(255),
    rating        float8,
    voting_number int8,
    year          int4
);
alter table public.rating add constraint rating_unique unique (original_name, year);