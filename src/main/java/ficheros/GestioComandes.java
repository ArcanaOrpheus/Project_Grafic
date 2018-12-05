package ficheros;

import java.util.List;

import project.Client;
import project.Magatzem;

public class GestioComandes {

	public Client triarClient(Magatzem m) {
		
		Client c = new Client();
		
		List<Client> llista = m.getClients();
		
		return c;
		
		
	}
	
	
}
