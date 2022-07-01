package com.simpleTestThis.blogThis.repo;

import com.simpleTestThis.blogThis.models.Post;
import org.springframework.data.repository.CrudRepository;



// чтобы производит манипуляции с моделью Post наследуемся. Параметры: Post, Long (модель с которой мы работаем и тип данных для id/
public interface PostRepository extends CrudRepository<Post, Long> {

}
