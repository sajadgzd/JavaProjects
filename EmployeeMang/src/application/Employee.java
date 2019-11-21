package application;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employee")
@XmlAccessorType (XmlAccessType.FIELD)
public class Employee {
    //static
    private static long idCounter = 0l;

    private final long id;
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

    public boolean isValid() {
        return true;
        // return isNameValid() && isDepartmentValid() && isExtensionValid();
    }

    public boolean isNameValid() {
        return false;
    }

    public boolean isDepartmentValid() {
        return false;
    }
    
    public boolean isExtensionValid() {
        return false;
    }

    /**
     * @return the id
     */
    public long getId() {
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