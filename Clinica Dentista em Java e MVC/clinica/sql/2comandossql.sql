
CREATE SEQUENCE paciente_id_seq
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 999999999999
    START 1
    CACHE 1;

    CREATE SEQUENCE dentista_id_seq
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 999999999999
    START 1
    CACHE 1;

    CREATE SEQUENCE consulta_id_seq
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 999999999999
    START 1
    CACHE 1;
create table paciente( 
id integer not null default nextval('paciente_id_seq'::regclass),
nome varchar (300),
rg varchar (30),
cpf varchar (20),
endereco varchar (500),
telefone varchar (11),
datanascimento varchar (20),
sexo varchar(20),
primary key (id));
create table dentista( 
id integer not null default nextval('dentista_id_seq'::regclass),
nome varchar (300),
cpf varchar (20),
rg varchar (30),
telefone varchar (11),
endereco varchar (500),
sexo varchar(20),
primary key (id));

create table consulta( 
id integer not null default nextval('consulta_id_seq'::regclass),
dentista varchar (300),
paciente varchar (300),
valor varchar (20),
datadaconsulta varchar (20),
situacaopag varchar (50),
primary key (id));

