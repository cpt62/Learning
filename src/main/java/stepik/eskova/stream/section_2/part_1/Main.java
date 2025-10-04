package stepik.eskova.stream.section_2.part_1;

import java.util.*;

class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        List<Student> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String s;
        while (!((s = scanner.nextLine()).equals("end"))) {
            String[] arr = s.split(";");
            list.add(new Student(arr[0], Integer.parseInt(arr[1]), Double.parseDouble(arr[2])));
        }
        OptionalDouble avgAge = list.stream().mapToInt(Student::getAge).average();
        double age = avgAge.orElse(20);
        OptionalDouble maxAvgGrade = list.stream().mapToDouble(Student::getAverageGrade).max();
        double grade = maxAvgGrade.orElse(0.0);
        System.out.printf("%d %.1f\n", (int) Math.round(age), grade);
        Student studentResult = list.stream().max(Comparator.comparing(student -> student.getName().length())).orElse(null);
        System.out.println(studentResult != null ? studentResult : "Empty data");
    }
}

class Student {
    private String name;
    private int age;
    private double averageGrade;

    public Student(String name, int age, double averageGrade) {
        this.name = name;
        this.age = age;
        this.averageGrade = averageGrade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    @Override
    public String toString() {
        return name + ";" + age + ";" + averageGrade;
    }
}