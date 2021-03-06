package model.employee;

public class Employee {
    private int idEmployee;
    private String nameEmployee;
    private String dayOfBirth;
    private String idCard;
    private double salary;
    private String numberPhone;
    private String email;
    private String address;
    private int positionId;
    private int divisionId;
    private int educationDegreeId;
    private String userName;

    public Employee() {
    }

    public Employee(int idEmployee, String nameEmployee, String dayOfBirth, String idCard, double salary,
                    String numberPhone, String email, String address, int positionId, int divisionId, int educationDegreeId) {
        this.idEmployee = idEmployee;
        this.nameEmployee = nameEmployee;
        this.dayOfBirth = dayOfBirth;
        this.idCard = idCard;
        this.salary = salary;
        this.numberPhone = numberPhone;
        this.email = email;
        this.address = address;
        this.positionId = positionId;
        this.divisionId = divisionId;
        this.educationDegreeId = educationDegreeId;
    }

    public Employee(int idEmployee, String nameEmployee, String dayOfBirth, String idCard,
                    double salary, String numberPhone, String email, String address,
                    int positionId, int divisionId, int educationDegreeId, String userName) {
        this.idEmployee = idEmployee;
        this.nameEmployee = nameEmployee;
        this.dayOfBirth = dayOfBirth;
        this.idCard = idCard;
        this.salary = salary;
        this.numberPhone = numberPhone;
        this.email = email;
        this.address = address;
        this.positionId = positionId;
        this.divisionId = divisionId;
        this.educationDegreeId = educationDegreeId;
        this.userName = userName;
    }

    public Employee(String nameEmployee, String dayOfBirth, String idCard, double salary, String numberPhone, String email,
                    String address, int positionId, int divisionId, int educationDegreeId) {
        this.nameEmployee = nameEmployee;
        this.dayOfBirth = dayOfBirth;
        this.idCard = idCard;
        this.salary = salary;
        this.numberPhone = numberPhone;
        this.email = email;
        this.address = address;
        this.positionId = positionId;
        this.divisionId = divisionId;
        this.educationDegreeId = educationDegreeId;}

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setId_card(String idCard) {
        this.idCard = idCard;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public int getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    public int getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(int educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
