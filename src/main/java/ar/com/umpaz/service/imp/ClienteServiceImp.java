	package ar.com.umpaz.service.imp;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import ar.com.umpaz.model.Cliente;
	import ar.com.umpaz.respository.ClienteRepository;
	import ar.com.umpaz.service.ClienteService;

	@Service
	public class ClienteServiceImp implements ClienteService {

		@Autowired
		private ClienteRepository clienteRepository;
		
		@Override
		public Cliente save(Cliente Obj) {
			return clienteRepository.save(Obj);
		}

		@Override
		public List<Cliente> listAllById(Cliente Obj) {
			return null;
		}

		@Override
		public Cliente update(Cliente Obj) {
			return clienteRepository.save(Obj);
		}

		@Override
		public void delete(Cliente Objt) {
			clienteRepository.delete(Objt);
		}

		@Override
		public Cliente getById(Cliente Obj) {
			return  clienteRepository.findById(Obj.id).get();
		}

		@Override
		public List<Cliente> getAll() {
			return (List<Cliente>) clienteRepository.findAll();
		}

	}
