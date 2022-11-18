package cz.czechitas.java2webapps.ukol6;

import org.springframework.data.repository.CrudRepository;
import cz.czechitas.java2webapps.ukol6.entity.Vizitka;
import org.springframework.stereotype.Repository;

@Repository
public interface VizitkaRepository extends CrudRepository<Vizitka, Long> {
}
