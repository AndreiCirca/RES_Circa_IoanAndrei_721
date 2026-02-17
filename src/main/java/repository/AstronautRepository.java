package repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Astronaut;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class AstronautRepository {


    private final String filePath;
    private final ObjectMapper objectMapper;


    public AstronautRepository(String filePath) {
        this.filePath = filePath;
        this.objectMapper = new ObjectMapper();
    }


    public List<Astronaut> getAllAstronauts() {
        try {
            return objectMapper.readValue(
                    new File(filePath),
                    new TypeReference<List<Astronaut>>() {}
            );
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    // 4)
    public void saveAstronauts(List<Astronaut> astronauts) {
        try (FileWriter writer = new FileWriter("src/data/astronauts_sorted.txt")) {
            for (Astronaut astronaut : astronauts) {
                writer.write(astronaut.toString() + "\n");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


}
