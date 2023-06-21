package ar.com.umpaz.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.umpaz.model.Cliente;

@Repository
public interface ClienteRepository  extends JpaRepository <Cliente, Long>{

}
