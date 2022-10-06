insert into spring5fs.BOARD ( title, content, writer, EMAIL, regdate, view)
	select title, content, writer, EMAIL, regdate, view from spring5fs.BOARD;

select count(*) from spring5fs.BOARD;