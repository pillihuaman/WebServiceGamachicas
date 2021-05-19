SET GLOBAL time_zone = '+8:00';
use gamachicas;
select * from gamachicas.users;
SET GLOBAL time_zone = '+8:00';
INSERT INTO `gamachicas`.`users`
(
`idRol`,
`idSystem`,
`alias`,
`user`,
`username`,
`mobilPhone`,
`mail`,
`password`,
`apiPassword`,
`salPassword`,
`createdate`,
`updatedate`,
`status`)
VALUES
(
1 ,
1 ,
'pillihuaman' ,
'zarmir pillihuaman' ,
'zarmir',
'933418411' ,
'pillihuamanhz@gmail.com' ,
'$2a$10$jQJvWWwqzNg9SVaZi3aKR.Iltjl3sObn2FAuzAhVxnQm0t7VPHm7i' ,
null ,
null ,
sysdate(),
sysdate() ,
1 );
