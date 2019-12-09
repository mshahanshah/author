package info.ali.auther;

import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

	@Autowired
	AuthorRepository authRepo;

	@PostConstruct
	public void doSomeStartUp() {
		System.out.println("Do Some Start Up");
	}

	@PreDestroy
	public void doSomeEndUp() {
		System.out.println("Do Some End Up");
	}

	public Author getAuthor() {
		List<Author> allAuthor = authRepo.findAll();
		if (CollectionUtils.isNotEmpty(allAuthor)) {
			return allAuthor.get(0);
		}
		return null;
	}

	public List<Author> getAllAuthor() {
		return authRepo.findAll();
	}

	public List<Author> getNAuthor(String n) {
		List<Author> findNAuthor = authRepo.findNAuthor(n);
		System.out.println(findNAuthor.size());
		System.out.println(findNAuthor.toString());
		return findNAuthor;
	}

	public Author getAllAuthorByName(String name) {
		return authRepo.findFirstByName(name);
	}

	public List<Author> getAllAuthorByPage(Integer pageNo, Integer size) {
		Pageable pageble = PageRequest.of(pageNo, size, Sort.by("name"));
		Page<Author> autherPager = authRepo.findAll(pageble);
		if (autherPager.hasContent()) {
			return autherPager.getContent();
		} else {
			return Collections.emptyList();
		}
	}

}