/**
 * Created with IntelliJ IDEA.
 * User: deepanker
 * Date: 9/4/13
 * Time: 12:14 AM
 * To change this template use File | Settings | File Templates.
 */

import edu.usit.deepanker.interfaces.ReplaceablePattern;
import edu.usit.deepanker.replaceablepatterns.AddArithmeticOperator;
import edu.usit.deepanker.replaceablepatterns.DivisionArithmeticOperator;
import edu.usit.deepanker.replaceablepatterns.MultiplicationArithmeticOperator;
import edu.usit.deepanker.replaceablepatterns.SubtractArithmeticOperator;
import javax.swing.*;
import static java.lang.System.out;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.*;

public class Main {

    private static String immutableFileData;
    private static Map<String,ReplaceablePattern> patternMap;
    private static File mutationDirectory;

    public static void main(String... args){
        patternMap=populatePatterns();
        immutableFileData=getFileData();

        JOptionPane.showMessageDialog(null,"The source you had entered: "+immutableFileData,"Mutation source",JOptionPane.INFORMATION_MESSAGE);
        out.println("The source you had entered: "+immutableFileData);
        if (!immutableFileData.isEmpty()){
            Matcher matcher=patternMap.get("subtraction").getPattern().matcher(immutableFileData);
            Long count=0L;
            while (matcher.find()){
                StringBuffer stringBuffer=new StringBuffer(immutableFileData);
                stringBuffer.replace(matcher.start(),matcher.end(),"/* mutation */ +");
                JOptionPane.showMessageDialog(null,"Mutation generated: "+stringBuffer,"Mutation# "+count,JOptionPane.INFORMATION_MESSAGE);
                out.println("Mutated: "+stringBuffer);
                count++;
            }
        }
    }

    private static Map<String,ReplaceablePattern> populatePatterns(){
        Map<String,ReplaceablePattern> map=new HashMap<String, ReplaceablePattern>();
        map.put("addition",new AddArithmeticOperator());
        map.put("subtraction",new SubtractArithmeticOperator());
        map.put("multiplication",new MultiplicationArithmeticOperator());
        map.put("division",new DivisionArithmeticOperator());
        return map;
    }

    public static String getFileData(){
        StringBuilder fileData=new StringBuilder();

        File file=null;
        File createMutationDirectory=null;
        file=getSourceFile();

        if(file != null){
            BufferedInputStream bufferedInputStream;
            try{
                out.println("File Name: "+file.getAbsolutePath());
                /* create or update directory for generating mutations */
                mutationDirectory=getMutationDirectory(file);
                bufferedInputStream=new BufferedInputStream(new FileInputStream(file));
                int ch;
                while ((ch=bufferedInputStream.read()) != -1){
                    fileData.append((char)ch);
                }
            }catch (Throwable t){
                t.printStackTrace();
            }
        }
        return fileData.toString();
    }

    public static File getSourceFile(){
        JFileChooser jFileChooser=new JFileChooser();
        jFileChooser.showDialog(null,"Choose a source file to generate mutations");
        return jFileChooser.getSelectedFile();
    }

    public static File getMutationDirectory(File file){
        File createMutationDirectory=new File(file.getAbsolutePath()+"MutationTests");
        out.println("Exist? "+createMutationDirectory.exists());
        if(!createMutationDirectory.exists()){
            out.println("creating mutation directory: "+createMutationDirectory.mkdir());
        }
        return createMutationDirectory;
    }
}
