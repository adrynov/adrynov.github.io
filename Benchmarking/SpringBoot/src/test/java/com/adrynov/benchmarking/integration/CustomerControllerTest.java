package com.adrynov.benchmarking.integration;

import com.adrynov.benchmarking.Application;
import com.adrynov.benchmarking.data.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest(CustomerController.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = Application.class
)
@AutoConfigureMockMvc
//@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CustomerRepository customerRepository;

//    @MockBean
//    private CustomerService customerService;

    private static ObjectMapper mapper = new ObjectMapper();

    //@Test
    //    public void testGetExample() throws Exception {
    //        mockMvc.perform(get("/getMapping")).
    //        andExpect(status().isOk())
    //        .andExpect(jsonPath("$", Matchers.hasSize(1)))
    //                .andExpect(jsonPath("$[0].name", Matchers.equalTo("Arun")));
//        mvc.perform(get("/api/employees")
//      .contentType(MediaType.APPLICATION_JSON))
//            .andExpect(status().isOk())
//            .andExpect(content()
//      .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//            .andExpect(jsonPath("$[0].name", is("bob")));
    //    }

    @Test
    public void testGettingCustomers() throws Exception {
        MediaType plainText = new MediaType(MediaType.TEXT_PLAIN, StandardCharsets.UTF_8);
        String customer = "{\"firstName\": \"Andrei\", \"email\" : \"adrynov@gmail.com\"}";

        var customers = customerRepository.findAll();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/customers"))
                .andExpect(status().isOk());

//        var request = MockMvcRequestBuilders.post("/api/customers")
//                .content(customer)
//                .contentType(MediaType.APPLICATION_JSON);
//
//        mockMvc.perform(request)
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType(plainText));

    }


//    @MockBean
//    private CustomerRepository userRepository;

//    @Autowired
//    CustomerController userController;
//

//    @Test
//     void letsAddOneCustomer()  {

//
//    }

//    @Test
//    public void whenPostRequestToUsersAndValidUser_thenCorrectResponse() throws Exception {
//        MediaType textPlainUtf8 = new MediaType(MediaType.TEXT_PLAIN, Charset.forName("UTF-8"));
//        String user =
//        mockMvc.perform(MockMvcRequestBuilders.post("/users")
//                        .content(user)
//
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content()
//                        .contentType(textPlainUtf8));
//    }
//
//    @Test
//    public void whenPostRequestToUsersAndInValidUser_thenCorrectResponse() throws Exception {
//        String user = "{\"name\": \"\", \"email\" : \"bob@domain.com\"}";
//        mockMvc.perform(MockMvcRequestBuilders.post("/users")
//                        .content(user)
//                        .contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(MockMvcResultMatchers.status().isBadRequest())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Is.is("Name is mandatory")))
//                .andExpect(MockMvcResultMatchers.content()
//                        .contentType(MediaType.APPLICATION_JSON_UTF8));
//    }
//}


    //    @Test
    //    public void testPostExample() throws Exception {
    //        Student student = new Student();
    //        student.setId(1);
    //        student.setName("Arun");
    //        Mockito.when(studentService.saveStudent(ArgumentMatchers.any())).thenReturn(student);
    //        String json = mapper.writeValueAsString(student);
    //        mockMvc.perform(post("/postMapping").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
    //                .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
    //                .andExpect(jsonPath("$.id", Matchers.equalTo(1)))
    //                .andExpect(jsonPath("$.name", Matchers.equalTo("Arun")));
    //    }
    //    @Test
    //    public void testPutExample() throws Exception {
    //        Student student = new Student();
    //        student.setId(2);
    //        student.setName("John");
    //        Mockito.when(studentService.updateStudent(ArgumentMatchers.any())).thenReturn(student);
    //        String json = mapper.writeValueAsString(student);
    //        mockMvc.perform(put("/putMapping").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
    //                .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
    //                .andExpect(jsonPath("$.id", Matchers.equalTo(2)))
    //                .andExpect(jsonPath("$.name", Matchers.equalTo("John")));
    //    }
    //    @Test
    //    public void testDeleteExample() throws Exception {
    //        Mockito.when(studentService.deleteStudent(ArgumentMatchers.anyString())).thenReturn("Student is deleted");
    //        MvcResult requestResult = mockMvc.perform(delete("/deleteMapping").param("student-id", "1"))
    //                .andExpect(status().isOk()).andExpect(status().isOk()).andReturn();
    //        String result = requestResult.getResponse().getContentAsString();
    //        assertEquals(result, "Student is deleted");
    //    }

}
