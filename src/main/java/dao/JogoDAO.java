package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.engine.internal.SessionEventListenerManagerImpl;

import model.Jogo;
import util.HibernateUtil;

public class JogoDAO {

	public void salvarJogo (Jogo jogo) {
		Transaction trans = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {		
			//Iniciar transacao
			trans = session.beginTransaction();
			
			session.saveOrUpdate(jogo);
			
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}
	}
	
	public Jogo getJogo(long id) {
		Transaction trans = null;
		Jogo jogo = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {		
			//Iniciar transacao
			trans = session.beginTransaction();
			
			jogo = session.get(Jogo.class, id);
			
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}
		
		return jogo;
	}
	
	public void removeJogo(long id) {
		Transaction trans = null;
		Jogo jogo = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {		
			//Iniciar transacao
			trans = session.beginTransaction();
			
			//Puxa
			session.get(Jogo.class, id);
			//Remove
			session.remove(jogo);
			
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}
		
	}
	
	public List<Jogo> listarJogo() {
		Transaction trans = null;
		List<Jogo> jogos = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {		
			//Iniciar transacao
			trans = session.beginTransaction();
			
			//Puxa
			jogos = session.createQuery("from Jogo").list();
			
			
			
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}
		
		return jogos;
		
	}
}
