package repositories;

import model.Cliente;
import model.Venda;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO {
    public EntityManager getEM(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("automacaocomercial");
        return entityManagerFactory.createEntityManager();
    }

    public Venda salvarVenda(Venda venda){
        EntityManager em = getEM();
        try {
            em.getTransaction().begin();
            if (venda.getId() == null) {
                em.persist(venda);
            } else {
                venda = em.merge(venda);
            }
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
        }
        finally {
            em.close();
        }
        return venda;
    }

    public Venda deletarVenda(Integer id){
        EntityManager em = getEM();
        Venda venda = em.find(Venda.class, id);
        try {
            em.getTransaction().begin();
            em.remove(venda);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return venda;
    }

    public Venda consultarVenda(Integer id){
        EntityManager em = getEM();
        Venda venda = null;
        try {
            venda = em.find(Venda.class, id);
        } finally {
            em.close();
        }
        return venda;
    }

    public List<Venda> listarVendas(){
        EntityManager em = getEM();
        List<Venda> vendas;
        try {
            Query consulta = em.createQuery("select v FROM Venda v");
            vendas = consulta.getResultList();
        } catch (Exception e){
            vendas = new ArrayList<>();
        } finally {
            em.close();
        }
        return vendas;
    }
}
