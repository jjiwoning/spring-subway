package subway.domain;

import static org.springframework.util.StringUtils.*;

import java.util.Objects;

public class Line {

    private Long id;
    private String name;
    private String color;

    public Line() {
    }

    public Line(String name, String color) {
        validateLine(name, color);
        this.name = name;
        this.color = color;
    }

    private void validateLine(String name, String color) {
        if (!hasText(name) || !hasText(color)) {
            throw new IllegalArgumentException("이름, 색상은 반드시 입력해야합니다.");
        }
    }

    public Line(Long id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Line line = (Line) o;
        return Objects.equals(id, line.id)
            && Objects.equals(name, line.name)
            && Objects.equals(color, line.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, color);
    }

    @Override
    public String toString() {
        return "Line{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", color='" + color + '\'' +
            '}';
    }
}
