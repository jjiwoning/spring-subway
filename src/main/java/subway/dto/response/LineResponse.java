package subway.dto.response;

import java.util.List;
import java.util.stream.Collectors;
import subway.domain.Line;
import subway.domain.Station;

public class LineResponse {

    private Long id;
    private String name;
    private String color;
    private List<StationResponse> stations;

    private LineResponse() {
    }

    public LineResponse(Long id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public LineResponse(Long id, String name, String color, List<Station> stations) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.stations = stations.stream()
            .map(StationResponse::of)
            .collect(Collectors.toList());
    }

    public static LineResponse of(Line line) {
        return new LineResponse(line.getId(), line.getName(), line.getColor());
    }

    public static LineResponse of(Line line, List<Station> stations) {
        return new LineResponse(
            line.getId(),
            line.getName(),
            line.getColor(),
            stations
        );
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public List<StationResponse> getStations() {
        return stations;
    }
}
