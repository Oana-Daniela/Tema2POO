//Puisor Oana-Daniela
//Grupa 321 CD
public final class Diamond implements Shape {

    private String variables;

    public void setVariables(final String variables) {
        this.variables = variables;
    }

    public String getVariables() {
        return variables;
    }


    @Override
    public void accept(final Visitor visitor) {
    }
}
