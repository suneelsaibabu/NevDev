DROP SCHEMA IF EXISTS accounts_jsonb CASCADE;
DROP ROLE IF EXISTS owner_accounts_jsonb;

CREATE ROLE owner_accounts_jsonb WITH
NOLOGIN
NOSUPERUSER
INHERIT
NOCREATEDB
NOCREATEROLE
NOREPLICATION;

GRANT owner_accounts_jsonb TO postgres;


CREATE SCHEMA accounts_jsonb AUTHORIZATION owner_accounts_jsonb;

GRANT ALL ON SCHEMA accounts_jsonb TO owner_accounts_jsonb;

CREATE TABLE accounts_jsonb.account
(
  id          uuid,
  accountdata      jsonb  NOT NULL DEFAULT '{}',
  PRIMARY KEY (id));

ALTER TABLE accounts_jsonb.account OWNER to owner_accounts_jsonb;
DROP ROLE IF EXISTS owner_example_jsonb;