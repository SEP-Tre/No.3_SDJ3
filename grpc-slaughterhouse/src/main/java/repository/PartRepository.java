package repository;

import model.Part;
import org.springframework.data.repository.CrudRepository;

public interface PartRepository extends CrudRepository<Part, Integer>
{
}
