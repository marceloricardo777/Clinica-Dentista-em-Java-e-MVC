
CREATE USER marcelo WITH PASSWORD '1234';
grant all privileges on database clinica to marcelo;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO marcelo;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO marcelo;