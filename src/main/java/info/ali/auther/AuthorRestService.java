package info.ali.auther;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorRestService extends ShutDownController {

	@Autowired
	AuthorService authService;

	@Autowired
	Environment env;

	@GetMapping("/author")
	public Author getAuthor() {
		Author author = authService.getAuthor();
		System.out.println(author);
		System.out.println(env.getProperty("local.server.port"));
		return author;
	}
	
	@GetMapping("/author/{nauthor}")
	public List<Author> getAuthor(@PathVariable String nauthor) {
		List<Author> author = authService.getNAuthor(nauthor);
		System.out.println(author);
		System.out.println(env.getProperty("local.server.port"));
		return author;
	}
	
	@GetMapping("/authorlist/{pageno}/{size}")
	public List<Author> listAuthor(@PathVariable("pageno") Integer pageno, @PathVariable("size") Integer size) {
		List<Author> author = authService.getAllAuthorByPage(pageno, size);
		System.out.println(author);
		System.out.println(env.getProperty("local.server.port"));
		return author;
	}

/*	@GetMapping("/author/{name}")
	public Author getAuthorWithName(@PathVariable("name") String name) {
		Author author = authService.getAllAuthorByName(name);
		System.out.println(author);
		return author;
	}*/

}