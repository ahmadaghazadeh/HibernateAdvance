create table credit_card (
                             id bigint not null auto_increment,
                             credit_card_number varchar(255),
                             cvv varchar(255),
                             expiration_date varchar(255),
                             primary key (id)
) engine=InnoDB;
 
create table dog (
                     id bigint not null,
                     body_temp integer,
                     species varchar(255),
                     breed varchar(255),
                     primary key (id)
) engine=InnoDB;
 
create table dolphin (
                         id bigint not null,
                         body_temp integer,
                         species varchar(255),
                         has_spots bit,
                         primary key (id)
) engine=InnoDB;
 
create table electric_guitar (
                                 number_of_pickups integer,
                                 id bigint not null,
                                 primary key (id)
) engine=InnoDB;
 
create table guitar (
                        number_of_strings integer,
                        id bigint not null,
                        primary key (id)
) engine=InnoDB;
 
create table hibernate_sequences (
                                     sequence_name varchar(255) not null,
                                     next_val bigint,
                                     primary key (sequence_name)
) engine=InnoDB;
 
insert into hibernate_sequences(sequence_name, next_val) values ('default',0);
 
create table instrument (
                            id bigint not null auto_increment,
                            primary key (id)
) engine=InnoDB;
 
create table order_header (
                              id bigint not null auto_increment,
                              customer_name varchar(255),
                              primary key (id)
) engine=InnoDB;
 
create table piano (
                       number_key integer,
                       id bigint not null,
                       primary key (id)
) engine=InnoDB;
 
create table vehicle (
                         vehicle_type integer not null,
                         id bigint not null auto_increment,
                         trim_level varchar(255),
                         payload integer,
                         primary key (id)
) engine=InnoDB;
 
alter table electric_guitar
    add constraint electric_guitar_guitar_fk
        foreign key (id)
            references guitar (id);
 
alter table guitar
    add constraint guitar_instrument_fk
        foreign key (id)
            references instrument (id);
 
alter table piano
    add constraint piano_instrument_fk
        foreign key (id)
            references instrument (id);