package ma.mic.sic.budgetaire.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Projet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProjet;
	private String libelle;
	private String finalite;
	@Temporal(TemporalType.DATE)
	private Date demaragePrevue; 
	@Temporal(TemporalType.DATE)
	private Date demarageReelle;
	@Temporal(TemporalType.DATE)
	private Date RealisationPrevue;
	@Temporal(TemporalType.DATE)
	private Date RealisationReelle;
	private double budgetRealisation;
	private double contributionBudgetFinanc;
	private double budgetConsomme;
	private double etatAvancementTheorique;
	private double etatAvancementReelle;
	private String description;
	private String source;
	
	@ManyToOne
	private Programme programme;
	/*@OneToMany (mappedBy = "projetp",cascade = CascadeType.ALL)
    private List<Personnel> personnel;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Partenaire> partenaires;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Sponsor> spnosors;
	
	@ManyToOne
	private Perimetre perimetre;
	@ManyToOne
	private Service service;
	@ManyToOne
	private StatutProjet statutProjet;
	@OneToMany (mappedBy = "projet",fetch = FetchType.EAGER)
    private List<Indicateur> indicateur;
	@ManyToOne
	private SourceBudget sourceBudget;*/
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "marche_id", referencedColumnName = "idMarche")
	private Marche  marche;
	
	public Projet() {
		super();
	}
	public Projet(int idProjet, String libelle, String finalite, Date demaragePrevue, Date demarageReelle,
			Date realisationPrevue, Date realisationReelle, double budgetRealisation, double contributionBudgetFinanc,
			double budgetConsomme, double etatAvancementTheorique, double etatAvancementReelle, String description,
			String source) {
		super();
		this.idProjet = idProjet;
		this.libelle = libelle;
		this.finalite = finalite;
		this.demaragePrevue = demaragePrevue;
		this.demarageReelle = demarageReelle;
		RealisationPrevue = realisationPrevue;
		RealisationReelle = realisationReelle;
		this.budgetRealisation = budgetRealisation;
		this.contributionBudgetFinanc = contributionBudgetFinanc;
		this.budgetConsomme = budgetConsomme;
		this.etatAvancementTheorique = etatAvancementTheorique;
		this.etatAvancementReelle = etatAvancementReelle;
		this.description = description;
		this.source = source;
	}
	public int getIdProjet() {
		return idProjet;
	}
	public void setIdProjet(int idProjet) {
		this.idProjet = idProjet;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getFinalite() {
		return finalite;
	}
	public void setFinalite(String finalite) {
		this.finalite = finalite;
	}
	public Date getDemaragePrevue() {
		return demaragePrevue;
	}
	public void setDemaragePrevue(Date demaragePrevue) {
		this.demaragePrevue = demaragePrevue;
	}
	public Date getDemarageReelle() {
		return demarageReelle;
	}
	public void setDemarageReelle(Date demarageReelle) {
		this.demarageReelle = demarageReelle;
	}
	public Date getRealisationPrevue() {
		return RealisationPrevue;
	}
	public void setRealisationPrevue(Date realisationPrevue) {
		RealisationPrevue = realisationPrevue;
	}
	public Date getRealisationReelle() {
		return RealisationReelle;
	}
	public void setRealisationReelle(Date realisationReelle) {
		RealisationReelle = realisationReelle;
	}
	public double getBudgetRealisation() {
		return budgetRealisation;
	}
	public void setBudgetRealisation(double budgetRealisation) {
		this.budgetRealisation = budgetRealisation;
	}
	public double getContributionBudgetFinanc() {
		return contributionBudgetFinanc;
	}
	public void setContributionBudgetFinanc(double contributionBudgetFinanc) {
		this.contributionBudgetFinanc = contributionBudgetFinanc;
	}
	public double getBudgetConsomme() {
		return budgetConsomme;
	}
	public void setBudgetConsomme(double budgetConsomme) {
		this.budgetConsomme = budgetConsomme;
	}
	public double getEtatAvancementTheorique() {
		return etatAvancementTheorique;
	}
	public void setEtatAvancementTheorique(double etatAvancementTheorique) {
		this.etatAvancementTheorique = etatAvancementTheorique;
	}
	public double getEtatAvancementReelle() {
		return etatAvancementReelle;
	}
	public void setEtatAvancementReelle(double etatAvancementReelle) {
		this.etatAvancementReelle = etatAvancementReelle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public Programme getProgramme() {
		return programme;
	}
	public void setProgramme(Programme programme) {
		this.programme = programme;
	}
	/*public SourceBudget getSourceBudget() {
		return sourceBudget;
	}
	public void setSourceBudget(SourceBudget sourceBudget) {
		this.sourceBudget = sourceBudget;
	}*/
	/*public List<Personnel> getPersonnel() {
		return personnel;
	}
	public void setPersonnel(List<Personnel> personnel) {
		this.personnel = personnel;
	}
	public StatutProjet getStatutProjet() {
		return statutProjet;
	}
	public void setStatutProjet(StatutProjet statutProjet) {
		this.statutProjet = statutProjet;
	}
	public List<Indicateur> getIndicateur() {
		return indicateur;
	}
	public void setIndicateur(List<Indicateur> indicateur) {
		this.indicateur = indicateur;
	}
	public List<Partenaire> getPartenaires() {
		return partenaires;
	}
	public void setPartenaires(List<Partenaire> partenaires) {
		this.partenaires = partenaires;
	}
	public Perimetre getPerimetre() {
		return perimetre;
	}
	public void setPerimetre(Perimetre perimetre) {
		this.perimetre = perimetre;
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}*/
	public Marche getMarche() {
		return marche;
	}
	public void setMarche(Marche marche) {
		this.marche = marche;
	}
	/*public List<Personnel> getPersonnel() {
		return personnel;
	}
	public void setPersonnel(List<Personnel> personnel) {
		this.personnel = personnel;
	}
	public List<Sponsor> getSpnosors() {
		return spnosors;
	}
	public void setSpnosors(List<Sponsor> spnosors) {
		this.spnosors = spnosors;
	}*/
}
	
	
	
	
	
	
	
	
	



