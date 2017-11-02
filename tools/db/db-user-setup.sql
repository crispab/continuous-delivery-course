CREATE DATABASE cd_course_dev;
CREATE DATABASE cd_course_test;

GRANT ALL PRIVILEGES ON cd_course_dev.* to 'app'@'%' IDENTIFIED BY 'app';
GRANT ALL PRIVILEGES ON cd_course_test.* to 'app'@'%' IDENTIFIED BY 'app';
FLUSH PRIVILEGES;
