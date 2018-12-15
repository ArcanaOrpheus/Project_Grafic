package ficheros;

import java.util.List;

import project.Client;
import project.Comanda;
import project.ComandaLinia;
import project.Magatzem;
import project.Programa;

public class GestioComandes {

	public Client triarClient(Magatzem m) {
		
		Client c = new Client();
		
		List<Client> llista = m.getClients();
		
		return c;	
	}
	
	
	public static Comanda comandaPerId(int id) throws Exception
	{
		for(Comanda c : Programa.elMeuMagatzem.getComandes())
		{
			if(c.getIdComanda() == id)
			{
				return c;
			}	
		}
		throw new Exception("La comanda amb aquest id no existeix");
	}
	
	
	public static double calcularPreu(int id) throws Exception {
		
		Comanda c = comandaPerId(id);
		
		double preufinal = 0;
		
		for(ComandaLinia cl : c.getLinies())
		{
			preufinal = preufinal + (cl.getQuantitat() * cl.getPreuVenda());
		}
		
		return preufinal;
		
	}
	
	
}
