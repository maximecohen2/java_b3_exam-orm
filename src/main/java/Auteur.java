import javax.persistence.*;

@Entity
public class Auteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(length = 60, nullable = false)
    private String name;

    @Basic
    @Column(length = 60, nullable = false)
    private String speciality;

    @ManyToOne
    private CentreRecherche centreRecherche;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public CentreRecherche getCentreRecherche() {
        return centreRecherche;
    }

    public void setCentreRecherche(CentreRecherche centreRecherche) {
        this.centreRecherche = centreRecherche;
    }
}
