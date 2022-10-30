package via.sdj3.grpcslaughterhouse.model;

import java.io.Serializable;

public class ProductTraceId implements Serializable {
    private int productId;
    private int trayId;
    private int partId;

    public ProductTraceId() {
    }

    public ProductTraceId(int productId, int trayId, int partId) {
        this.productId = productId;
        this.trayId = trayId;
        this.partId = partId;
    }
}
