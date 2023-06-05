create table roles
(
    id        bigint identity,
    authority varchar(255) not null,
    primary key (id),
    constraint UK_authority
        unique (authority)
)
go

create table tag32a
(
    id       bigint identity,
    amount   numeric(19, 4) not null,
    currency varchar(255)   not null,
    datetime date           not null,
    primary key (id)
)
go

create table tag33b
(
    id       bigint identity,
    amount   numeric(19, 4) not null,
    currency varchar(255)   not null,
    primary key (id)
)
go

create table users
(
    id                      bigint identity,
    account_non_expired     bit          not null,
    account_non_locked      bit          not null,
    credentials_non_expired bit          not null,
    enabled                 bit          not null,
    login                   varchar(255) not null,
    password                varchar(255) not null,
    username                varchar(255) not null,
    primary key (id),
    constraint UK_login
        unique (login)
)
go

create table cases
(
    id             bigint identity,
    datetime_close datetime2(6),
    datetime_open  datetime2(6) not null,
    reference      varchar(255) not null,
    status         bit          not null,
    user_id_close  bigint,
    user_id_open   bigint       not null,
    primary key (id),
    constraint UK_reference
        unique (reference),
    constraint FK_user_id_close_case
        foreign key (user_id_close) references users,
    constraint FK_user_id_open_case
        foreign key (user_id_open) references users
)
go

create table log
(
    id          bigint identity,
    datetime    datetime2(6) not null,
    description varchar(255) not null,
    url         varchar(255) not null,
    user_id     bigint       not null,
    primary key (id),
    constraint FK_user_id_log
        foreign key (user_id) references users
)
go

create table mt103
(
    id        bigint identity,
    receiver  varchar(255) not null,
    sender    varchar(255) not null,
    tag13c    varchar(255),
    tag20     varchar(255) not null,
    tag23b    varchar(255) not null,
    tag23e    varchar(255),
    tag26t    varchar(255),
    tag36     varchar(255),
    tag50a    varchar(255),
    tag50f    varchar(255),
    tag50k    varchar(255),
    tag51a    varchar(255),
    tag52a    varchar(255),
    tag52d    varchar(255),
    tag53a    varchar(255),
    tag53b    varchar(255),
    tag53d    varchar(255),
    tag54a    varchar(255),
    tag54b    varchar(255),
    tag54d    varchar(255),
    tag55a    varchar(255),
    tag55b    varchar(255),
    tag55d    varchar(255),
    tag56a    varchar(255),
    tag56c    varchar(255),
    tag56d    varchar(255),
    tag57a    varchar(255),
    tag57b    varchar(255),
    tag57c    varchar(255),
    tag57d    varchar(255),
    tag59     varchar(255),
    tag59a    varchar(255),
    tag59f    varchar(255),
    tag70     varchar(255),
    tag71a    varchar(255) not null,
    tag71g    varchar(255),
    tag72     varchar(255),
    tag77b    varchar(255),
    case_id   bigint,
    tag32a_id bigint,
    tag33b_id bigint,
    primary key (id),
    constraint FK_case_id_mt103
        foreign key (case_id) references cases,
    constraint FK_tag32a_id_mt103
        foreign key (tag32a_id) references tag32a,
    constraint FK_tag33b_id_mt103
        foreign key (tag33b_id) references tag33b
)
go

create table mt200
(
    id        bigint identity,
    receiver  varchar(255) not null,
    sender    varchar(255) not null,
    tag20     varchar(255) not null,
    tag53b    varchar(255),
    tag56a    varchar(255),
    tag56d    varchar(255),
    tag57a    varchar(255),
    tag57b    varchar(255),
    tag57d    varchar(255),
    tag72     varchar(255),
    case_id   bigint,
    tag32a_id bigint,
    primary key (id),
    constraint FK_case_id_mt200
        foreign key (case_id) references cases,
    constraint FK_tag32a_id_mt200
        foreign key (tag32a_id) references tag32a
)
go

create table mt202
(
    id        bigint identity,
    receiver  varchar(255) not null,
    sender    varchar(255) not null,
    tag13c    varchar(255),
    tag20     varchar(255) not null,
    tag21     varchar(255) not null,
    tag52a    varchar(255),
    tag52d    varchar(255),
    tag53a    varchar(255),
    tag53b    varchar(255),
    tag53d    varchar(255),
    tag54a    varchar(255),
    tag54b    varchar(255),
    tag54d    varchar(255),
    tag56a    varchar(255),
    tag56d    varchar(255),
    tag57a    varchar(255),
    tag57b    varchar(255),
    tag57d    varchar(255),
    tag58a    varchar(255),
    tag58d    varchar(255),
    tag72     varchar(255),
    case_id   bigint,
    tag32a_id bigint,
    primary key (id),
    constraint FK_case_id_mt202
        foreign key (case_id) references cases,
    constraint FK_tag32a_id_mt202
        foreign key (tag32a_id) references tag32a
)
go

