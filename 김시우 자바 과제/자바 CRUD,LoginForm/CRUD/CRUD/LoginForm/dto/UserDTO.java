package dto;

public class UserDTO {
    private String id;
    private String pw;
    private String name;
    private String birth; // 추가
    private String tel;   // 추가

    // 기존 생성자 유지 (하위 호환성)
    public UserDTO(String id, String pw, String name) {
        super();
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.birth = ""; // 기본값
        this.tel = "";   // 기본값
    }

    // 새로운 생성자 (birth, tel 포함)
    public UserDTO(String id, String pw, String name, String birth, String tel) {
        super();
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.birth = birth;
        this.tel = tel;
    }

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    public String getName() {
        return name;
    }

    // 새롭게 추가된 getter들
    public String getBirth() {
        return birth;
    }

    public String getTel() {
        return tel;
    }

    // (선택 사항) 필요한 경우 setter도 추가할 수 있습니다.
    public void setBirth(String birth) {
        this.birth = birth;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}