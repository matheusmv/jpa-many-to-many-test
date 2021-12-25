INSERT INTO `course` (`name`) VALUES ('course 1');
INSERT INTO `course` (`name`) VALUES ('course 2');
INSERT INTO `course` (`name`) VALUES ('course 3');

INSERT INTO `student` (`name`) VALUES ('student 1');
INSERT INTO `student` (`name`) VALUES ('student 2');
INSERT INTO `student` (`name`) VALUES ('student 3');
INSERT INTO `student` (`name`) VALUES ('student 4');
INSERT INTO `student` (`name`) VALUES ('student 5');

INSERT INTO `course_registration` (`course_id`, `student_id`) VALUES (1, 2);
INSERT INTO `course_registration` (`course_id`, `student_id`) VALUES (1, 3);
INSERT INTO `course_registration` (`course_id`, `student_id`) VALUES (1, 5);

INSERT INTO `course_registration` (`course_id`, `student_id`) VALUES (2, 1);
INSERT INTO `course_registration` (`course_id`, `student_id`) VALUES (2, 2);
INSERT INTO `course_registration` (`course_id`, `student_id`) VALUES (2, 3);
INSERT INTO `course_registration` (`course_id`, `student_id`) VALUES (2, 4);

INSERT INTO `course_registration` (`course_id`, `student_id`) VALUES (3, 4);
INSERT INTO `course_registration` (`course_id`, `student_id`) VALUES (3, 5);
