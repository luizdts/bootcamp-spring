package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Event;

public interface EventRepository extends JpaRepository<Event, Long>{

}
