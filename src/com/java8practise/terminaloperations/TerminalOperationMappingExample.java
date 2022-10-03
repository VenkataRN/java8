package com.java8practise.terminaloperations;
import com.java8practise.data.Student;
import com.java8practise.data.StudentDataBase;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class TerminalOperationMappingExample {
    public static void main(String[] args){
        List<String> studentNameList =  StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.mapping(Student::getName, Collectors.toList()));

        System.out.println(studentNameList);

        Set<String> studentNameSet =  StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.mapping(Student::getName, Collectors.toSet()));
        System.out.println(studentNameSet);

        //OR the above is to replace below way of doing 4 step approach.

         studentNameSet =  StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getName)
                .collect(Collectors.toSet());
        System.out.println(studentNameSet);
    }
}

/*

"C:\Program Files\Java\jdk1.8.0_65\bin\java.exe" "-javaagent:F:\IntelliJ IDEA 2022.2.2\lib\idea_rt.jar=51293:F:\IntelliJ IDEA 2022.2.2\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_65\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_65\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_65\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_65\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_65\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_65\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_65\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_65\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_65\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_65\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_65\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_65\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_65\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_65\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_65\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_65\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_65\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_65\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_65\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_65\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_65\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_65\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_65\jre\lib\rt.jar;F:\JavaPractise\Practise\out\production\Practise" com.java8practise.terminaloperations.TerminalOperationMappingExample
[Adam, Jenny, Emily, Dave, Sophia, James]
[Adam, Emily, James, Jenny, Dave, Sophia]
[Adam, Emily, James, Jenny, Dave, Sophia]

Process finished with exit code 0

 */