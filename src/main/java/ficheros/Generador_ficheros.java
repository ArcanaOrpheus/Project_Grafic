package ficheros;

import project.Client;
import project.Magatzem;
import project.Producte;
import project.Proveidor;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class Generador_ficheros {
	File fclient = new File("clients");
	File fproveidor = new File("proveidors");
	File fproductes = new File("productes");
	Magatzem m;
	//Serializacion
	void ClientSave() {
		try {

			FileOutputStream fol = new FileOutputStream(fclient);
			ObjectOutputStream oos = new ObjectOutputStream(fol);
			
			List<Client> client = m.getClients();
			for(Client c : client) {
				oos.writeObject(c);
			}
			oos.flush(); // opcional
			oos.close();

		} catch (Exception pasanCosas) {
			pasanCosas.printStackTrace();
		}
	}
	
	List<Client> ClientRead() {
		try {
			List <Client> c = null;
			FileInputStream fis = new FileInputStream("clients");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			try {
				while (true) {
					Object o = ois.readObject();
					c.add((Client) o);			
				}

			} catch (EOFException fin) {
				System.out.println("Fin de fichero");
				ois.close();
			}
			return c;
		}
		catch (Exception pasanCosas) {
			pasanCosas.printStackTrace();
			return null;
		}
		
	}
	void ProveidorSave() {
		try {

			FileOutputStream fol = new FileOutputStream(fproveidor);
			ObjectOutputStream oos = new ObjectOutputStream(fol);
			
			List<Proveidor> proveidor = m.getProveidors();
			for(Proveidor p : proveidor) {
				oos.writeObject(p);
			}
			oos.flush(); // opcional
			oos.close();

		} catch (Exception pasanCosas) {
			pasanCosas.printStackTrace();
		}
	}
	
	List<Proveidor> ProveidorRead() {
		try {
			List <Proveidor> c = null;
			FileInputStream fis = new FileInputStream("proveidors");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			try {
				while (true) {
					Object o = ois.readObject();
					c.add((Proveidor) o);			
				}

			} catch (EOFException fin) {
				System.out.println("Fin de fichero");
				ois.close();
			}
			return c;
		}
		catch (Exception pasanCosas) {
			pasanCosas.printStackTrace();
			return null;
		}
	}
	
	void ProducteSave() {
		try {

			FileOutputStream fol = new FileOutputStream(fproductes);
			ObjectOutputStream oos = new ObjectOutputStream(fol);
			
			List<Producte> productes = m.getProductes();
			for(Producte p : productes) {
				oos.writeObject(p);
			}
			oos.flush(); // opcional
			oos.close();

		} catch (Exception pasanCosas) {
			pasanCosas.printStackTrace();
		}
	}
	
	List<Producte> ProducteRead() {
		try {
			List <Producte> c = null;
			FileInputStream fis = new FileInputStream("productes");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			try {
				while (true) {
					Object o = ois.readObject();
					c.add((Producte) o);			
				}

			} catch (EOFException fin) {
				System.out.println("Fin de fichero");
				ois.close();
			}
			return c;
		}
		catch (Exception pasanCosas) {
			pasanCosas.printStackTrace();
			return null;
		}
	}
	
}
