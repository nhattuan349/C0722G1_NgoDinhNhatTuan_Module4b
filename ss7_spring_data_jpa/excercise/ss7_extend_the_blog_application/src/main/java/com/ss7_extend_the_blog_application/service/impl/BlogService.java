package com.ss7_extend_the_blog_application.service.impl;

import com.ss7_extend_the_blog_application.model.Blog;
import com.ss7_extend_the_blog_application.repository.IBlogRepository;
import com.ss7_extend_the_blog_application.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;



    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findByNameAndCategory(Pageable pageable, String author, String category) {
        return blogRepository.findByNameAndCategory(pageable, "%" + author + "%","%" + category + "%");
    }
}
