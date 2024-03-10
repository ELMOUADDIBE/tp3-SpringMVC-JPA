package ma.enset.tp3.service;

import ma.enset.tp2hibernatejpaspring.entities.Consultation;
import ma.enset.tp2hibernatejpaspring.entities.Medecin;
import ma.enset.tp2hibernatejpaspring.entities.Patient;
import ma.enset.tp2hibernatejpaspring.entities.RendezVous;

public interface IHospital {
    Patient savePatient(Patient p);
    Medecin saveMedecin(Medecin m);
    RendezVous saveRendezVous(RendezVous r);
    Consultation saveConsultation(Consultation c);
}
