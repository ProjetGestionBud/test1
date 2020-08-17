package ma.mic.sic.budgetaire.entity.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ma.mic.sic.budgetaire.entity.Projet;
import ma.mic.sic.budgetaire.repository.ProjetRepository;


@RestController
@RequestMapping(value = "projets")
@CrossOrigin(origins = "http://localhost:4200")
public class ProjetController {
	
	@Autowired
	private ProjetRepository projetRepository;

	@PostMapping("/save")
	public void Save(@RequestBody Projet projet) {
		projetRepository.save(projet);
	}

	@DeleteMapping("/delete/{idProjet}")
	public void Delete(@PathVariable(required = true) String idProjet) {
		Projet projet = projetRepository.findById(Integer.parseInt(idProjet));
		projetRepository.delete(projet);
	}

	@GetMapping("/all")
	public List<Projet> findAll() {
		return projetRepository.findAll();
	}

}

