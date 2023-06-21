package ar.com.umpaz.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.umpaz.model.Vehiculo;
import ar.com.umpaz.respository.VehiculoRepository;
import ar.com.umpaz.service.VehiculoService;

@Service
public class VehiculoServiceImp  implements VehiculoService{

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Override
    public Vehiculo save(Vehiculo Obj) {
       return vehiculoRepository.save(Obj);
    }

    @Override
    public List<Vehiculo> listAllById(Vehiculo Obj) {
        return (List<Vehiculo>) vehiculoRepository.findAll();

    }

    @Override
    public Vehiculo update(Vehiculo Obj) {
        return vehiculoRepository.save(Obj);

    }

    @Override
    public void delete(Vehiculo Obj) {
        vehiculoRepository.delete(Obj);

    }

    @Override
    public Vehiculo getById(Vehiculo Obj) {
        return vehiculoRepository.findById(Obj.id).get();

    }

    @Override
    public List<Vehiculo> getAll() {
        return (List<Vehiculo>) vehiculoRepository.findAll();

    }
    
}
