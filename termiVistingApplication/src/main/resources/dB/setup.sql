create  database termi_db;

create user 'termi_user'@'localhost' identified by 'pass_123';
grant all privileges  on termi_db.* to 'termi_user'@'localhost';
flush privileges;