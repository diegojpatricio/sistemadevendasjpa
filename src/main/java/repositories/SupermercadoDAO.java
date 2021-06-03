package repositories;

import model.Cliente;
import model.Supermercado;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class SupermercadoDAO {

    public EntityManager getEM(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("automacaocomercial");
        return entityManagerFactory.createEntityManager();
    }

    public Supermercado salvarSupermercado(Supermercado sp){
        EntityManager em = getEM();
        try {
            em.getTransaction().begin();
            if (sp.getId() == null) {
                em.persist(sp);
            } else {
                sp = em.merge(sp);
            }
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
        }
        finally {
            em.close();
        }
        return sp;
    }

    public Supermercado deletarSupermercado(Integer id){
        EntityManager em = getEM();
        Supermercado sp = em.find(Supermercado.class, id);
        try {
            em.getTransaction().begin();
            em.remove(sp);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return sp;
    }

    public Supermercado consultarSupermercado(Integer id){
        EntityManager em = getEM();
        Supermercado sp = null;
        try {
            sp = em.find(Supermercado.class, id);
        } finally {
            em.close();
        }
        return sp;
    }

    public List<Supermercado> listarSupermercados(){
        EntityManager em = getEM();
        List<Supermercado> sp;
        try {
            Query consulta = em.createQuery("select sp FROM Supermercado sp");
            sp = consulta.getResultList();
        } catch (Exception e){
            sp = new ArrayList<>();
        } finally {
            em.close();
        }
        return sp;
    }

}
