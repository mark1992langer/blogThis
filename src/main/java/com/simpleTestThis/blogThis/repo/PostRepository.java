package com.simpleTestThis.blogThis.repo;

import com.simpleTestThis.blogThis.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
