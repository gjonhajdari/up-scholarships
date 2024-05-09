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

insert into scholarships.voucher(title, amount, deadline)
values
("Scholarship 1", 1000.00, "2024-04-30"),
("Scholarship 2", 2000.00, "2024-02-21");

insert into scholarships.application(student_id, voucher_id, application_date)
values 
("210756100052", 1, "2024-04-20"),
("220756100031", 1, "2024-04-22"),
("220756100004", 2, "2024-01-22");

insert into scholarships.awardees(student_id, voucher_id, award_date)
values
("210756100052", 1, "2024-04-30"),
("220756100031", 1, "2024-05-02"),
("220756100004", 2, "2024-02-02");

insert into scholarships.admin(username, salt, password)
values ("admin", "RaNRgxXvgtymZ6TPTPKF871q5dDHz04s4Hj4Rw58tIg=", "52614e52677858766774796d5a36545054504b4638373171356444487a30347334486a34527735387449673dc6f5894fa231d762bd4426c3fdbe59620593a003e4338b0d982b7c4a0f28298f");