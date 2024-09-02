package repository;

import entity.Chien;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.SessionFactorySingleton;
import org.hibernate.query.Query;


import java.util.ArrayList;
import java.util.List;

public class ChienRepository {

    // ---------- Propriétés ----------

    private final SessionFactory sessionFactory;
    private Session session;


    // ---------- Constructeur : ----------

    public ChienRepository() {
        sessionFactory = SessionFactorySingleton.getSessionFactory();
    }


    // ---------- Méthodes : ----------

    /**
     * Ajouter ou mettre à jour un chien
     */
    public Chien createOrUpdate(Chien chien) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.saveOrUpdate(chien);
            session.getTransaction().commit();
            return chien;
        }
        catch (Exception ex) {
            session.getTransaction().rollback();
            return null;
        }
        finally {
            session.close();
        }
    }


    /**
     * Effacer un chien
     */
    public boolean delete(Chien chien) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(chien);
            session.getTransaction().commit();
            return true;
        }
        catch (Exception ex) {
            session.getTransaction().rollback();
            return false;
        }
        finally {
            session.close();
        }
    }


    /**
     * Obtenir un chien
     */
    public Chien getById(int id) {
        session = sessionFactory.openSession();
        Chien chien = session.get(Chien.class, id);
        session.close();
        return chien;
    }


    /**
     * Obtenir tous les chiens
     */
    public List<Chien> getAll() {
        session = sessionFactory.openSession();
        List<Chien> chiens = session.createQuery("from Chien", Chien.class).list();
        session.close();
        return chiens;
    }


    /**
     * Rechercher des chiens par leur nom
     */
    public List<Chien> findByNom(String nom) {
        List<Chien> chiens = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();

            // Requête pour chercher les chiens dont le nom correspond
            Query<Chien> query = session.createQuery("FROM Chien WHERE nom LIKE :nom", Chien.class);
            query.setParameter("nom", "%" + nom + "%"); // Utilisation de LIKE pour une recherche partielle

            chiens = query.list();
            session.getTransaction().commit();
        }
        catch (Exception ex) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
        return chiens;
    }


}
