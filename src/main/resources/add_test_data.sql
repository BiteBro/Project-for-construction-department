/**
 * Author:  ralew
 * Created: 06.12.2020
 */
/*
 * Script for insert test data in DB.
 */
INSERT INTO `skynet_cd`.`position` (`position_name`) VALUES ('Администратор');
INSERT INTO `skynet_cd`.`position` (`position_name`) VALUES ('Инженер');
INSERT INTO `skynet_cd`.`position` (`position_name`) VALUES ('Бригадир');
INSERT INTO `skynet_cd`.`position` (`position_name`) VALUES ('Кладовщик');

INSERT INTO `skynet_cd`.`user` (`first_name`, `second_name`, `patronymic`, `id_position`, `login`, `password`) VALUES ('Соколов', 'Сергей', 'Федорович', '1', 'sss', 'sss');
INSERT INTO `skynet_cd`.`user` (`first_name`, `second_name`, `patronymic`, `id_position`, `login`, `password`) VALUES ('Прокопьев', 'Федор', 'Михайлович', '2', 'ppp', 'ppp');
INSERT INTO `skynet_cd`.`user` (`first_name`, `second_name`, `patronymic`, `id_position`, `login`, `password`) VALUES ('Букин', 'Генадий', 'Петрович', '3', 'bbb', 'bbb');
INSERT INTO `skynet_cd`.`user` (`first_name`, `second_name`, `patronymic`, `id_position`, `login`, `password`) VALUES ('Заломатин', 'Михаил', 'Андреевич', '4', 'zzz', 'zzz');

INSERT INTO `skynet_cd`.`task` (`task_address`, `id_user_executor_task`, `id_user_creator_task`, `task_status`, `task_date`) VALUES ('ул. Новая 8', '2', '3', 'получение', '2020-04-04 09:29:43');
INSERT INTO `skynet_cd`.`task` (`task_address`, `id_user_executor_task`, `id_user_creator_task`, `task_status`, `task_date`) VALUES ('Заречная 12', '2', '3', 'в процессе', '2020-04-03 11:23:43');
INSERT INTO `skynet_cd`.`task` (`task_address`, `id_user_executor_task`, `id_user_creator_task`, `task_status`, `task_date`) VALUES ('Пискаревский просп. 71', '2', '3', 'выполнено', '2020-04-02 08:49:43');

INSERT INTO `skynet_cd`.`report` (`report_address`, `report_date`, `report_apartment_quantity`, `report_box_position`, `report_point_energy`, `id_task`) VALUES ('ул. Новая 8', '2020-04-07 09:29:43', '174', 'подвал', 'грщ', '1');
INSERT INTO `skynet_cd`.`report` (`report_address`, `report_date`, `report_apartment_quantity`, `report_box_position`, `report_point_energy`, `id_task`) VALUES ('Заречная 12', '2020-04-08 09:29:43', '225', 'чердак подвал', 'грщ, этажный рщ', '2');
INSERT INTO `skynet_cd`.`report` (`report_address`, `report_date`, `report_apartment_quantity`, `report_box_position`, `report_point_energy`, `id_task`) VALUES ('Пискаревский просп. 71', '2020-04-09 09:29:43', '74', 'чердак', 'этажный рщ', '3');

INSERT INTO `skynet_cd`.`material` (`material_name`, `material_issued`, `material_received`, `id_task`) VALUES ('кабель ОСВ4', '350', '350', '1');
INSERT INTO `skynet_cd`.`material` (`material_name`, `material_issued`, `material_received`, `id_task`) VALUES ('ящик средний', '6', '6', '1');
INSERT INTO `skynet_cd`.`material` (`material_name`, `material_issued`, `material_received`, `id_task`) VALUES ('зажим НСО под ОСВ', '4', '4', '1');
INSERT INTO `skynet_cd`.`material` (`material_name`, `material_issued`, `material_received`, `id_task`) VALUES ('ввг 3х1.5', '50', '50', '2');
INSERT INTO `skynet_cd`.`material` (`material_name`, `material_issued`, `material_received`, `id_task`) VALUES ('ввг 3х1.5', '100', '100', '3');
INSERT INTO `skynet_cd`.`material` (`material_name`, `material_issued`, `material_received`, `id_task`) VALUES ('ящик средний', '2', '2', '2');
INSERT INTO `skynet_cd`.`material` (`material_name`, `material_issued`, `material_received`, `id_task`) VALUES ('ящик средний', '1', '1', '3');
INSERT INTO `skynet_cd`.`material` (`material_name`, `material_issued`, `material_received`, `id_task`) VALUES ('гофра 20мм', '100', '100', '2');
