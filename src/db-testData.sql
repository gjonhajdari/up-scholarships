-- --------------------
-- Test data insertion
-- --------------------

use scholarships;

insert into scholarships.student(student_id, first_name, last_name, email, salt, password)
values
("210756100052", "Gjon", "Hajdari", "gjon.hajdari@student.uni-pr.edu", "rSGGscpwXNz4ncOidA+kL+rQzMJWJlvQX9uuXEAfN2Y=", "7253474773637077584e7a346e634f6964412b6b4c2b72517a4d4a574a6c765158397575584541664e32593dac630711365a6543df6c074a164931f0ebe45a1b2b12d3c3199c6f13e1583b31"),
("220756100031", "Lorik", "Agaj", "lorik.agaj@student.uni-pr.edu", "F9I8sC/AO20giA3x5D//PwBVTMUguqInuOhnyxjpzHA=", "4639493873432f414f3230676941337835442f2f50774256544d55677571496e754f686e79786a707a48413d96a36c7a14674093f73d91a290216ed03d85385c249d0ba057deb242aac4d5aa"),
("220756100004", "Dion", "Gashi", "dion.gashi@student.uni-pr.edu", "7XfAI76chpfhW+upjHA3sGywgQc4trvXqnQL2dtOGGk=", "375866414937366368706668572b75706a484133734779776751633474727658716e514c3264744f47476b3d99964f81b61f431598175ecbc3dd8b1867e4a2f910c11afa032331e48f283eff"),
("220756100036", "Diell", "Doçi", "diell.doci@student.uni-pr.edu", "w9QfuYhboyuQwEHnIVH09HZjXMDzrOJllzZRkz167Rw=", "77395166755968626f7975517745486e4956483039485a6a584d447a724f4a6c6c7a5a526b7a31363752773d705223584c6994129e588033b13a1cbeff977f2769f35ba60b669d94a984c6ea"),
("220757100075", "Blerton", "Ismaili", "blerton.ismaili@student.uni-pr.edu", "/X8VPAnu3Z64VR7+vKyllirYdT8/tCXIkVwTGyXOORQ=", "2f58385650416e75335a36345652372b764b796c6c6972596454382f744358496b5677544779584f4f52513da18e804b01ddc6d3a2e2dc0735083632c03b99aee03bb1afe8d373cb5116fd1e"),
("220756100109", "Gent", "Podvorica", "gent.podvorica@student.uni-pr.edu", "w+5S+8jXsvNBSbHzfOfcfN4UAGbHDN+gYBLZ2qbzhYU=", "772b35532b386a5873764e425362487a664f6663664e345541476248444e2b6759424c5a3271627a6859553dd36d42d36028078067df9a7982c30cc17d28c9e980b7554e2bb2aa00ed3ef06b");

-- insert into scholarships.voucher(title, amount, category, description, deadline)
-- values
-- ("Scholarship 1", 800.00, "UNIVERSITY", "Scholarship description with criteria", "2024-08-30"),
-- ("Scholarship 2", 2000.00, "OTHER", "Scholarship description with criteria", "2024-07-21"),
-- ("Scholarship 3", 150.00, "OTHER", "Scholarship description with criteria", "2024-06-12"),
-- ("Scholarship 4", 500.00, "STEM", "Scholarship description with criteria", "2024-05-30"),
-- ("Scholarship 5", 1000.00, "UNIVERSITY", "Scholarship description with criteria", "2024-09-03");

-- insert into scholarships.application(student_id, voucher_id, application_date)
-- values 
-- ("210756100052", 5, "2024-04-20"),
-- ("220756100031", 1, "2024-04-22"),
-- ("220756100004", 2, "2024-01-22");


