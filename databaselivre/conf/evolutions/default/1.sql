# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table adherent (
  id_adh                        bigint auto_increment not null,
  nom                           varchar(255),
  prenom                        varchar(255),
  nb_annee_adh                  integer not null,
  adherent_mtn                  varchar(255),
  constraint pk_adherent primary key (id_adh)
);

create table livre (
  id                            bigint auto_increment not null,
  titre                         varchar(255),
  auteur                        varchar(255),
  annee_parue                   integer not null,
  prix                          double not null,
  constraint pk_livre primary key (id)
);

create table person (
  id                            bigint auto_increment not null,
  firstname                     varchar(255),
  age                           integer not null,
  constraint pk_person primary key (id)
);


# --- !Downs

drop table if exists adherent;

drop table if exists livre;

drop table if exists person;

