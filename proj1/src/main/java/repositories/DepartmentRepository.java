package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
