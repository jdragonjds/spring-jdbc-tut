CREATE TYPE gender AS ENUM ('MALE','FEMALE');

CREATE TABLE IF NOT EXISTS student (
    student_id UUID PRIMARY KEY NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    gender gender NOT NULL
);

CREATE TABLE IF NOT EXISTS course (
    course_id UUID PRIMARY KEY NOT NULL,
    course_name VARCHAR(300) NOT NULL,
    description TEXT NOT NULL,
    department VARCHAR(100) NOT NULL,
    instructor VARCHAR(6) NOT NULL,
    UNIQUE (course_name)
);

CREATE TABLE IF NOT EXISTS student_course (
    student_id UUID NOT NULL REFERENCES student (student_id),
    course_id UUID NOT NULL REFERENCES course (course_id),
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    grade INTEGER CHECK( grade >= 0 AND grade<=100 ),
    UNIQUE ( course_id , student_id )
);
