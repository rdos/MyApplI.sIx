SELECT `name`, `sql`
  FROM `sqlite_master`
  WHERE type='table';


  CREATE TABLE `Crime` (`id` TEXT NOT NULL, 
  						`title` TEXT NOT NULL, 
  						`date` INTEGER NOT NULL, 
  						`isSolved` INTEGER NOT NULL, 
  						PRIMARY KEY(`id`));
  CREATE TABLE `Cat` (`id` TEXT NOT NULL, `id_id` TEXT NOT NULL, `date_date` TEXT NOT NULL, `url_url` TEXT NOT NULL, PRIMARY KEY(`id`))
  
  insert into Cat(id, id_id, date_date, url_url) values(3, "2476e2d9-df44-4ca5-ae75-0ee18ddbbee2", "2015-11-04T18:36:33.340Z", "www.thr.su/hello");
волшебные слова:: dелегировать...))
  select * from Cat;
  delete table cat;
Н1 5М21




SELECT 
	c.*,
	(select count(*) from cat b where c.id >= b.id) as cnt
  FROM cat c 
  where cnt <= 3