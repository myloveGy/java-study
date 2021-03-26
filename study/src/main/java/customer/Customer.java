package customer;

public class Customer {
    // 名称
    private String name;

    /**
     * 年龄
     */
    private int age;

    /**
     * 性别
     */
    private String gender;

    // 邮箱
    private String email;

    /**
     * 手机号
     */
    private String phone;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Customer() {

    }   
}