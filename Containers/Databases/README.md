## PostgreSQL

Backup data periodically:

docker exec -it <container_name> \
 pg_dump -U <user_name> --column-inserts --data-only <db_name> > \
 backup_data.sql

For example:

`docker exec -it postgres pg_dump -U postgres --column-inserts --data-only dvdrental > backup_data.sql`

https://www.tecmint.com/backup-and-restore-postgresql-database/

`pg_dump "host=localhost port=5432 dbname=blog user=postgres password=postgres" > mydb_export.sql`

Add a new job:

`crontab -e`

adding:

`0 0 * * * pg_dump "host=localhost port=5432 dbname=blog user=postgres password=postgres" > //home/andrei/Архив/Blog/database.sql`

## PostGIS
