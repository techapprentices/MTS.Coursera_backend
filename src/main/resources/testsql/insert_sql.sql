INSERT INTO role (id, title)
VALUES (gen_random_uuid(), 'ROLE_ADMIN'),
       (gen_random_uuid(), 'ROLE_AUTHOR'),
       (gen_random_uuid(), 'ROLE_READER');

INSERT INTO "user"
(id, username, password) VALUES
(gen_random_uuid(), 'admin', '$2a$12$SvpxATE.JJribtc6VVQALulxpT5GdFzeWUT2d7EWyc9t3J6oGdeRC'),
(gen_random_uuid(), 'Eugene', '$2a$12$Co9gypGfbJLQwikdcMdTy.g5TBrAQqjrI3z6X8osScHhZFaDhasSi'),
(gen_random_uuid(), 'Alexander', '$2a$12$LyybAX7EpjuS6QW3SrKpGO8GJK7.YsR9Mug/.cq2IaMvCdmtGobv2');

