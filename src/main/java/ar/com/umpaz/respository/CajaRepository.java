package ar.com.umpaz.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.umpaz.model.Caja;

@Repository
public interface CajaRepository extends JpaRepository<Caja,Long> {
    
}