create table mt202cov
(
    id        bigint identity,
    receiver  varchar(255) not null,
    sender    varchar(255) not null,
    tag13c    varchar(255),
    tag20     varchar(255) not null,
    tag21     varchar(255) not null,
    tag50a    varchar(255),
    tag50f    varchar(255),
    tag50k    varchar(255),
    tag52a    varchar(255),
    tag52a_2  varchar(255),
    tag52d    varchar(255),
    tag52d_2  varchar(255),
    tag53a    varchar(255),
    tag53b    varchar(255),
    tag53d    varchar(255),
    tag54a    varchar(255),
    tag54b    varchar(255),
    tag54d    varchar(255),
    tag56a    varchar(255),
    tag56a_2  varchar(255),
    tag56c    varchar(255),
    tag56d    varchar(255),
    tag56d_2  varchar(255),
    tag57a    varchar(255),
    tag57a_2  varchar(255),
    tag57b    varchar(255),
    tag57b_2  varchar(255),
    tag57c    varchar(255),
    tag57d    varchar(255),
    tag57d_2  varchar(255),
    tag58a    varchar(255),
    tag58d    varchar(255),
    tag59     varchar(255),
    tag59a    varchar(255),
    tag59f    varchar(255),
    tag70     varchar(255),
    tag72     varchar(255),
    tag72_2   varchar(255),
    case_id   bigint,
    tag32a_id bigint,
    tag33b_id bigint,
    primary key (id),
    constraint FK_case_id_mt202cov
        foreign key (case_id) references cases,
    constraint FK_tag32a_id_mt202cov
        foreign key (tag32a_id) references tag32a,
    constraint FK_tag33b_id_mt202cov
        foreign key (tag33b_id) references tag33b
)
go

create table mt900
(
    id        bigint identity,
    receiver  varchar(255) not null,
    sender    varchar(255) not null,
    tag13d    varchar(255),
    tag20     varchar(255) not null,
    tag21     varchar(255) not null,
    tag25     varchar(255),
    tag25p    varchar(255),
    tag52a    varchar(255),
    tag52d    varchar(255),
    tag72     varchar(255),
    case_id   bigint,
    tag32a_id bigint,
    primary key (id),
    constraint FK_case_id_mt900
        foreign key (case_id) references cases,
    constraint FK_tag32a_id_mt900
        foreign key (tag32a_id) references tag32a
)
go

create table mt910
(
    id        bigint identity,
    receiver  varchar(255) not null,
    sender    varchar(255) not null,
    tag13d    varchar(255),
    tag20     varchar(255) not null,
    tag21     varchar(255) not null,
    tag25     varchar(255),
    tag25p    varchar(255),
    tag50a    varchar(255),
    tag50f    varchar(255),
    tag50k    varchar(255),
    tag52a    varchar(255),
    tag52d    varchar(255),
    tag56a    varchar(255),
    tag56d    varchar(255),
    tag72     varchar(255),
    case_id   bigint,
    tag32a_id bigint,
    primary key (id),
    constraint FK_case_id_mt910
        foreign key (case_id) references cases,
    constraint FK_tag32a_id_mt910
        foreign key (tag32a_id) references tag32a
)
go

create table mtn92
(
    id       bigint identity,
    receiver varchar(255) not null,
    sender   varchar(255) not null,
    tag11s   varchar(255),
    tag20    varchar(255) not null,
    tag21    varchar(255) not null,
    tag79    varchar(2500),
    case_id  bigint,
    user_id  bigint,
    primary key (id),
    constraint FK_case_id_mtn92
        foreign key (case_id) references cases,
    constraint FK_user_id_mtn92
        foreign key (user_id) references users
)
go

create table mtn95
(
    id       bigint identity,
    receiver varchar(255) not null,
    sender   varchar(255) not null,
    tag11a   varchar(1800),
    tag20    varchar(255) not null,
    tag21    varchar(255) not null,
    tag75    varchar(255),
    tag77a   varchar(1800),
    tag79    varchar(2500),
    case_id  bigint,
    user_id  bigint,
    primary key (id),
    constraint FK_case_id_mtn95
        foreign key (case_id) references cases,
    constraint FK_user_id_mtn95
        foreign key (user_id) references users
)
go

create table mtn96
(
    id       bigint identity,
    receiver varchar(255) not null,
    sender   varchar(255) not null,
    tag11a   varchar(1800),
    tag20    varchar(255) not null,
    tag21    varchar(255) not null,
    tag76    varchar(255),
    tag77a   varchar(1800),
    tag79    varchar(2500),
    case_id  bigint,
    user_id  bigint,
    primary key (id),
    constraint FK_case_id_mtn96
        foreign key (case_id) references cases,
    constraint FK_user_id_mtn96
        foreign key (user_id) references users
)
go

create table mtn99
(
    id       bigint identity,
    receiver varchar(255) not null,
    sender   varchar(255) not null,
    tag20    varchar(255) not null,
    tag21    varchar(255) not null,
    tag79    varchar(2500),
    case_id  bigint,
    user_id  bigint,
    primary key (id),
    constraint FK_case_id_mtn99
        foreign key (case_id) references cases,
    constraint FK_user_id_mtn99
        foreign key (user_id) references users
)
go

create table tag71f
(
    id       bigint identity,
    amount   numeric(19, 4) not null,
    currency varchar(3)     not null,
    mt103_id bigint,
    primary key (id),
    constraint FK_mt103_id_mt103
        foreign key (mt103_id) references mt103
)
go

create table users_roles
(
    user_id bigint not null,
    role_id bigint not null,
    constraint fk_role_id
        foreign key (role_id) references roles,
    constraint fk_user_id
        foreign key (user_id) references users
)
go


