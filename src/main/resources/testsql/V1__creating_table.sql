CREATE TABLE "user"(
    "id" UUID PRIMARY KEY DEFAULT gen_random_uuid (),
    "username" TEXT NOT NULL unique
);

CREATE TABLE "course"(
    "id" UUID PRIMARY KEY DEFAULT gen_random_uuid (),
    "title" TEXT NOT NULL unique
);

INSERT INTO "user"
--------------------------------------------
("username") VALUES
--------------------------------------------
('admin'),
('Eugene'),
('Alexander');
/*SELECT setval('user_id_seq', 3);*/

INSERT INTO "course"
--------------------------------------------
("title") VALUES
--------------------------------------------
('Mathem'),
('English'),
('Spanish');
/*SELECT setval('user_id_seq', 3);*/