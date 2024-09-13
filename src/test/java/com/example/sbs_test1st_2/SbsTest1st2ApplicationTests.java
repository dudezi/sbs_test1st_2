package com.example.sbs_test1st_2;

import com.example.sbs_test1st_2.article.Article;
import com.example.sbs_test1st_2.article.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class SbsTest1st2ApplicationTests {
	@Autowired
	private ArticleRepository articleRepository;

	@Test
	void testJpa() {
		Article a1 = new Article();
		a1.setTitle("test07");
		a1.setContent("test07");
		a1.setCreatedDate(LocalDateTime.now());
		this.articleRepository.save(a1);
	}

}
