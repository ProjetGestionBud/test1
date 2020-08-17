package ma.mic.sic.budgetaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ma.mic.sic.budgetaire.entity.Projet;
@Repository
public interface ProjetRepository extends JpaRepository<Projet,Integer> {
	Projet findById(int idProjet);


}
