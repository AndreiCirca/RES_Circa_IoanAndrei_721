package repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Supply;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SupplyRepository {


    private final String filePath;
    private final ObjectMapper objectMapper;


    public SupplyRepository(String filePath) {
        this.filePath = filePath;
        this.objectMapper = new ObjectMapper();
    }


    public List<Supply> getAllSupplies() {
        try {
            return objectMapper.readValue(
                    new File(filePath),
                    new TypeReference<List<Supply>>() {}
            );
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}
