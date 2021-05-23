package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Plataforma;
import util.HibernateUtil;

public class PlataformaDAO {

	public void salvarPlataforma (Plataforma plataforma) {
		Transaction trans = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {		
			//Iniciar transacao
			trans = session.beginTransaction();
			
			session.saveOrUpdate(plataforma);
			
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}
	}
	
	public Plataforma getPlataforma(long id) {
		Transaction trans = null;
		Plataforma plataforma = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {		
			//Iniciar transacao
			trans = session.beginTransaction();
			
			plataforma = session.get(Plataforma.class, id);
			
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}
		
		return plataforma;
	}
	
	public void removePlataforma(long id) {
		Transaction trans = null;
		Plataforma plataforma = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {		
			//Iniciar transacao
			trans = session.beginTransaction();
			
			//Puxa
			session.get(Plataforma.class, id);
			//Remove
			session.remove(plataforma);
			
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}
		
	}
	
	public List<Plataforma> listarJogo() {
		Transaction trans = null;
		List<Plataforma> plataformas = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {		
			//Iniciar transacao
			trans = session.beginTransaction();
			
			//Puxa
			plataformas = session.createQuery("from Jogo").list();
			
			
			
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}
		
		return plataformas;
		
	}
}
