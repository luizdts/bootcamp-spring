package com.bootcamp.learnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.learnbds.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

}
