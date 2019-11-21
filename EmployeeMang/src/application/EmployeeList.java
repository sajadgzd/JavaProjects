package application;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employees")
@XmlAccessorType (XmlAccessType.FIELD)
public class EmployeeList {

    @XmlElement(name = "employee")
    private List<Employee> lst = new ArrayList<>();

    public List<Employee> getLst() {
        return lst;
    }

    public void createNew() {
        lst.add(new Employee());
    }

    public void setLst(List<Employee> lst) {
        this.lst = lst;
    }
}
