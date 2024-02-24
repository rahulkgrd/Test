import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordFrequency {
    public static void main(String[] args) {
        String str =  "John writes about this, and John Doe writes about that and John Wayne writes about everything John";
        Map<String, Long> map = frequencyMap(str);
        long maxFrq= map.values().stream().max(Comparator.naturalOrder()).get();
        System.out.println(map.entrySet().stream().filter(x->x.getValue()==maxFrq).map(Map.Entry::getKey).collect(Collectors.toList()));
    }
    static Map<String ,Long> frequencyMap(String s){
        return Arrays.stream(s.split(" ")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
    }

    static long wordFrequency(String word){
        String str =  "WASHINGTON: Leaders of the largest US chipmakers told Biden officials that the administration should study the impact of restrictions on exports to China and pause before implementing new ones, according to people familiar with their discussions." +
                "During meetings in Washington, Intel Corp’s Pat Gelsinger, Nvidia Corp’s Jensen Huang and Qualcomm Inc’s Cristiano Amon warned that export controls risk harming US leadership of the industry. The Biden officials listened to the presentations but " ;
        String pattern = ".*?\\b"+word+"\\b.*?";
        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher(str);
        long count=0;
        while (matcher.find()){
            count++;
        }
        return count;
    }
}
