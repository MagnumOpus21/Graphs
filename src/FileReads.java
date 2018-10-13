import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReads {
    public static void main(String []args) throws IOException {
        List<String> fileContent = Files.readAllLines(Paths.get("/home/daryl/F18/CS670/Quizzes/hw00.tex"), Charset.forName("ISO-8859-1"));
        for (String line : fileContent) {
            System.out.println(line);
        }
        BufferedReader fBuffer = new BufferedReader(new FileReader("/home/daryl/F18/CS670/Quizzes/Q4/hw04.tex"));
//        String lineContent = "";
//        System.out.println("Is the file ready: " + fBuffer.ready());
//        while ((lineContent = fBuffer.readLine()) != null) {
//            System.out.println(lineContent);
//        }
        Stream<String> fileContentStream = fBuffer.lines();
        List<String> streamCollect = fileContentStream.filter(line-> !line.isEmpty()).
                filter(line -> Character.isLetter(line.charAt(0))).collect(Collectors.toList());
        System.out.println("Get the lines that start with a letter");
        streamCollect.forEach(e -> System.out.println(e));
    }
}
