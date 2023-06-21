package ar.com.umpaz.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.umpaz.model.Seguro;

@Repository
public interface SeguroRepository extends JpaRepository<Seguro, Long> {
    
}
