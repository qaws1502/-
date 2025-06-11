-- 기존 USER250522 테이블이 있다면 삭제 (데이터가 삭제되니 주의!)
DROP TABLE IF EXISTS USER250522;

-- USER250522 테이블 생성 (생년월일, 전화번호 필드 추가)
CREATE TABLE USER250522 (
    id VARCHAR(50) NOT NULL PRIMARY KEY,   -- 사용자 ID (고유해야 함)
    pw VARCHAR(255) NOT NULL,              -- 비밀번호 (보안을 위해 더 긴 길이 권장)
    name VARCHAR(100) NOT NULL,            -- 사용자 이름
    birth VARCHAR(20),                     -- 생년월일 필드 추가
    tel VARCHAR(20)                        -- 전화번호 필드 추가
);

-- 관리자 계정 (admin/1234로 로그인, 생년월일과 전화번호는 임의로 추가)
INSERT INTO USER250522 (id, pw, name, birth, tel)
VALUES ('admin', '1234', '관리자', '19800101', '01011112222');

-- 일반 사용자 계정 (user/1234로 로그인, 생년월일과 전화번호는 임의로 추가)
INSERT INTO USER250522 (id, pw, name, birth, tel)
VALUES ('user', '1234', '사용자', '19950715', '01012345678');

SELECT * FROM user250522;