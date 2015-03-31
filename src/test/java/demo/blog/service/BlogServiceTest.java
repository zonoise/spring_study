package demo.blog.service;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import demo.DemoApplication;
import demo.blog.domain.Post;
import junit.framework.TestCase;
import org.hibernate.CustomEntityDirtinessStrategy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class})
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@WebAppConfiguration
@Transactional
@TransactionConfiguration(defaultRollback = true)
@DatabaseSetup("/post.xml")
@DirtiesContext
public class BlogServiceTest extends TestCase {

    @Autowired
    private BlogService blogService;
    @Test
    public void contextLoads() {
    }

    @Test
    public void getPostTest() {
        Iterable<Post> a = blogService.getPost();
        for(Post p : a){
            assertEquals(Post.class,p.getClass());
            assertEquals("hoge",p.getTitle());
            //assertSame("hage", p.getTitle());

            break;
        }
    }


}