// ==================== Avec BDD ====================

package entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
//@AllArgsConstructor
@SuperBuilder
public class Chien {

    // ----- Propriétés -----

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;

    private String race;

    private LocalDate dateNaissance;


    // ----- Constructeur -----

    public Chien(String nom, String race, LocalDate dateNaissance) {
        this.nom = nom;
        this.race = race;
        this.dateNaissance = dateNaissance;
    }


    // Getters/Setters gérés par hibernate


}
