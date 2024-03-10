package ma.enset.tp3.service;

import ma.enset.tp3.entities.Consultation;
import ma.enset.tp3.entities.Medecin;
import ma.enset.tp3.entities.Patient;
import ma.enset.tp3.entities.RendezVous;

public interface IHospital {
    Patient savePatient(Patient p);
    Medecin saveMedecin(Medecin m);
    RendezVous saveRendezVous(RendezVous r);
    Consultation saveConsultation(Consultation c);
}
