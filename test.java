import markup.*;

import java.util.Arrays;
import java.util.Collections;

public class test {
    public static void main(String[] args) {


        Paragraph paragraph = new Paragraph(Collections.singletonList(
                new Strong(Arrays.asList(
                        new Text("1"),
                        new Strikeout(Arrays.asList(
                                new Text("2"),
                                new Emphasis(Arrays.asList(
                                        new Text("3"),
                                        new Text("4")
                                )),
                                new Text("5")
                       )),
                        new Text("6")
                ))
        ));
        StringBuilder stringBuilder = new StringBuilder();
        paragraph.toMarkdown(stringBuilder);
        System.out.println(stringBuilder.toString());
    }
}