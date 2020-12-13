//package com.codeup.blogapplication;
//
//import com.codeup.blogapplication.models.Posts;
//import com.codeup.blogapplication.models.User;
//import com.codeup.blogapplication.repos.PostsRepository;
//import com.codeup.blogapplication.repos.UserRepository;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpStatus;
//import org.springframework.mock.web.MockHttpSession;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import javax.servlet.http.HttpSession;
//
//
//import static org.hamcrest.Matchers.containsString;
//import static org.junit.Assert.assertNotNull;
//import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = BlogapplicationApplication.class)
//@AutoConfigureMockMvc
//public class PostsIntegrationTests {
//    private User testUser;
//    private HttpSession httpSession;
//
//    @Autowired
//    private MockMvc mvc;
//
//    @Autowired
//    UserRepository userDao;
//
//    @Autowired
//    PostsRepository postsDao;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Before
//    public void setup() throws Exception {
//        testUser = userDao.findByUsername("testUser");
//
//        // Creates the test user if not exists
//        if(testUser == null){
//            User newUser = new User();
//            newUser.setUsername("testUser");
//            newUser.setPassword(passwordEncoder.encode("pass"));
//            newUser.setEmail("testUser@codeup.com");
//            testUser = userDao.save(newUser);
//        }
//
//        // Throws a Post request to /login and expect a redirection to the Ads index page after being logged in
//        httpSession = this.mvc.perform(post("/login").with(csrf())
//                .param("username", "testUser")
//                .param("password", "pass"))
//                .andExpect(status().is(HttpStatus.FOUND.value()))
//                .andExpect(redirectedUrl("/posts/index"))
//                .andReturn()
//                .getRequest()
//                .getSession();
//    }
//
//    //Sanity Tests
//    @Test
//    public void contextLoads() {
//
//        assertNotNull(mvc);
//    }
//
//    @Test
//    public void testIfUserSessionIsActive() throws Exception {
//
//        assertNotNull(httpSession);
//    }
//
//    //Read cRud
//
//    @Test
//    public void testShowPost() throws Exception{ //testing post{id} page
//        Posts existingPost = postsDao.findAll().get(0);
//
//        this.mvc.perform(get("/posts/" + existingPost.getId()))
//                .andExpect(status().isOk())
//                .andExpect(content().string(containsString(existingPost.getBody())));
//    }
//
//    @Test
//    public void testPostIndex() throws Exception{
//        Posts existingPost = postsDao.findAll().get(0);
//
//        this.mvc.perform(get("/posts/index"))
//                .andExpect(status().isOk())
//                .andExpect(content().string(containsString("Current Posts")))
//                .andExpect(content().string(containsString(existingPost.getTitle())));
//    }
//
//    @Test
//    public void testCreatePost() throws Exception{
//        this.mvc.perform(
//                post("/posts/create/").with(csrf())
//                .session((MockHttpSession) httpSession)
//                .param("title", "test")
//                .param("body","test body"))
//                .andExpect(status().is3xxRedirection());
//    }
//}
