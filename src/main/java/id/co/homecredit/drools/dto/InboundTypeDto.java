package id.co.homecredit.drools.dto;

public class InboundTypeDto {

    private Type type;
    private Integer response;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Integer getResponse() {
        return response;
    }

    public void setResponse(int response) {
        this.response = response;
    }

    public enum Type{
        JFS,
        NONJFS
    }


    public Type findType(String name) {
        for (Type suit : Type.values()) {
            if (name.equals(suit.name())) {
                return suit;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "InboundTypeDto{" +
                "type=" + type +
                ", response='" + response + '\'' +
                '}';
    }
}
