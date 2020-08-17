package ma.mic.sic.budgetaire.entity.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ma.mic.sic.budgetaire.entity.Marche;
import ma.mic.sic.budgetaire.repository.MarcheRepository;

@RestController
@RequestMapping(value = "marches")
@CrossOrigin(origins = "http://localhost:4200")
public class MarcheController {
	@Autowired
	private MarcheRepository marcheRepository;

	@PostMapping("/save")
	public void Save(@RequestBody Marche marche) {
		marcheRepository.save(marche);
	}

	@DeleteMapping("/delete/{idMarche}")
	public void Delete(@PathVariable(required = true) String idMarche) {
		Marche marche = marcheRepository.findById(Integer.parseInt(idMarche));
		marcheRepository.delete(marche);
	}

	@GetMapping("/all")
	public List<Marche> findAll() {
		return marcheRepository.findAll();
	}
	
	
	/*@PutMapping("/marche/{idMarche}")
	public Marche updateMarche(@PathVariable(required = true) String idMarche,@Valid @RequestBody Marche marcheDetail) {
		Marche marche = marcheRepository.findById(Integer.parseInt(idMarche));
		marche.setIdMarche(marcheDetail.getIdMarche());
		marche.setNomMarche(marcheDetail.getNomMarche());
		marcheRepository.save(marche);
	}
	*/
	
	/*
	 @PutMapping("/notes/{id}")
public Note updateNote(@PathVariable(value = "id") Long noteId,
                                        @Valid @RequestBody Note noteDetails) {

    Note note = noteRepository.findById(noteId);
            

    note.setTitle(noteDetails.getTitle());
    note.setContent(noteDetails.getContent());

   noteRepository.save(note);
   
}




// Delete a Note
@DeleteMapping("/notes/{id}")
public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
    Note note = noteRepository.findById(noteId)
            .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

    noteRepository.delete(note);

    return ResponseEntity.ok().build();
}
	
	
	@DeleteMapping("/delete/{idMarche}")
	public void Delete(@PathVariable(required = true) String idMarche) {
		Marche marche = marcheRepository.findById(Integer.parseInt(idMarche));
		marcheRepository.delete(marche);
	} */
	

}

