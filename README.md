# sk-task

 _The Java Spring Boot application manages simple test entity (id, obj::jsonb)._<br/>
 _Implemented increasing json attribute value in database._<br/>
 _All data stores in PosgreSQL Database._
___
Java version "17", Spring Boot version 3.0.0, PosgreSQL version 15.1<br/>
___
### How to use?
* Clone repository.
* Start PostgreSQL Server and create database with parameters:
  - dropdb --if-exists sk_example_db
  - dropuser --if-exists sk_example_user
  - createuser -P sk_example_user (password: pw)
  - psql -U sk_example_user -d sk_example_db <<EOF
  - CREATE TABLE sk_example_table (id SERIAL, obj JSONB NOT NULL, PRIMARY KEY(id));
  - INSERT INTO sk_example_table (obj) VALUES ('{"current":0}'::JSONB);
* Check spring connection property: "spring.datasource.url=jdbc:postgresql://localhost:5432/sk_example_db"
* Check spring.datasource.username&password settings.

API endpoints (http://localhost:3001):<br/>
* PUT /modify (increase json 'current' attribute value by 'add' value)<br/>
accepts JSON {"id": number, "add": number}
