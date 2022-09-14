package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.City;

public interface CityRepository extends JpaRepository<City, Long>{

}
