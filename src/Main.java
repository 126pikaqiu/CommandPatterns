import io.impl.CommandLineInput;
import io.impl.CommandLineOutput;
import io.impl.MyFileInput;
import io.impl.MyFileOutput;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 刘佳兴
 * @date 2020/10/23 12:35
 * mail 1260968291@qq.com
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException, IOException {

        Map<Character, String> commandMaps = new HashMap<>();
        commandMaps.put('s', "command.impl.ShowCommand");
        commandMaps.put('a', "command.impl.AddBeforeCommand");
        commandMaps.put('A', "command.impl.AddAfterCommand");
        commandMaps.put('D', "command.impl.DeleteAfterCommand");
        commandMaps.put('d', "command.impl.DeleteBeforeCommand");

        Client client = new Client(commandMaps);

        // Test1：命令行输入输出测试
//        client.start(new CommandLineInput(),new CommandLineOutput());
//        client.flush();

        // Test2：文本文件测试
//         client.start(new MyFileInput(new File("src/assets/case1.txt")), new MyFileOutput(new File("src/assets/solution1.txt")));
//         client.flush();
//
//         client.start(new MyFileInput(new File("src/assets/case2.txt")), new MyFileOutput(new File("src/assets/solution2.txt")));
//         client.flush();
//
//         client.start(new MyFileInput(new File("src/assets/case3.txt")), new MyFileOutput(new File("src/assets/solution3.txt")));
//         client.flush();
//
//         client.start(new MyFileInput(new File("src/assets/case4.txt")), new MyFileOutput(new File("src/assets/solution4.txt")));
//         client.flush();

        // Test3：文本输入，命令行输出测试
        System.out.println("===============");
        client.start(new MyFileInput(new File("src/assets/case1.txt")), new CommandLineOutput());
        client.flush();
        System.out.println("===============");
        client.start(new MyFileInput(new File("src/assets/case2.txt")), new CommandLineOutput());
        client.flush();
        System.out.println("===============");
        client.start(new MyFileInput(new File("src/assets/case3.txt")), new CommandLineOutput());
        client.flush();
        System.out.println("===============");
        client.start(new MyFileInput(new File("src/assets/case4.txt")), new CommandLineOutput());
        client.flush();
    }
}
