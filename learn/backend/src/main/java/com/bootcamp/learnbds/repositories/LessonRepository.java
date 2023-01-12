package com.bootcamp.learnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.learnbds.entities.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Long>{

}
