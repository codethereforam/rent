1. **user**

```
+----------+---------------------+------+-----+---------+----------------+
| Field    | Type                | Null | Key | Default | Extra          |
+----------+---------------------+------+-----+---------+----------------+
| user_id  | int(10) unsigned    | NO   | PRI | NULL    | auto_increment |
| username | varchar(20)         | NO   |     | NULL    |                |
| password | varchar(32)         | NO   |     | NULL    |                |
| role     | tinyint(3) unsigned | NO   |     | NULL    |                |
+----------+---------------------+------+-----+---------+----------------+
```

2. **category**

```
+-------------+------------------+------+-----+---------+----------------+
| Field       | Type             | Null | Key | Default | Extra          |
+-------------+------------------+------+-----+---------+----------------+
| category_id | int(10) unsigned | NO   | PRI | NULL    | auto_increment |
| name        | varchar(32)      | NO   |     | NULL    |                |
+-------------+------------------+------+-----+---------+----------------+
```

3. **stuff**

```
+-------------+---------------------+------+-----+---------+----------------+
| Field       | Type                | Null | Key | Default | Extra          |
+-------------+---------------------+------+-----+---------+----------------+
| stuff_id    | int(10) unsigned    | NO   | PRI | NULL    | auto_increment |
| category_id | int(10) unsigned    | NO   | MUL | NULL    |                |
| name        | varchar(32)         | NO   |     | NULL    |                |
| deposit     | int(10) unsigned    | NO   |     | NULL    |                |
| rental      | int(10) unsigned    | NO   |     | NULL    |                |
| status      | tinyint(3) unsigned | NO   |     | NULL    |                |
+-------------+---------------------+------+-----+---------+----------------+
```

4. **item**

```
+-------------+---------------------+------+-----+---------+----------------+
| Field       | Type                | Null | Key | Default | Extra          |
+-------------+---------------------+------+-----+---------+----------------+
| item_id     | int(10) unsigned    | NO   | PRI | NULL    | auto_increment |
| user_id     | int(10) unsigned    | NO   | MUL | NULL    |                |
| stuff_id    | int(10) unsigned    | NO   | MUL | NULL    |                |
| create_time | datetime            | YES  |     | NULL    |                |
| rent_day    | int(10) unsigned    | NO   |     | NULL    |                |
| end_time    | datetime            | YES  |     | NULL    |                |
| apply_time  | datetime            | NO   |     | NULL    |                |
| status      | tinyint(3) unsigned | NO   |     | NULL    |                |
+-------------+---------------------+------+-----+---------+----------------+
```