package ar.com.umpaz.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.umpaz.model.Estado;

public interface EstadoRepository  extends JpaRepository<Estado,Long>{
    
}
