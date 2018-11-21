package project;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class Factory {

	static Producte empleado;
	static Address direccion;
	static Client client;
	static Session session;
	static SessionFactory sessionFactory;
	static ServiceRegistry serviceRegistry; 
	
	
	public static synchronized SessionFactory getSessionFactory() {
	    if ( sessionFactory == null ) {

	        // exception handling omitted for brevityaa

	        serviceRegistry = new StandardServiceRegistryBuilder()
	                .configure("hibernate.cfg.xml")
	                .build();

	        sessionFactory = new MetadataSources( serviceRegistry )
	                    .buildMetadata()
	                    .buildSessionFactory();
	    }
	    return sessionFactory;
	}
	
	
	public static void main(String[] args) {
		///abrimos sesion. Eso se hace siempre
		try {
			session = getSessionFactory().openSession();
			
			//abrimos PRIMERA transaccion. Eso se hace siempre.
			session.beginTransaction();
			
			for (int i = 200; i < 210; i++) {
				Client c = new Client();
				session.saveOrUpdate(c);
				Comanda com = new Comanda();
				com.estat=ComandaEstat.PENDENT;
				session.saveOrUpdate(com);
				Address dir = new Address();
				dir.setCarrer("Calle 13");
				dir.setLatitud(4.20);
				dir.setLongitud(6.9);
				dir.setNumero(3);
				dir.setPais("Españita");
				dir.setPoblacio("El closet");
				dir.setPostal("08213");
				dir.setTelefon("This is a telefon");
				session.saveOrUpdate(dir);
				Proveidor prov= new Proveidor("Steve");
				Producte prod = new Producte();
				prod.codiProducte=i;
				prod.setNomProducte("Lapizlazuli");
				prod.setPreuVenda(1);
				prod.setProveidor(prov);
				prod.setStock(99);
				prod.setStockMinim(1);
				prod.setTipus(Tipus.INGREDIENT);
				prod.setUnitatMesura(UnitatMesura.UNITAT);
				session.saveOrUpdate(prod);
				ComandaLinia cmd = new ComandaLinia(prod, 1, 1);
				session.saveOrUpdate(cmd);
				Date date= new Date();
				LotDesglossat ld= new LotDesglossat(7,date,7);
				session.saveOrUpdate(ld);
				List<Producte> lp = new ArrayList<Producte>();
				List<Client> lc = new ArrayList<Client>();
				List<Comanda> lm = new ArrayList<Comanda>();
				List<Proveidor> lpv = new ArrayList<Proveidor>();
				lp.add(prod);
				lc.add(c);
				lm.add(com);
				lpv.add(prov);
				Magatzem mg = new Magatzem(lp,lc,lm,lpv);
				session.saveOrUpdate(mg);
			}
			
			
			Producte marc = session.get(Producte.class, 200);
			
			System.out.println(marc);
			System.out.println(marc.getNomProducte());
			System.out.println(marc.getCodiProducte());
			
			/*
			Random r = new Random();
			
			for(int i = 200; i<210; i++) {
				Gato gato = new Gato();
				gato.setId(i);
				gato.setNombre("gatete "+(i-100));
				gato.setEdad(0);
				gato.setRaza("Persa");
				gato.setCapado(r.nextBoolean());
				gato.setFecha(new Date());
				
				session.saveOrUpdate(gato);
			}
			
			
			Gato gatetecientouno = session.get(Gato.class, 101);
			System.out.println(gatetecientouno.getNombre());
			gatetecientouno.setNombre("kernel");
			session.saveOrUpdate(gatetecientouno);
			
			 session.beginTransaction();
			session.getTransaction().commit();
			
	        session.beginTransaction();
	         
	         List<Object> todoslosgatos = session.createQuery("FROM Gato").list();
	         int capados = 0;
	         for (Object o : todoslosgatos){
	            Gato g = (Gato)o;
	            
	            System.out.println("El gatete "+g.getNombre()+" esta capado "+g.isCapado());
	            if(g.isCapado()) {
	            	capados++;
	            }
	         }
	         
	         System.out.println("hay "+capados+" gatetes capados");
	         
	         */
			 session.beginTransaction();
	         session.getTransaction().commit();
			System.out.println("todo ha salido a pedir de Milhouse");
		} catch(Exception sqlException) {
			sqlException.printStackTrace();
			if(null != session.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				session.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if(session != null) {
				session.close();
			}
		}
		
		

	}
}