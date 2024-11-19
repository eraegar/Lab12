import java.io.*;
import java.net.*;

public class Web_parse {
    public static void saveImage(String imageUrl) {
        InputStream is = null;
        OutputStream os = null;

        try {
            // Use URI to handle better URL construction
            URI uri = new URI(imageUrl);
            URL url = uri.toURL(); // Convert to URL
            String filename = url.getFile();
            String destName = "./figures" + filename.substring(filename.lastIndexOf("/"));
            System.out.println(destName);

            is = url.openStream();
            os = new FileOutputStream(destName);

            byte[] buffer = new byte[2048];
            int length;

            while ((length = is.read(buffer)) != -1) {
                os.write(buffer, 0, length);
            }

        } catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Exception: " + e.getMessage());
        } catch (URISyntaxException e) {
            System.out.println("URI Syntax Exception: " + e.getMessage());
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    System.out.println("Failed to close input stream: " + e.getMessage());
                }
            }

            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    System.out.println("Failed to close output stream: " + e.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) {
        // Provide a valid URL to test
        saveImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTc9APxkj0xClmrU3PpMZglHQkx446nQPG6lA&s");
    }
}
