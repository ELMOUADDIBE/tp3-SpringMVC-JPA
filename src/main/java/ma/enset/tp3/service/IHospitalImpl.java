package ma.enset.tp3.service;

import jakarta.transaction.Transactional;
import ma.enset.tp3.entities.Consultation;
import ma.enset.tp3.entities.Medecin;
import ma.enset.tp3.entities.Patient;
import ma.enset.tp3.entities.RendezVous;
import ma.enset.tp3.repository.ConsulatationRepository;
import ma.enset.tp3.repository.MedecinRepository;
import ma.enset.tp3.repository.PatientRepository;
import ma.enset.tp3.repository.RendezVousRepository;
import org.springframework.stereotype.Service;

@Service @Transactional
public class IHospitalImpl implements IHospital {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsulatationRepository consulatationRepository;

    public IHospitalImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsulatationRepository consulatationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consulatationRepository = consulatationRepository;
    }

    @Override
    public Patient savePatient(Patient p) {
        return patientRepository.save(p);
    }

    @Override
    public Medecin saveMedecin(Medecin m) {
        return medecinRepository.save(m);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous r) {
        return rendezVousRepository.save(r);
    }

    @Override
    public Consultation saveConsultation(Consultation c) {
        return consulatationRepository.save(c);
    }
}
