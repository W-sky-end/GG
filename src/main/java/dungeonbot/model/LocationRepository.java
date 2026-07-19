package dungeonbot.model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocationRepository {

    private final Map<String, Location> locations = new HashMap<>();

    public LocationRepository() {
        loadLocations();
    }

    private void loadLocations() {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("locations.json")) {
            if (input == null) {
                throw new IllegalStateException("Файл locations.json не найден в resources!");
            }
            List<Location> loadedLocations = mapper.readValue(input, mapper.getTypeFactory().constructCollectionType(List.class, Location.class));
            for (Location location : loadedLocations) {
                locations.put(location.getId(), location);
            }
        } catch (IOException e) {
            throw new RuntimeException("Ошибка загрузки локаций", e);
        }
    }

    public Location getById(String id) {
        return locations.get(id);
    }
}