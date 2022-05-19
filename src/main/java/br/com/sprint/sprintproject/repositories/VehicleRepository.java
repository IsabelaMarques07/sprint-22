package br.com.sprint.sprintproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sprint.sprintproject.models.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

}
