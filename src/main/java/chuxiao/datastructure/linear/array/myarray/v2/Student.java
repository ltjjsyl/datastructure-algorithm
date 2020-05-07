package chuxiao.datastructure.linear.array.myarray.v2;

public class Student {

    private String name;
    private String score;

    public Student(String name, String score) {
        this.name = name;
        this.score = score;
    }

    public static void main(String[] args) {

        Array<Student> array = new Array<>();
        array.addLast(new Student("xiaoming", "88"));
        array.addLast(new Student("xiaohong", "68"));
        array.addLast(new Student("hanmeimei", "85"));

        System.out.println(array);
    }

    @Override
    public String toString() {
        return String.format("student(name:%s, score:%s)", name, score);
    }
}
