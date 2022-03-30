set foreign_key_checks = 0;
truncate table organisation_visitor ;
truncate table staff;
truncate table visit;



insert into organisation_visitor(visitor_id, name, address, phone_number, email)
values (21, 'JIDE', 'NO.6 ABULE', '0803432', 'ade@gmail.com'),
       (22, 'Adeola ', 'NO.7 Agbado', '0807432', 'adeola@gmail.com'),
       (23, 'Kunle ', 'NO.8 Sabo', '08045332', 'Jide@gmail.com'),
       (24, 'Bola ', 'NO.9 Surulere', '08065432', 'ade@gmail.com');

insert into staff(id, name, address, phone_number, email)
values (21, 'Isreal', 'NO.6 ABUdE', '0803432', 'ade@gmail.com'),
       (22, 'Ademola ', 'NO.7 agbado', '0807432', 'adeola@gmail.com'),
       (23, 'Doe ', 'NO.8 yabo', '08045332', 'Jide@gmail.com'),
       (24, 'Poju ', 'NO.9 Surulere', '08065432', 'ade@gmail.com');
-- insert into visit(visit_id, visit_purpose, visitor_id, staff_id)
-- values(1,'official', 1, 1 );




