package BL.Entities;

public class Model {
    private String id;
    private String modelName;

    public Model(String id, String modelName) {
        this.id = id;
        this.modelName = modelName;
    }

    public String getId() {
        return id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id='" + id + '\'' +
                ", modelName='" + modelName + '\'' +
                '}';
    }
}
