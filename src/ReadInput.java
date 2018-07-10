//Puisor Oana-Daniela
//Grupa 321 CD
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ReadInput {
    private String inputFilename;
    int numberShapes;
    String[] shapeStrings;

    public ReadInput() {

    }

    public ReadInput(int numberShapesP, final String[] shapeStringsP) {
        this.numberShapes = numberShapesP;
        this.shapeStrings = shapeStringsP;
    }

    /**
     *
     * @param inputFilenameP
     */
    public void setInput(String inputFilenameP) {
        this.inputFilename = inputFilenameP;
    }

    /**
     *
     * @return
     */
    public String getStringInputName() {
        return this.inputFilename;
    }

    /**
     *
     * @param number_shapes
     * @param shape_strings
     * @return
     */
    public ReadInput readTheFile(int numberShapes, final String[] shapeStringsP) {

        String filename1 = getStringInputName();
        FileReader file1 = null;

        try {
            file1 = new FileReader(filename1);
        } catch (FileNotFoundException e) {

            e.printStackTrace();
            System.out.println("Eroare la deschidere");
        }

        Scanner sc = new Scanner(file1);

        numberShapes = sc.nextInt();
        shapeStrings = new String[numberShapes + 1];

        int k = 0;
        while (sc.hasNext() && k <= numberShapes) {
            shapeStrings[k] = sc.nextLine();
            k++;
        }

        try {
            sc.close();
            file1.close();
        } catch (Exception exception2) {
            System.out.println("Eroare la inchidere");
        }

        ReadInput inp = new ReadInput(numberShapes, shapeStrings);
        return inp;
    }

}
