package ficheros;

import java.util.List;

import project.Client;
import project.Magatzem;

public class GestioClients {

	public void altaClient(Magatzem m, Client c) throws Exception {
		
		List<Client> tmp = m.getClients();
		
		for(Client cl : tmp)
		{
			if(cl == c)
			{
				throw new Exception("El client ja esta donat d'alta");
			}
		}
		
		tmp.add(c);
		
		m.setClients(tmp);
		
	}
	
	public boolean baixaClient(Magatzem m, Client c) throws Exception {
		
		List<Client> tmp = m.getClients();
		
		for(Client cl : tmp)
		{
			if(cl == c)
			{
				tmp.remove(cl);
				m.setClients(tmp);
				return true;
			}
		}
		
		throw new Exception("El client no existeix");
	}
	
	public void modifyNom(Magatzem m, Client c, String s) {
		c.setNomClient(s);

		List<Client> tmp = m.getClients();
		
		for(Client cl : tmp)
		{
			if(cl.getIdClient() == c.getIdClient())
			{
				m.getClients().remove(cl);
				m.getClients().add(c);
				break;
			}
		}
		
	}

	public void modifyCIF(Magatzem m, Client c, String s) {
		c.setCIF(s);

		List<Client> tmp = m.getClients();
		
		for(Client cl : tmp)
		{
			if(cl.getIdClient() == c.getIdClient())
			{
				m.getClients().remove(cl);
				m.getClients().add(c);
				break;
			}
		}
		
	}	
	
	public void modifyActiu(Magatzem m, Client c) {
		
		if(c.isActiu()) {
			c.setActiu(false);
		}else {
			c.setActiu(true);
		}
		
		List<Client> tmp = m.getClients();
		
		for(Client cl : tmp)
		{
			if(cl.getIdClient() == c.getIdClient())
			{
				m.getClients().remove(cl);
				m.getClients().add(c);
				break;
			}
		}
		
	}
	
	public void modifyDireccio(Magatzem m, Client c, String s) {
		c.setDireccio(s);

		List<Client> tmp = m.getClients();
		
		for(Client cl : tmp)
		{
			if(cl.getIdClient() == c.getIdClient())
			{
				m.getClients().remove(cl);
				m.getClients().add(c);
				break;
			}
		}
		
	}
	
	public void modifyPoblacio(Magatzem m, Client c, String s) {
		c.setPoblacio(s);

		List<Client> tmp = m.getClients();
		
		for(Client cl : tmp)
		{
			if(cl.getIdClient() == c.getIdClient())
			{
				m.getClients().remove(cl);
				m.getClients().add(c);
				break;
			}
		}
		
	}	
	
	public void modifyPais(Magatzem m, Client c, String s) {
		c.setPais(s);

		List<Client> tmp = m.getClients();
		
		for(Client cl : tmp)
		{
			if(cl.getIdClient() == c.getIdClient())
			{
				m.getClients().remove(cl);
				m.getClients().add(c);
				break;
			}
		}
		
	}	
	
	public void modifyTlf(Magatzem m, Client c, String s) {
		c.setTelefon(s);

		List<Client> tmp = m.getClients();
		
		for(Client cl : tmp)
		{
			if(cl.getIdClient() == c.getIdClient())
			{
				m.getClients().remove(cl);
				m.getClients().add(c);
				break;
			}
		}
		
	}	
	
	public void modifyPersonaContacte(Magatzem m, Client c, String s) {
		c.setPersonaContacte(s);

		List<Client> tmp = m.getClients();
		
		for(Client cl : tmp)
		{
			if(cl.getIdClient() == c.getIdClient())
			{
				m.getClients().remove(cl);
				m.getClients().add(c);
				break;
			}
		}
		
	}	
	
	public void modifyLong(Magatzem m, Client c, double d) {
		c.setLongitud(d);

		List<Client> tmp = m.getClients();
		
		for(Client cl : tmp)
		{
			if(cl.getIdClient() == c.getIdClient())
			{
				m.getClients().remove(cl);
				m.getClients().add(c);
				break;
			}
		}
		
	}	
	
	public void modifyLat(Magatzem m, Client c, double d) {
		c.setLatitud(d);

		List<Client> tmp = m.getClients();
		
		for(Client cl : tmp)
		{
			if(cl.getIdClient() == c.getIdClient())
			{
				m.getClients().remove(cl);
				m.getClients().add(c);
				break;
			}
		}
		
	}
	
	public Client cercaIdClient(Magatzem m, int s) throws Exception {
		
		Client c = new Client();
		
		List<Client> tmp = m.getClients();
		
		for(Client cl : tmp)
		{
			if(cl.getIdClient() == s)
			{
				c = cl;
				return c;
			}
		}
		
		throw new Exception("El client amb el id buscat no existeix");
	}
	
	public Client cercaNomClient(Magatzem m, String s) throws Exception {
		
		Client c = new Client();
		
		List<Client> tmp = m.getClients();
		
		for(Client cl : tmp)
		{
			if(cl.getNomClient() == s)
			{
				c = cl;
				return c;
			}
		}
		
		throw new Exception("El client amb el nom buscat no existeix");
	}


}
