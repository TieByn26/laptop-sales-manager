package Model.Personn;

public class Employee extends Person{
    private int empId;
    private double salary;

    public Employee() {
    }

    public Employee(int empId,String name, String gender, String address, String phone, double salary) {
        super(name, gender, address, phone);
        this.empId = empId;
        this.salary = salary;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}
