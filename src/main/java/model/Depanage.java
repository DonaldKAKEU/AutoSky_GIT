package model;

import lombok.Data;

import java.time.LocalDate;



@Data //permet d'ajouter les getter et setter de la classe grace a la librairie lombook
public class Depanage {

    private Long id;

    private Long immatVehicule;

    private Boolean statutDepanage;

    private Long cout;

    private LocalDate dateDebut;

    private LocalDate dateFin;
}
