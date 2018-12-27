package ficheros;

import project.Producte;
import project.Programa;

public class GestioProductes {
	
	
	public static Producte productePerId(int id) throws Exception
	{
		
		for(Producte p : Programa.elMeuMagatzem.getProductes())
		{
			if(p.getCodiProducte() == id)
			{
				//System.out.println(c.getIdComanda()+" "+c.getClient());
				return p;
			}	
		}
		throw new Exception("El producte amb aquest id no existeix");
	}
	
}
