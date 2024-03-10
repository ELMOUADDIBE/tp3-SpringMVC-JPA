package ma.enset.tp3.repository;

import ma.enset.tp3.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsulatationRepository extends JpaRepository<Consultation, Long>{
}
