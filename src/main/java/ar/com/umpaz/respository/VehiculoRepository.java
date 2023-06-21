package ar.com.umpaz.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.umpaz.model.Vehiculo;

public interface VehiculoRepository extends JpaRepository<Vehiculo,Long> {
    
}
