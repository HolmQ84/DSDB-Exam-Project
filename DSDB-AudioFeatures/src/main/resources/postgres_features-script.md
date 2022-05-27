GRANT ALL PRIVILEGES ON features.* TO 'test1234'@'localhost';

CREATE SCHEMA IF NOT EXISTS features;

USE features;

CREATE TABLE features (
audio_id			INT		NOT NULL		PRIMARY KEY,
danceability		VARCHAR(20),
energy				VARCHAR(20),
on_key				VARCHAR(20),
loudness			VARCHAR(20),
speechiness			VARCHAR(20),
acousticness		VARCHAR(20),
instrumentalness	VARCHAR(20),
liveness			VARCHAR(20),
valence				VARCHAR(20),
tempo				VARCHAR(20),
duration_ms			VARCHAR(20)
);
