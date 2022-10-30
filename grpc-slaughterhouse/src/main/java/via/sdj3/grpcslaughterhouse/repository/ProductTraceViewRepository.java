package via.sdj3.grpcslaughterhouse.repository;

import via.sdj3.grpcslaughterhouse.model.ProductTrace;

import java.util.List;

public interface ProductTraceViewRepository extends
        ReadOnlyRepository<ProductTrace, Integer>
{
    List<ProductTrace> findProductTracesByProductId(int productId);
    List<ProductTrace> findProductTraceByAnimalId(int animalId);// TODO: 30-10-2022 Explain
}
