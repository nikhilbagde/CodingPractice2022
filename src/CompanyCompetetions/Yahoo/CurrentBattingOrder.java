package CompanyCompetetions.Yahoo;

import java.util.*;

/**
 * Created by Nikhi on 11/29/2016.
 */
public class CurrentBattingOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = null;
        LinkedHashMap<Integer, LinkedHashMap<Integer,String>> mapAll = new LinkedHashMap<>();
        LinkedHashMap<Integer, String> mapHome = new LinkedHashMap<>();
        //LinkedHashMap<Integer, String> mapAway = new LinkedHashMap<>();
        //while(!( s = sc.nextLine()).equals("")){
        while(!(s = sc.nextLine()).equals("")){
            String [] array = s.split(",");
            List<Integer> list = new ArrayList<>();
            list.add(Integer.parseInt(array[1]));
            //int rank = Integer.parseInt(s.substring(s.length()-3,s.length()-2));
            int rank = Integer.parseInt(array[4]);
            if(list.size() >2 && !Objects.equals(list.get(list.size() - 1), list.get(list.size() - 2))) {
                mapHome = new LinkedHashMap<>();
            }else {
                mapHome.put(rank, s);
            }
            if(!mapAll.containsKey(Integer.parseInt(array[1]))){
                mapAll.put(Integer.parseInt(array[1]), mapHome);
            }else {
                mapAll.replace(Integer.parseInt(array[1]), mapHome);
            }


        }
        System.out.println(mapAll);
        for ( LinkedHashMap<Integer, String> entry : mapAll.values()) {
            for ( String ss: entry.values()){
                System.out.println(ss.substring(0,ss.length()-2));
            }
        }/*
        for ( String ss: mapHome.values()){
            System.out.println(ss.substring(0,ss.length()-2));
        }*/
    }
}
/*
"C:\Program Files\JavaReview\jdk1.8.0_102\bin\java" -Didea.launcher.port=7539 "-Didea.launcher.bin.path=C:\Program Files (x86)\JetBrains\IntelliJ IDEA Community Edition 2016.2.4\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\JavaReview\jdk1.8.0_102\jre\lib\charsets.jar;C:\Program Files\JavaReview\jdk1.8.0_102\jre\lib\deploy.jar;C:\Program Files\JavaReview\jdk1.8.0_102\jre\lib\ext\access-bridge-64.jar;C:\Program Files\JavaReview\jdk1.8.0_102\jre\lib\ext\cldrdata.jar;C:\Program Files\JavaReview\jdk1.8.0_102\jre\lib\ext\dnsns.jar;C:\Program Files\JavaReview\jdk1.8.0_102\jre\lib\ext\jaccess.jar;C:\Program Files\JavaReview\jdk1.8.0_102\jre\lib\ext\jfxrt.jar;C:\Program Files\JavaReview\jdk1.8.0_102\jre\lib\ext\localedata.jar;C:\Program Files\JavaReview\jdk1.8.0_102\jre\lib\ext\nashorn.jar;C:\Program Files\JavaReview\jdk1.8.0_102\jre\lib\ext\sunec.jar;C:\Program Files\JavaReview\jdk1.8.0_102\jre\lib\ext\sunjce_provider.jar;C:\Program Files\JavaReview\jdk1.8.0_102\jre\lib\ext\sunmscapi.jar;C:\Program Files\JavaReview\jdk1.8.0_102\jre\lib\ext\sunpkcs11.jar;C:\Program Files\JavaReview\jdk1.8.0_102\jre\lib\ext\zipfs.jar;C:\Program Files\JavaReview\jdk1.8.0_102\jre\lib\javaws.jar;C:\Program Files\JavaReview\jdk1.8.0_102\jre\lib\jce.jar;C:\Program Files\JavaReview\jdk1.8.0_102\jre\lib\jfr.jar;C:\Program Files\JavaReview\jdk1.8.0_102\jre\lib\jfxswt.jar;C:\Program Files\JavaReview\jdk1.8.0_102\jre\lib\jsse.jar;C:\Program Files\JavaReview\jdk1.8.0_102\jre\lib\management-agent.jar;C:\Program Files\JavaReview\jdk1.8.0_102\jre\lib\plugin.jar;C:\Program Files\JavaReview\jdk1.8.0_102\jre\lib\resources.jar;C:\Program Files\JavaReview\jdk1.8.0_102\jre\lib\rt.jar;C:\Users\Nikhi\Google Drive\IdeaProjects\HackerRank\out\production\HackerRank;C:\Program Files (x86)\JetBrains\IntelliJ IDEA Community Edition 2016.2.4\lib\idea_rt.jar" com.intellij.rt.execution.application.AppMain CompanyCompetetions.Yahoo.CurrentBattingOrder
331028124,24,7912,CF,1,1
331028124,24,7631,2B,2,1
331028124,24,7631,1B,3,1
331028124,24,8394,P,3,2
331028124,24,7245,LF,4,1
331028124,17,9194,SS,1,1
 */
