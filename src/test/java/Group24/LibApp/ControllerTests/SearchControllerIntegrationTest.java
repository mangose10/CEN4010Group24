package Group24.LibApp.ControllerTests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import Group24.LibApp.Models.Book;
import Group24.LibApp.Repositories.BookRepository;
import Group24.LibApp.Services.SearchService;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(SpringRunner.class)
@SpringBootTest(
  webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestPropertySource(
  locations = "classpath:application-integrationtest.properties")
public class SearchControllerIntegrationTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private SearchService service;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void givenEmployees_whenGetEmployees_thenStatus200()
    throws Exception {

        Book alex = new Book();

        List<Book> allBooks = Arrays.asList(alex);

        given(service.()).willReturn(allBooks);

        mvc.perform(get("/api/employees")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(1)))
        .andExpect(jsonPath("$[0].name", is(alex.getName())));
    }
}
