package tipolt.andre.backend.models.enums;

public enum CategoryEnum {
    BACK_END("Back-End"),
    FRONT_END("Front-End");

    private String value;

    CategoryEnum(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    @Override
    public String toString(){
        return value;
    }
}
