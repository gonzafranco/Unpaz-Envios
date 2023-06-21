package ar.com.umpaz.seed;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.umpaz.model.Caja;
import ar.com.umpaz.model.Estado;
import ar.com.umpaz.model.Seguro;
import ar.com.umpaz.respository.CajaRepository;
import ar.com.umpaz.respository.EstadoRepository;
import ar.com.umpaz.respository.SeguroRepository;

@Component
public class DatabaseSeed {

    @Autowired
    private CajaRepository cajaRepository;
    @Autowired
    private SeguroRepository seguroRepository;
    @Autowired
    private EstadoRepository estadoRepository;

    @PostConstruct
    public void seedDatabase() {
        cajaSeed();
        seguroSeed();
        estadoSeed();
    }

    private void cajaSeed() {
        Caja caja1 = new Caja();
        caja1.setTipo("4x4");
        cajaRepository.save(caja1);

        Caja caja2 = new Caja();
        caja2.setTipo("16x16");
        cajaRepository.save(caja2);

        Caja caja3 = new Caja();
        caja3.setTipo("32x32");
        cajaRepository.save(caja3);
    }

    private void seguroSeed() {
       Seguro seguro1 = new Seguro();
       seguro1.setDescripcion("Sancor");
       seguroRepository.save(seguro1);

       Seguro seguro2 = new Seguro();
       seguro2.setDescripcion("La caja");
       seguroRepository.save(seguro2);

       Seguro seguro3 = new Seguro();
       seguro3.setDescripcion("Don pepe");
       seguroRepository.save(seguro3);



    }

     private void estadoSeed() {

        Estado estado1 = new Estado();
        estado1.setEstado("Pendiente");
        estadoRepository.save(estado1);

        
        Estado estado2 = new Estado();
        estado2.setEstado("Confirmado");
        estadoRepository.save(estado2);
     }
    
}
