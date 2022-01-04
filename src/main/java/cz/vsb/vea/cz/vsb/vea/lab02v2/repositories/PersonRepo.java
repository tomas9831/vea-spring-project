package cz.vsb.vea.cz.vsb.vea.lab02v2.repositories;

import cz.vsb.vea.cz.vsb.vea.lab02v2.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface
PersonRepo extends JpaRepository<Person, Long> {
}
