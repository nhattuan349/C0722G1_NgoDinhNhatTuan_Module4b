package com.create_blog_application.service.impl;

import com.create_blog_application.model.Blog;
import com.create_blog_application.repository.IBlogRepository;
import com.create_blog_application.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findByName(String author) {
        return blogRepository.findByName(author);
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }


    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void removed(Long id) {
        blogRepository.deleteById(id);
    }
}
