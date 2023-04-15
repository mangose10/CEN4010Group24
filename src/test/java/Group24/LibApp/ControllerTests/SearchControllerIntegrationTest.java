package Group24.LibApp.ControllerTests;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import Group24.LibApp.AbstractTest;
import Group24.LibApp.Models.Book;
import Group24.LibApp.Models.Genre;
import Group24.LibApp.Models.GenreItem;
import Group24.LibApp.Services.SearchService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class SearchControllerIntegrationTest extends AbstractTest {

    @Override
    @Before
    public void setUp() {
        super.setUp();
        this.initializeLibrary();
    }
    @MockBean
    private SearchService searchService;

    public ArrayList<Book> bookList = new ArrayList<Book>();
    public ArrayList<Genre> genreList = new ArrayList<Genre>();
    public ArrayList<GenreItem> genreItemList = new ArrayList<GenreItem>();

    public void initializeLibrary(){
        bookList.add(new Book(1, "Book1" , "book 1" , 1.0, 10, "publisher1", "12345-6789", 1998, 1, 4.7));
        bookList.add(new Book(2, "Book2" , "book 2" , 4.0, 15, "publisher1", "12345-6788", 1998, 1, 4.1));
        bookList.add(new Book(3, "Book3" , "book 3" , 9.0, 20, "publisher1", "12345-9876", 2000, 1, 4.2));
        bookList.add(new Book(4, "Book5" , "book 4" , 5.0, 10, "publisher1", "12345-6666", 2000, 1, 4.0));
        bookList.add(new Book(5, "Book6" , "book 5" , 1.0, 10, "publisher1", "12345-7777", 1999, 1, 3.5));
        bookList.add(new Book(6, "Book7" , "book 6" , 4.0, 15, "publisher1", "12345-6223", 1999, 1, 3.5));
        bookList.add(new Book(7, "Book8" , "book 7" , 9.0, 20, "publisher2", "12345-6444", 2001, 1, 3.0));
        bookList.add(new Book(8, "Book9" , "book 8" , 5.0, 27, "publisher2", "12345-9991", 2001, 1, 3.0));
        bookList.add(new Book(9, "Book10", "book 9" , 1.0, 17, "publisher2", "12345-6221", 2002, 1, 3.1));
        bookList.add(new Book(10, "Book11", "book 10", 4.0, 35, "publisher2", "12345-6799", 2002, 1, 3.1));
        bookList.add(new Book(11, "Book12", "book 11", 9.0, 21, "publisher3", "12345-9989", 2001, 2, 3.8));
        bookList.add(new Book(12, "Book13", "book 12", 5.0, 11, "publisher3", "12345-1889", 2000, 2, 3.9));
    
        genreList.add(new Genre(1, "1"));
        genreList.add(new Genre(2, "2"));
        genreList.add(new Genre(3, "3"));
        genreList.add(new Genre(4, "4"));
        genreList.add(new Genre(5, "5"));

        genreItemList.add(new GenreItem(1 , 1 , 1));
        genreItemList.add(new GenreItem(2 , 1 , 2));
        genreItemList.add(new GenreItem(3 , 2 , 1));
        genreItemList.add(new GenreItem(4 , 2 , 3));
        genreItemList.add(new GenreItem(5 , 3 , 1));
        genreItemList.add(new GenreItem(6 , 3 , 4));
        genreItemList.add(new GenreItem(7 , 4 , 2));
        genreItemList.add(new GenreItem(8 , 4 , 3));
        genreItemList.add(new GenreItem(9 , 5 , 2));
        genreItemList.add(new GenreItem(10, 5 , 4));
        genreItemList.add(new GenreItem(11, 6 , 3));
        genreItemList.add(new GenreItem(12, 6 , 4));
        genreItemList.add(new GenreItem(13, 7 , 1));
        genreItemList.add(new GenreItem(14, 7 , 5));
        genreItemList.add(new GenreItem(15, 8 , 2));
        genreItemList.add(new GenreItem(16, 8 , 5));
        genreItemList.add(new GenreItem(17, 9 , 5));
        genreItemList.add(new GenreItem(18, 10, 2));
        genreItemList.add(new GenreItem(19, 11, 3));
        genreItemList.add(new GenreItem(20, 12, 4));
    } 

    @Test
    public void getAllBooks() throws Exception {
        
        String uri = "/search";
        when(searchService.getAllBooks()).thenReturn(bookList);

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
            .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Book[] tmpbooklist = mapFromJson(content, Book[].class);
        assertTrue(tmpbooklist.length == 12);
    }

    @Test
    public void getAllBooksEmpty() throws Exception {
        
        String uri = "/search";
        when(searchService.getAllBooks()).thenReturn(new ArrayList<Book>());

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
            .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        
        int status = mvcResult.getResponse().getStatus();
        assertEquals(204, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.length() == 0);
    }

    @Test
    public void getGenreNULL() throws Exception {
        
        String uri = "/search/genre";
        when(searchService.getAllBooks()).thenReturn(bookList);

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
            .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Book[] tmpbooklist = mapFromJson(content, Book[].class);
        assertTrue(tmpbooklist.length == 12);
    }

    private ArrayList<GenreItem> getGIByGId(int id){
        ArrayList<GenreItem> tmpGIList = new ArrayList<GenreItem>();
        for (GenreItem gi : genreItemList){
            if (gi.getGenreId() == id)
                tmpGIList.add(gi);
        }
        return tmpGIList;
    } 

    private Book getBookById(int id){
        for (Book b : bookList)
            if (b.getId() == id)
                return b;
        return null;
    } 

    @Test
    public void getGenreANDSingle() throws Exception {
        
        for (int i = 1; i <= 5; i++) {
            String uri = "/search/genre?genres="+String.valueOf(i);
            when(searchService.getGenreByName(String.valueOf(i))).thenReturn(genreList.get(i-1));
            ArrayList<GenreItem> tmpGIList = getGIByGId(i);
            when(searchService.getGenreItemByGenreId(i)).thenReturn(tmpGIList);
            for (GenreItem gi : tmpGIList){
                when(searchService.getBooksById(gi.getBookId())).thenReturn(getBookById(gi.getBookId()));
            }

            MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
            
            int status = mvcResult.getResponse().getStatus();
            assertEquals(200, status);

            String content = mvcResult.getResponse().getContentAsString();
            Book[] tmpbooklist = mapFromJson(content, Book[].class);
            for (GenreItem gi : tmpGIList){
                boolean found = false;
                for (Book book : tmpbooklist){
                    if (book.getId() == gi.getBookId()){
                        found = true;
                    }
                }
                assertTrue(found);
            }
        }
    }

    @Test
    public void getGenreANDMultiple() throws Exception {
        
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                if (i == j)
                    continue;

                String uri = "/search/genre?genres="+String.valueOf(i)+";"+String.valueOf(j);
                when(searchService.getGenreByName(String.valueOf(i))).thenReturn(genreList.get(i-1));
                when(searchService.getGenreByName(String.valueOf(j))).thenReturn(genreList.get(j-1));
                ArrayList<GenreItem> tmpGIListi = getGIByGId(i);
                ArrayList<GenreItem> tmpGIListj = getGIByGId(j);
                when(searchService.getGenreItemByGenreId(i)).thenReturn(tmpGIListi);
                when(searchService.getGenreItemByGenreId(j)).thenReturn(tmpGIListj);
                for (GenreItem gi : tmpGIListi){
                    when(searchService.getBooksById(gi.getBookId())).thenReturn(getBookById(gi.getBookId()));
                }
                for (GenreItem gj : tmpGIListj){
                    when(searchService.getBooksById(gj.getBookId())).thenReturn(getBookById(gj.getBookId()));
                }

                MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                    .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

                int status = mvcResult.getResponse().getStatus();
                if ((i == 3 && j == 5) || (i == 5 && j == 3) || (i == 4 && j == 5) || (i == 5 && j ==4))
                    assertEquals(204, status);
                else{
                    assertEquals(200, status);
                    String content = mvcResult.getResponse().getContentAsString();
                    Book[] tmpbooklist = mapFromJson(content, Book[].class);
                    assertTrue(tmpbooklist.length == 1);

                }
            }
        }
    }

    @Test
    public void getGenreORSingle() throws Exception {
        
        for (int i = 1; i <= 5; i++) {
            String uri = "/search/genre?genres="+String.valueOf(i)+"&operation=OR";
            when(searchService.getGenreByName(String.valueOf(i))).thenReturn(genreList.get(i-1));
            ArrayList<GenreItem> tmpGIList = getGIByGId(i);
            when(searchService.getGenreItemByGenreId(i)).thenReturn(tmpGIList);
            for (GenreItem gi : tmpGIList){
                when(searchService.getBooksById(gi.getBookId())).thenReturn(getBookById(gi.getBookId()));
            }

            MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
            
            int status = mvcResult.getResponse().getStatus();
            assertEquals(200, status);

            String content = mvcResult.getResponse().getContentAsString();
            Book[] tmpbooklist = mapFromJson(content, Book[].class);
            for (GenreItem gi : tmpGIList){
                boolean found = false;
                for (Book book : tmpbooklist){
                    if (book.getId() == gi.getBookId()){
                        found = true;
                    }
                }
                assertTrue(found);
            }
        }
    }

    @Test
    public void getGenreORMultiple() throws Exception {
        
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                if (i == j)
                    continue;

                String uri = "/search/genre?genres="+String.valueOf(i)+";"+String.valueOf(j)+"&operation=OR";
                when(searchService.getGenreByName(String.valueOf(i))).thenReturn(genreList.get(i-1));
                when(searchService.getGenreByName(String.valueOf(j))).thenReturn(genreList.get(j-1));
                ArrayList<GenreItem> tmpGIListi = getGIByGId(i);
                ArrayList<GenreItem> tmpGIListj = getGIByGId(j);
                when(searchService.getGenreItemByGenreId(i)).thenReturn(tmpGIListi);
                when(searchService.getGenreItemByGenreId(j)).thenReturn(tmpGIListj);
                for (GenreItem gi : tmpGIListi){
                    when(searchService.getBooksById(gi.getBookId())).thenReturn(getBookById(gi.getBookId()));
                }
                for (GenreItem gj : tmpGIListj){
                    when(searchService.getBooksById(gj.getBookId())).thenReturn(getBookById(gj.getBookId()));
                }

                MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                    .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

                int status = mvcResult.getResponse().getStatus();
                
                assertEquals(200, status);
                String content = mvcResult.getResponse().getContentAsString();
                Book[] tmpbooklist = mapFromJson(content, Book[].class);
                for (GenreItem gi : tmpGIListi){
                    boolean found = false;
                    for (Book book : tmpbooklist){
                        if (book.getId() == gi.getBookId()){
                            found = true;
                        }
                    }
                    assertTrue(found);
                }
                for (GenreItem gi : tmpGIListj){
                    boolean found = false;
                    for (Book book : tmpbooklist){
                        if (book.getId() == gi.getBookId()){
                            found = true;
                        }
                    }
                    assertTrue(found);
                }
            }
        }
    }

    @Test
    public void getTopSellers() throws Exception {
        
        String uri = "/search/topSellers";
        when(searchService.getTopTenBooks()).thenReturn(bookList);

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
            .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Book[] tmpbooklist = mapFromJson(content, Book[].class);
        assertTrue(tmpbooklist.length == 12);
    }

    @Test
    public void getByRating() throws Exception {
        
        Random r = new Random();
        double rate = 5 * r.nextDouble();

        String uri = "/search/rating?rating="+String.valueOf(rate);
        when(searchService.getBookByRating(rate)).thenReturn(bookList);

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
            .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    public void putUpdatePrice() throws Exception {
        
        Random r = new Random();
        Double discount = 1 * r.nextDouble();

        for (int i = 1; i <= 3; i++) {
            String uri = "/search/updatePriceByDiscount?publisher=publisher"+String.valueOf(i)+"&discount="+String.valueOf(discount);
            when(searchService.updateBookPriceByDiscount("publisher"+String.valueOf(i), discount)).thenReturn(true);

            MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
            
            int status = mvcResult.getResponse().getStatus();
            assertEquals(200, status);
        }
    }
}