-- Data with random dates
CALL insert_voucher_random("STEM Excellence Scholarship", 800.00, "STEM", "Scholarship description with criteria");
CALL insert_voucher_random("Community Service Award", 2000.00, "OTHER", "Scholarship description with criteria");
CALL insert_voucher_random("Arts & Humanities Grant", 150.00, "ARTS", "Scholarship description with criteria");
CALL insert_voucher_random("Women in Tech Scholarship", 500.00, "STEM", "Scholarship description with criteria");
CALL insert_voucher_random("First Generation Student Grant", 1000.00, "UNIVERSITY", "Scholarship description with criteria");
CALL insert_voucher_random("Entrepreneurship Award", 1200.00, "STEM", "Scholarship description with criteria");
CALL insert_voucher_random("Environmental Studies Scholarship", 750.00, "UNIVERSITY", "Scholarship description with criteria");
CALL insert_voucher_random("Health & Medicine Grant", 2500.00, "OTHER", "Scholarship description with criteria");
CALL insert_voucher_random("Social Sciences Award", 350.00, "OTHER", "Scholarship description with criteria");
CALL insert_voucher_random("Engineering Excellence Scholarship", 600.00, "STEM", "Scholarship description with criteria");
CALL insert_voucher_random("Business & Finance Grant", 1100.00, "UNIVERSITY", "Scholarship description with criteria");
CALL insert_voucher_random("Athletic Achievement Award", 2200.00, "OTHER", "Scholarship description with criteria");
CALL insert_voucher_random("Performing Arts Scholarship", 450.00, "ARTS", "Scholarship description with criteria");
CALL insert_voucher_random("Computer Science Grant", 700.00, "STEM", "Scholarship description with criteria");
CALL insert_voucher_random("Leadership Excellence Award", 900.00, "UNIVERSITY", "Scholarship description with criteria");
CALL insert_voucher_random("Veteran's Grant", 2300.00, "OTHER", "Scholarship description with criteria");
CALL insert_voucher_random("Human Rights Scholarship", 550.00, "OTHER", "Scholarship description with criteria");
CALL insert_voucher_random("Mathematics Excellence Scholarship", 800.00, "STEM", "Scholarship description with criteria");
CALL insert_voucher_random("Journalism & Media Grant", 950.00, "UNIVERSITY", "Scholarship description with criteria");
CALL insert_voucher_random("Culinary Arts Scholarship", 2400.00, "ARTS", "Scholarship description with criteria");
CALL insert_voucher_random("Graphic Design Scholarship", 1000.00, "ARTS", "Scholarship description with criteria");
CALL insert_voucher_random("Music Excellence Award", 1200.00, "ARTS", "Scholarship description with criteria");
CALL insert_voucher_random("Literature & Languages Grant", 800.00, "ARTS", "Scholarship description with criteria");
CALL insert_voucher_random("Physics Excellence Scholarship", 1500.00, "STEM", "Scholarship description with criteria");
CALL insert_voucher_random("Chemistry Achievement Award", 2000.00, "STEM", "Scholarship description with criteria");
CALL insert_voucher_random("Biology Research Grant", 1800.00, "STEM", "Scholarship description with criteria");
CALL insert_voucher_random("History & Culture Scholarship", 900.00, "ARTS", "Scholarship description with criteria");
CALL insert_voucher_random("Philosophy Excellence Award", 1100.00, "ARTS", "Scholarship description with criteria");
CALL insert_voucher_random("Psychology Research Grant", 1300.00, "OTHER", "Scholarship description with criteria");
CALL insert_voucher_random("Sociology Achievement Scholarship", 1600.00, "OTHER", "Scholarship description with criteria");


