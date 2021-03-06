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
import ma.mic.sic.budgetaire.entity.Orientation;
import ma.mic.sic.budgetaire.repository.OrientationRepository;


@RestController
@RequestMapping(value = "orientations")
@CrossOrigin(origins = "http://localhost:4200")
public class OrientationController {
	@Autowired
	private OrientationRepository orientationRepository;

	@PostMapping("/save")
	public void Save(@RequestBody Orientation orientation) {
		orientationRepository.save(orientation);
	}

	@DeleteMapping("/delete/{numOrientation}")
	public void Delete(@PathVariable(required = true) String numOrientation) {
		Orientation orientation = orientationRepository.findById(Integer.parseInt(numOrientation));
		orientationRepository.delete(orientation);
	}

	@GetMapping("/all")
	public List<Orientation> findAll() {
		return orientationRepository.findAll();
	}
	


}
