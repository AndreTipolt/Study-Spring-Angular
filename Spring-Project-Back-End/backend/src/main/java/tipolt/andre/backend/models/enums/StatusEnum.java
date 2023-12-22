package tipolt.andre.backend.models.enums;

public enum StatusEnum {
    ACTIVATE("Ativo"), INACTIVE("Inativo");

    private String value;

    private StatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString(){
        return value;
    }
}
