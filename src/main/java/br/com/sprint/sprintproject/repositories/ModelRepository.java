package br.com.sprint.sprintproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sprint.sprintproject.models.Model;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> {

}
