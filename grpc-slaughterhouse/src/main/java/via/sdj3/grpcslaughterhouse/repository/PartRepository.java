package via.sdj3.grpcslaughterhouse.repository;

import org.hibernate.annotations.Cascade;
import via.sdj3.grpcslaughterhouse.model.Part;
import org.springframework.data.repository.CrudRepository;

public interface PartRepository extends CrudRepository<Part, Integer>
{
}
