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
import ma.mic.sic.budgetaire.entity.Programme;
import ma.mic.sic.budgetaire.repository.ProgrammeRepository;

@RestController
@RequestMapping(value = "programmes")
@CrossOrigin(origins = "http://localhost:4200")
public class ProgrammeController {
	@Autowired
	private ProgrammeRepository programmeRepository;

	@PostMapping("/save")
	public void Save(@RequestBody Programme programme) {
		programmeRepository.save(programme);
	}

	@DeleteMapping("/delete/{numProgramme}")
	public void Delete(@PathVariable(required = true) String numProgramme) {
		Programme programme = programmeRepository.findById(Integer.parseInt(numProgramme));
		programmeRepository.delete(programme);
	}

	@GetMapping("/all")
	public List<Programme> findAll() {
		return programmeRepository.findAll();

	}
}
