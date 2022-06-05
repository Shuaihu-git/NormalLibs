public class Student implements Comparable<Student>{
    private String name;
    private int age;
    private double grade;
    public Student(String name,int age,double grade){
        this.age=age;
        this.name=name;
        this.grade=grade;
    }

    @Override
    public String toString() {
        return "姓名："+this.name+"、年龄："+this.age+"、成绩："+this.grade;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public int compareTo(Student student) {
        if (this.grade>student.grade){
            return 1;
        }
        else if (this.grade<student.grade){
            return -1;
        }else {
            return this.age- student.age;
        }
    }
}
