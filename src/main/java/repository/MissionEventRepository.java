package repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.MissionEvent;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MissionEventRepository {


    private final String filePath;
    private final ObjectMapper objectMapper;


    public MissionEventRepository(String filePath) {
        this.filePath = filePath;
        this.objectMapper = new ObjectMapper();
    }


    public List<MissionEvent> getAllMissionEvents() {
        try {
            return objectMapper.readValue(
                    new File(filePath),
                    new TypeReference<List<MissionEvent>>() {}
            );
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}
