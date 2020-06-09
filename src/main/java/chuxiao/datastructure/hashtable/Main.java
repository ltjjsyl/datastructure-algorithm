package chuxiao.datastructure.hashtable;

import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        int a = 42;
        System.out.println(((Integer) a).hashCode());

        int b = -42;
        System.out.println(((Integer) b).hashCode());

        double c = 3.1415926;
        System.out.println(((Double) c).hashCode());

        String d = "imooc";
        System.out.println(d.hashCode());

        Student e = new Student(3, 2, "bobo", "liu");
        System.out.println(e.hashCode());

        Student f = new Student(3, 2, "BOBO", "liu");
        System.out.println(f.hashCode());

        HashSet<Student> set = new HashSet<>();
        set.add(e);

        HashMap<Student, Integer> scores = new HashMap<>();
        scores.put(e, 100);
    }

    static class Student {
        int grade;
        int cls;
        String firstName;
        String lashName;

        public Student(int grade, int cls, String firstName, String lashName) {
            this.grade = grade;
            this.cls = cls;
            this.firstName = firstName;
            this.lashName = lashName;
        }

        @Override
        public int hashCode() {
            int B = 31;
            int hash = 0;
            hash = hash * B + grade;
            hash = hash * B + cls;
            hash = hash * B + firstName.toLowerCase().hashCode();
            hash = hash * B + lashName.toLowerCase().hashCode();
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }

            if (getClass() != obj.getClass()) {
                return false;
            }

            Student another = (Student) obj;
            return (this.grade == another.grade) &&
                    (this.cls == another.cls) &&
                    (this.firstName).equals(another.firstName) &&
                    (this.lashName).equals(another.lashName);

        }
    }
}
