package model;

public class Member {
    String name;
    String birth;
    String tel;

    public Member(String name, String birth, String tel) {
        this.birth = birth;
        this.name = name;
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public String getBirth() {
        return birth;
    }

    public String getTel() {
        return tel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}