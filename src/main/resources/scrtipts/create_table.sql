create table public.books
(
    id          serial primary key,
    title       varchar(30) not null,
    author      varchar(30) not null,
    date_added  timestamp not null
)

commit;

insert into public.books (title,author,date_added)
values('Недоросль', 'Д. И. Фонвизин', now()),
('Потерянный рай', 'Д. Мильтон', now() - interval '24h'),
('Война и мир', 'Л. Н. Толстой', now() - interval '24h'),
('Братья Крамазоны', 'Ф. М. Достоевский', now() - interval '24h')
);


select * from public.books