package via.sdj3.grpcslaughterhouse.repository;

import via.sdj3.grpcslaughterhouse.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer>
{
}
