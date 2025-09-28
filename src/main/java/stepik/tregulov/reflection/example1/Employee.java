package stepik.tregulov.reflection.example1;

public class Employee {
    public int id;
    public String name;
    private double salary = 1000;
    private String department;


    public Employee() {
    }

    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

//    public Employee(int id, String name, double salary, String department) {
//        this.id = id;
//        this.name = name;
//        this.salary = salary;
//        this.department = department;
//    }

//    public double getSalary() {
//        return salary;
//    }
//
//    public void setSalary(double salary) {
//        this.salary = salary;
//    }

    private void changeDepartment(String newDepartment) {
        department = newDepartment;
        System.out.println("New department is: " + department);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }
}
