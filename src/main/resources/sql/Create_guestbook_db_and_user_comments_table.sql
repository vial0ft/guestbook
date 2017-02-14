CREATE DATABASE guestbook;

CREATE TABLE public.user_comments
(
  id_comment serial NOT NULL, 
  username varchar(50) NOT NULL,
  comment text NOT NULL,
  creation_date time without time zone,
  PRIMARY KEY (id_comment)
)