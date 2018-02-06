/* ROLES */

INSERT INTO app_role (id, role_name, description) VALUES (1, 0, 'USER')
ON CONFLICT (id) DO NOTHING;

INSERT INTO app_role (id, role_name, description) VALUES (2, 1, 'MODERATOR')
ON CONFLICT (id) DO NOTHING;

INSERT INTO app_role (id, role_name, description) VALUES (3, 2, 'ADMIN')
ON CONFLICT (id) DO NOTHING;


/* ADMIN */

insert into app_user (login, password) values ('admin','21232f297a57a5a743894a0e4a801fc3')
ON CONFLICT (login) DO NOTHING;
insert into user_role values (1,3)
ON CONFLICT (user_id, role_id) DO NOTHING;

insert into app_route(route_name, user_id, route_ischecked) values ('ROUTE1',1,'t');
insert into app_route(route_name, user_id, route_ischecked) values ('ROUTE2',1,'t');
insert into app_route(route_name, user_id, route_ischecked) values ('ROUTE3',1, 't');
insert into app_route(route_name, user_id, route_ischecked) values ('ROUTE4',1, 't');
insert into app_route(route_name, user_id, route_ischecked) values ('ROUTE5',1, 't');
insert into app_route(route_name, user_id, route_ischecked) values ('ROUTE6',1, 't');
insert into app_route(route_name, user_id, route_ischecked) values ('ROUTE7',1, 't');
insert into app_route(route_name, user_id, route_ischecked) values ('ROUTE8',1, 't');
insert into app_route(route_name, user_id, route_ischecked) values ('ROUTE9',1, 't');
insert into app_route(route_name, user_id, route_ischecked) values ('ROUTE10',1, 'f');
insert into app_route(route_name, user_id, route_ischecked) values ('ROUTE11',1, 't');
insert into app_route(route_name, user_id, route_ischecked) values ('ROUTE12',1, 't');
insert into app_route(route_name, user_id, route_ischecked) values ('ROUTE13',1, 't');