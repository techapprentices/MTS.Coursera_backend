TRUNCATE "user", "course";

CREATE TABLE "role"(
    "id" UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    "title" TEXT NOT NULL unique
);

CREATE TABLE users_roles
(
    "user_id" UUID REFERENCES "user" (id) ON UPDATE CASCADE ON DELETE CASCADE,
    "role_id" UUID REFERENCES "role" (id) ON UPDATE CASCADE,
    CONSTRAINT users_roles_pkey PRIMARY KEY (user_id, role_id)
);

INSERT INTO role (title)
VALUES ('ROLE_ADMIN'),
       ('ROLE_AUTHOR'),
       ('ROLE_READER');

ALTER TABLE "user" ADD COLUMN "password" TEXT NOT NULL default 1234;
ALTER TABLE "course" ADD COLUMN "content" text;
ALTER TABLE "course" ADD COLUMN "author" UUID REFERENCES "user" (id);

INSERT INTO "user"
--------------------------------------------
("username", "password") VALUES
--------------------------------------------
('admin', '$2a$12$SvpxATE.JJribtc6VVQALulxpT5GdFzeWUT2d7EWyc9t3J6oGdeRC'),
('Eugene', '$2a$12$Co9gypGfbJLQwikdcMdTy.g5TBrAQqjrI3z6X8osScHhZFaDhasSi'),
('Alexander', '$2a$12$LyybAX7EpjuS6QW3SrKpGO8GJK7.YsR9Mug/.cq2IaMvCdmtGobv2');
/*SELECT setval('user_id_seq', 3);*/