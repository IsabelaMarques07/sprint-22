package br.com.sprint.sprintproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sprint.sprintproject.models.Part;
@Repository
public interface PartRepository extends JpaRepository<Part, Integer> {
	List<Part> findByIdVehicle(int idVehicle);
}
