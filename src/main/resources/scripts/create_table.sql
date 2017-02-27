DROP TABLE IF EXISTS public.user_comments ;
CREATE TABLE public.user_comments
(
  id_comment serial not null, 
  username varchar(50),
  comment text NOT NULL,
  creation_date time without time zone,
  PRIMARY KEY (id_comment)
);

