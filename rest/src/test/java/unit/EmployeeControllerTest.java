package unit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ian.model.Employee;
import com.ian.rest.EmployeeController;
import com.ian.service.EmployeeService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = EmployeeController.class)
@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {

    @MockBean
    EmployeeService service;

    @Autowired
    EmployeeController controller;

    static MockMvc mvc;
    static List<Employee> employees = new ArrayList<>();

    @BeforeAll
    static void beforeAll() {
        employees.add(new Employee(1, "Test1", 112, 15));
        employees.add(new Employee(2, "Test2", 114, 15));
        employees.add(new Employee(3, "Test3", 116, 16));
    }

    @BeforeEach
    public void beforeEach() {
        mvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void getAllPersonsTest() throws Exception {
        when(service.getAllEmployees()).thenReturn(employees);
        mvc.perform(get("/api/persons"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].fullName", is("Test1")))
                .andExpect(jsonPath("$[1].fullName", is("Test2")))
                .andExpect(jsonPath("$[2].fullName", is("Test3")));
    }

    @Test
    public void getPersonTest() throws Exception {
        Long id = 1L;
        when(service.getEmployeeById(id)).thenReturn(employees.get(0));
        mvc.perform(get("/api/persons/".concat(id.toString())))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fullName", is("Test1")))
                .andExpect(jsonPath("$.salary", is(112)))
                .andExpect(jsonPath("$.divisionId", is(15)));
    }

    @Test
    public void getAverageSalaryByDivisionTest() throws Exception {
        int divisionId = 15;
        when(service.getAverageSalaryByDivision(divisionId)).thenReturn(113L);
        mvc.perform(get("/api/averageSalary/".concat(String.valueOf(divisionId))))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(113)));
    }

    @Test
    public void deletePersonTest() throws Exception {
        when(service.getAllEmployees()).thenReturn(employees.subList(0, 2));
        mvc.perform(delete("/api/persons/".concat(String.valueOf(3L))))
                .andDo(print())
                .andExpect(status().isOk());
        mvc.perform(get("/api/persons"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void savePersonTest() throws Exception {
        MediaType JSON_UTF8 = new MediaType("application", "json", StandardCharsets.UTF_8);
        employees.add(new Employee(4L, "Test4", 122, 12));
        when(service.getAllEmployees()).thenReturn(employees);
        mvc.perform(post("/api/persons")
                .accept(JSON_UTF8)
                .contentType(JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(employees.get(3))))
                .andDo(print())
                .andExpect(status().isOk());
        mvc.perform(get("/api/persons"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(4)));
    }
}