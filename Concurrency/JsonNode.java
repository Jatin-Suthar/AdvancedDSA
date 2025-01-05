package Concurrency;

import java.util.Objects;

public class JsonNode {

    private boolean acknowledged = false;
    private String data;

    public JsonNode(String data) {
        this.data = data;
    }

    public void acknowledgedMessage() {
        this.acknowledged = true;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JsonNode{" +
                "acknowledged=" + acknowledged +
                ", data='" + data + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JsonNode jsonNode = (JsonNode) o;
        return acknowledged == jsonNode.acknowledged && Objects.equals(data, jsonNode.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(acknowledged, data);
    }
}
