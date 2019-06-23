package MysqlTest;

public class Student {
    private String name, sex;
    private int age, score, num;

    public Student() {

    }

    public Student(int Id, String name, int score, String sex, int age) {
        this.num = Id;
        this.age = age;
        this.name = name;
        this.score = score;
        this.sex = sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return this.sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return this.score;
    }

    public void setId(int num) {
        this.num = num;
    }

    public int getId() {
        return this.num;
    }

    public String toString() {
        return this.num + " " + this.name + " " + this.score + " " + this.sex + " " + this.age;
    }
}
