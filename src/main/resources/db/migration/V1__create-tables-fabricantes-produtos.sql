create table fabricante (
    id int not null auto_increment "primary key",
    nome varchar(100) not null
 );

 create table produto (
     id int not null auto_increment primary key,
     nome varchar(100) not null,
     descricao varchar(100) not null,
     preco float not null,
     fabricante int not null,
     FOREIGN KEY (fabricante_id) REFERENCES fabricante (id)
  );
