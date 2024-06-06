create table teste.alunos(
	cod serial primary key,
    login varchar (100),
    senha integer
);

insert into teste.alunos (cod, login, senha) values('1435', 'William Cavalcante', '48622');
insert into teste.alunos (cod, login, senha) values('1436', 'Cleslley', '5678');

select * from teste.alunos
