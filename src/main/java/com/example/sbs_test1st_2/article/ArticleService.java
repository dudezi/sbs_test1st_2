package com.example.sbs_test1st_2.article;

import com.example.sbs_test1st_2.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<Article> getList() {
        return articleRepository.findAll();
    }

    public Article getArticle(Integer id) {
        Optional<Article> oq = this.articleRepository.findById(id);
        if (oq.isPresent()) {
            return oq.get();
        } else {
            throw new DataNotFoundException("question not found");
        }
    }

    public void create(String title, String content) {
        Article a = new Article();
        a.setTitle(title);
        a.setContent(content);
        a.setCreatedDate(LocalDateTime.now());

        articleRepository.save(a);
    }
}