public abstract class Pet {
    private String name;

    public void setName(String aName) {
        name = aName;
    }

    public String getName() {
        return name;
    }

    public abstract boolean canFly();

    public abstract String classOfAnimal();
}
