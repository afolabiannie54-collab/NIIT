-- Create databases for the banking app (run as a Postgres superuser)
CREATE DATABASE banking_api_dev;
CREATE DATABASE banking_api_prod;
CREATE DATABASE banking_api_qa;
CREATE DATABASE banking_api_test;

-- Example: run from PowerShell (psql must be on PATH):
-- psql -U postgres -W -f sql/create-postgres-dbs.sql
