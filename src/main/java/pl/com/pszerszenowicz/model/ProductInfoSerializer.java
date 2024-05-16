package pl.com.pszerszenowicz.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;

public class ProductInfoSerializer implements Serializer<ProductInfo> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(String s, ProductInfo productInfo) {
        try {
            if (productInfo == null) {
                System.out.println("Null received at serializing");
                return null;
            }
            System.out.println("Serializing...");
            return objectMapper.writeValueAsBytes(productInfo);
        } catch (Exception e) {
            System.out.println("Error when serializing productInfo to byte[]");
            return null;
        }
    }
}
