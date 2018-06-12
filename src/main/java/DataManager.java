import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class DataManager {
    private EntityManagerFactory emf;

    public DataManager(String persistenceUnit) {
        this.emf = Persistence.createEntityManagerFactory(persistenceUnit);
    }

    private void addObject(Object o) {
        EntityManager entityManager = this.emf.createEntityManager();
        entityManager.getTransaction().begin();
        boolean successTransaction = false;
        try {
            entityManager.persist(o);
            successTransaction = true;
        } finally {
            if (successTransaction) {
                entityManager.getTransaction().commit();
            } else {
                entityManager.getTransaction().rollback();
            }
            entityManager.close();
        }
    }

    public CentreRecherche findCentreRecherche(String name) {
        EntityManager entityManager = this.emf.createEntityManager();
        entityManager.getTransaction().begin();
        CentreRecherche centreRecherche = null;
        boolean successTransaction = false;
        try {
            centreRecherche = entityManager
                    .createQuery("SELECT i FROM CentreRecherche i WHERE i.name = :name", CentreRecherche.class)
                    .setParameter("name", name)
                    .getSingleResult();
                    successTransaction = true;
        } finally {
            if (successTransaction) {
                entityManager.getTransaction().commit();
            } else {
                entityManager.getTransaction().rollback();
            }
            entityManager.close();
        }
        return centreRecherche;
    }

    public void addCentreRecherche(String name, String country) {
        CentreRecherche centreRecherche = new CentreRecherche();
        centreRecherche.setName(name);
        centreRecherche.setCountry(country);
        this.addObject(centreRecherche);
    }

    public void addCentreRecherche(CentreRecherche centreRecherche) {
        this.addObject(centreRecherche);
    }

    public void addAuteur(String name, String speciality, CentreRecherche centreRecherche) {
        Auteur auteur = new Auteur();
        auteur.setName(name);
        auteur.setSpeciality(speciality);
        auteur.setCentreRecherche(centreRecherche);
        this.addObject(auteur);
    }

    public void close() {
        emf.close();
    }
}
