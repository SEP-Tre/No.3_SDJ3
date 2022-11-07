package via.sdj3.grpcslaughterhouse.repository;

import org.springframework.data.repository.CrudRepository;
import via.sdj3.grpcslaughterhouse.model.Animal;

public interface AnimalRepository extends CrudRepository<Animal, Integer>
{
}
