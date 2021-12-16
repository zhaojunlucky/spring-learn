INSERT INTO users (id, username, password, enabled) VALUES (1, 'admin', '$2a$10$0JNkccj4MmYf5Xu37w.3v.kprqMBUOC6HAoth75xX5fz/wKwEh6qq', true);
INSERT INTO users (id, username, password, enabled) VALUES (2, 'magicworldz', '$2a$10$0JNkccj4MmYf5Xu37w.3v.kprqMBUOC6HAoth75xX5fz/wKwEh6qq', true);


INSERT INTO authorities (id, authority) VALUES(1, 'ROLE_ADMIN');
INSERT INTO authorities (id, authority) VALUES(2, 'ROLE_USER');
INSERT INTO authorities (id, authority) VALUES(3, 'ROLE_MEMBER');

INSERT INTO groups (id, group_name) VALUES(1, 'Admin Group');
INSERT INTO groups (id, group_name) VALUES(2, 'User Group');
INSERT INTO group_authorities(group_id, authority_id) VALUES(1, 1);
INSERT INTO group_authorities(group_id, authority_id) VALUES(1, 2);
INSERT INTO group_authorities(group_id, authority_id) VALUES(2, 2);

INSERT INTO group_members (user_id, group_id) VALUES (1, 1);
INSERT INTO group_members (user_id, group_id) VALUES (2, 2);

INSERT INTO user_authorities(user_id, authority_id) VALUES (2, 3);
