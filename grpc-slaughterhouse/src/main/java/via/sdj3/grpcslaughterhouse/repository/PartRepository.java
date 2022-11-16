package via.sdj3.grpcslaughterhouse.repository;

import org.hibernate.annotations.Cascade;
import via.sdj3.grpcslaughterhouse.model.Part;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PartRepository extends CrudRepository<Part, Integer>
{
    List<Part> findAllByAnimalId(int id);
}
