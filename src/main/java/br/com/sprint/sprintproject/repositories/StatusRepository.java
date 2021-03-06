package br.com.sprint.sprintproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sprint.sprintproject.models.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {

}
