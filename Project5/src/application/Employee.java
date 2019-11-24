package application;


public class Employee {
    //static
    private static int idCounter = 0;

    private final int id;
    private String name;
    private String department;
    private String extension;

    public Employee() {
        this("", "", "");
    }

    public Employee(String name, String department, String extension) {
        this.id = ++idCounter;
        this.name = name;
        this.department = department;
        this.extension = extension;
    }

    public Employee(int id, String name, String department, String extension) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.extension = extension;
    }

    public boolean isValid() {
        return isNameValid() && isDepartmentValid() && isExtensionValid();
    }

    // Valid names consist of one or two words.
    // Each word must start with an uppercase letter followed by at least two characters. Numbers are not allowed.
    public boolean isNameValid() {
        return this.name.matches("([A-Z][a-zA-Z]{2,})|([A-Z][a-zA-Z]{2,}\\s[A-Z][a-zA-Z]{2,})");
    }

    // Valid department names consist of one or two words.
    // Each word must start with an uppercase letter. A word can be a single uppercase letter. Numbers are allowed
    public boolean isDepartmentValid() {
        return this.department.matches("([A-Z][a-zA-Z0-9]*)|([A-Z][a-zA-Z0-9]*\\s[A-Z][a-zA-Z0-9]*)");
    }

    // Valid extensions start with 1, 2, or 3 numbers followed by a dash " 􏰃 " followed by 1 or 2 numbers
    public boolean isExtensionValid() {
        return this.extension.matches("[0-9]{1,3}-[0-9]{1,2}");
    }

    public int getId() {
        return id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getDepartment() {

        return department;
    }

    public void setDepartment(String department) {

        this.department = department;
    }

    public String getExtension() {

        return extension;
    }

    public void setExtension(String extension) {

        this.extension = extension;
    }

    @Override
    public String toString() {
        return String.format("Employee >> ID: %d, Name: %s, Department: %s, Extension: %s", id, name, department, extension);
    }
}