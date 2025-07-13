INSERT INTO employee_tb (name, description, email)
VALUES ('ssar', '백엔드 개발자', 'hong@example.com'),
       ('cos', '프론트엔드 개발자', 'lee@example.com');

INSERT INTO course_tb (title, description, capacity, created_at)
VALUES ('Spring Boot 입문', 'Spring Boot의 기본 개념과 실습', 30, CURRENT_TIMESTAMP),
       ('JPA 심화', 'JPA 실무 적용 및 성능 최적화', 20, CURRENT_TIMESTAMP);
