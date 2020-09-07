import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GrammarExercise {
    public static void main(String[] args) {
        //需要从命令行读入
        Scanner scanner = new Scanner(System.in);
        String firstWordList = scanner.nextLine();
        String secondWordList = scanner.nextLine();

        List<String> result = findCommonWordsWithSpace(firstWordList,secondWordList);
        //按要求输出到命令行
        System.out.println(result);
    }

    public static List<String> findCommonWordsWithSpace(String firstWordList, String secondWordList) {
        //在这编写实现代码
//        String newString = firstWordList.concat(",").concat(secondWordList);
        String[] strings1 = firstWordList.split(",");
        String[] strings2 = secondWordList.split(",");
        List<String> stringList = Arrays.stream(strings1)
                .peek(s -> {if(s.equals("") || !s.matches("[a-zA-Z]+"))throw new RuntimeException();})
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        return Arrays.stream(strings2)
                .map(String::toUpperCase)
                .peek(s -> {if(s.equals("") || !s.matches("[a-zA-Z]+"))throw new RuntimeException();})
                .filter(s -> stringList.contains(s))
                .sorted()
                .map(s -> String.join(" ",s.split("")))
                .collect(Collectors.toList());
    }
}
