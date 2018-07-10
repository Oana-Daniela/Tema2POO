//Puisor Oana-Daniela
//Grupa 321 CD
public final class Circle implements Shape {

    private String variables;

    public void setVariables(final String variablesFin) {
        variables = variablesFin;
    }

    public String getVariables() {
        return variables;
    }


    @Override
    public void accept(final Visitor visitor) {
    }
}
