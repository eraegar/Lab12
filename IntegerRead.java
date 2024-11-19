
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IntegerRead {
    private static int divideFromFile(String inputFile) throws RuntimeException, IOException {
        try(FileInputStream in = new FileInputStream(inputFile)) {
            byte[] buffer = new byte[in.available()];
            in.read(buffer, 0, buffer.length);

            String[] input = new String(buffer).split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            return a / b;
        } catch(FileNotFoundException e) {
            System.out.println("input file does not found");
            throw new FileNotFoundException(e.getMessage());
        } catch(NumberFormatException e) {
            System.out.println("error during parsing integer");
            throw new NumberFormatException(e.getMessage());
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("file has less than two integers");
            throw new ArrayIndexOutOfBoundsException(e.getMessage());
        } catch(ArithmeticException e) {
            System.out.println("divide by zero");
            throw new ArithmeticException(e.getMessage());
        } catch(IOException e) {
            System.out.println("error during I/O operations");
            throw new IOException(e.getMessage());
        } catch(Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("unknown error");
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println(divideFromFile("input.txt"));
        } catch (Exception e) {
            System.out.println("Error during running the app: " + e.getMessage());
        }
    }
}