CALL insert_application_random("210756100052", 1);
CALL insert_application_random("220756100031", 2);
CALL insert_application_random("220756100004", 3);
CALL insert_application_random("210756100052", 4);
CALL insert_application_random("220756100031", 5);
CALL insert_application_random("220756100004", 6);
CALL insert_application_random("210756100052", 7);
CALL insert_application_random("220756100031", 8);
CALL insert_application_random("220756100004", 9);
CALL insert_application_random("210756100052", 10);
CALL insert_application_random("220756100031", 11);
CALL insert_application_random("220756100004", 12);
CALL insert_application_random("210756100052", 13);
CALL insert_application_random("220756100031", 14);
CALL insert_application_random("220756100004", 15);
CALL insert_application_random("210756100052", 16);
CALL insert_application_random("220756100031", 17);
CALL insert_application_random("220756100004", 18);
CALL insert_application_random("210756100052", 19);
CALL insert_application_random("220756100031", 20);
CALL insert_application_random("220756100004", 21);
CALL insert_application_random("210756100052", 22);
CALL insert_application_random("220756100031", 23);
CALL insert_application_random("220756100004", 24);
CALL insert_application_random("210756100052", 25);
CALL insert_application_random("220756100031", 26);
CALL insert_application_random("220756100004", 27);
CALL insert_application_random("210756100052", 28);
CALL insert_application_random("220756100031", 29);
CALL insert_application_random("220756100004", 30);
CALL insert_application_random("210756100052", 1);
CALL insert_application_random("220756100031", 2);
CALL insert_application_random("220756100004", 3);
CALL insert_application_random("210756100052", 4);
CALL insert_application_random("220756100031", 5);
CALL insert_application_random("220756100004", 6);
CALL insert_application_random("210756100052", 7);
CALL insert_application_random("220756100031", 8);
CALL insert_application_random("220756100004", 9);
CALL insert_application_random("210756100052", 10);
CALL insert_application_random("220756100031", 11);
CALL insert_application_random("220756100004", 12);
CALL insert_application_random("210756100052", 13);
CALL insert_application_random("220756100031", 14);
CALL insert_application_random("220756100004", 15);
CALL insert_application_random("210756100052", 16);
CALL insert_application_random("220756100031", 17);
CALL insert_application_random("220756100004", 18);
CALL insert_application_random("210756100052", 19);
CALL insert_application_random("220756100031", 20);
-- CALL insert_application_random('220756100063', 1);
-- CALL insert_application_random('220756100075', 2);
-- CALL insert_application_random('220756100072', 3);
-- CALL insert_application_random('220756100084', 4);
-- CALL insert_application_random('220756100052', 5);
-- CALL insert_application_random('220756100058', 6);
-- CALL insert_application_random('220756100035', 7);
-- CALL insert_application_random('220756100026', 8);
-- CALL insert_application_random('220756100037', 9);
-- CALL insert_application_random('220756100092', 10);
-- CALL insert_application_random('220756100088', 11);
-- CALL insert_application_random('220756100067', 12);
-- CALL insert_application_random('220756100135', 13);
-- CALL insert_application_random('220756100056', 14);
-- CALL insert_application_random('220756100057', 15);
-- CALL insert_application_random('220756100025', 16);
-- CALL insert_application_random('220756100096', 17);
-- CALL insert_application_random('220756100051', 18);
-- CALL insert_application_random('220756100010', 19);
-- CALL insert_application_random('220756100079', 20);
-- CALL insert_application_random('220756100114', 21);
-- CALL insert_application_random('220756100130', 22);
-- CALL insert_application_random('220756100027', 23);
-- CALL insert_application_random('220756100022', 24);
-- CALL insert_application_random('220756100078', 25);
-- CALL insert_application_random('220756100039', 26);
-- CALL insert_application_random('220756100018', 27);
-- CALL insert_application_random('220756100117', 28);
-- CALL insert_application_random('220756100099', 29);
-- CALL insert_application_random('220756100016', 30);
-- CALL insert_application_random('220756100076', 1);
-- CALL insert_application_random('220757100068', 2);
-- CALL insert_application_random('220756100032', 3);
-- CALL insert_application_random('220757100075', 4);
-- CALL insert_application_random('220756100034', 5);
-- CALL insert_application_random('220756100021', 6);
-- CALL insert_application_random('220756100017', 7);
-- CALL insert_application_random('220756100060', 8);
-- CALL insert_application_random('220756100048', 9);
-- CALL insert_application_random('220756100113', 10);
-- CALL insert_application_random('220756100070', 11);
-- CALL insert_application_random('220756100069', 12);
-- CALL insert_application_random('220756100036', 13);
-- CALL insert_application_random('220756100004', 14);
-- CALL insert_application_random('220756100083', 15);
-- CALL insert_application_random('220718100036', 16);
-- CALL insert_application_random('220756100105', 17);
-- CALL insert_application_random('220756100043', 18);
-- CALL insert_application_random('220756100009', 19);
-- CALL insert_application_random('220756100087', 20);
-- CALL insert_application_random('220756100125', 21);
-- CALL insert_application_random('220756100002', 22);
-- CALL insert_application_random('220756100042', 23);
-- CALL insert_application_random('220756100134', 24);
-- CALL insert_application_random('220756100077', 25);
-- CALL insert_application_random('220756100045', 26);
-- CALL insert_application_random('220756100090', 27);
-- CALL insert_application_random('220756100029', 28);
-- CALL insert_application_random('220756100110', 29);
-- CALL insert_application_random('220758100003', 30);
-- CALL insert_application_random('220756100012', 1);
-- CALL insert_application_random('220756100131', 2);
-- CALL insert_application_random('220756100015', 3);
-- CALL insert_application_random('220757100055', 4);
-- CALL insert_application_random('220756100005', 5);
-- CALL insert_application_random('220756100108', 6);
-- CALL insert_application_random('220756100106', 7);
-- CALL insert_application_random('220756100061', 8);
-- CALL insert_application_random('210756100030', 9);
-- CALL insert_application_random('220756100062', 10);
-- CALL insert_application_random('220756100123', 11);
-- CALL insert_application_random('220756100014', 12);
-- CALL insert_application_random('220756100023', 13);
-- CALL insert_application_random('220756100081', 14);
-- CALL insert_application_random('220756100071', 15);
-- CALL insert_application_random('220756100001', 16);
-- CALL insert_application_random('220756100126', 17);
-- CALL insert_application_random('220756100085', 18);
-- CALL insert_application_random('220756100109', 19);
-- CALL insert_application_random('220756100119', 20);
-- CALL insert_application_random('220756100065', 21);
-- CALL insert_application_random('220756100007', 22);
-- CALL insert_application_random('220758100024', 23);
-- CALL insert_application_random('210756100052', 24);
-- CALL insert_application_random('220757100064', 25);
-- CALL insert_application_random('220756100086', 26);
-- CALL insert_application_random('220756100066', 27);
-- CALL insert_application_random('220756100055', 28);
-- CALL insert_application_random('220756100121', 29);
-- CALL insert_application_random('220756100128', 30);


insert into scholarships.admin(username, salt, password)
values ("admin", "RaNRgxXvgtymZ6TPTPKF871q5dDHz04s4Hj4Rw58tIg=", "52614e52677858766774796d5a36545054504b4638373171356444487a30347334486a34527735387449673dc6f5894fa231d762bd4426c3fdbe59620593a003e4338b0d982b7c4a0f28298f");