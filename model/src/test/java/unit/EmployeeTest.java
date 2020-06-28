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
        assertNull(emptyEmployee.getFullName());
        assertEquals(emptyEmployee.getSalary(),0L);
        assertEquals(emptyEmployee.getDivisionId(),0);
    }

    @Test
    public void allArgConstructorTest(){
        assertEquals(filledEmployee.getFullName(),"Ivan Belov");
        assertEquals(filledEmployee.getSalary(),300L);
        assertEquals(filledEmployee.getDivisionId(),11);
    }

    @Test
    public void idTest(){
        emptyEmployee.setId(100);
        assertEquals(emptyEmployee.getId(),100);
    }

    @Test
    public void nameTest(){
        emptyEmployee.setFullName("Test Test");
        assertEquals(emptyEmployee.getFullName(),"Test Test");
    }

    @Test
    public void salaryTest(){
        emptyEmployee.setSalary(400L);
        assertEquals(emptyEmployee.getSalary(), 400L);
    }

    @Test
    public void divisionIdTest(){
        emptyEmployee.setDivisionId(12);
        assertEquals(emptyEmployee.getDivisionId(), 12);
    }

}
