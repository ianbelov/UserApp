package unit;

import com.ian.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


public class EmployeeTest {

    Employee emptyEmployee;
    Employee filledEmployee;

    @BeforeEach
    public void before(){
        emptyEmployee = new Employee();
        filledEmployee = new Employee("Ivan Belov",300L, 11);
    }

    @Test
    public void emptyConstructorTest(){
        assertEquals(emptyEmployee.getId(),0);
        assertNull(emptyEmployee.getFull_name());
        assertEquals(emptyEmployee.getSalary(),0L);
        assertEquals(emptyEmployee.getDivision_id(),0);
    }

    @Test
    public void allArgConstructorTest(){
        assertEquals(filledEmployee.getFull_name(),"Ivan Belov");
        assertEquals(filledEmployee.getSalary(),300L);
        assertEquals(filledEmployee.getDivision_id(),11);
    }

    @Test
    public void idTest(){
        emptyEmployee.setId(100);
        assertEquals(emptyEmployee.getId(),100);
    }

    @Test
    public void nameTest(){
        emptyEmployee.setFull_name("Test Test");
        assertEquals(emptyEmployee.getFull_name(),"Test Test");
    }

    @Test
    public void salaryTest(){
        emptyEmployee.setSalary(400L);
        assertEquals(emptyEmployee.getSalary(), 400L);
    }

    @Test
    public void divisionIdTest(){
        emptyEmployee.setDivision_id(12);
        assertEquals(emptyEmployee.getDivision_id(), 12);
    }

}
