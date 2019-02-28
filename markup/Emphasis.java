package markup;

import java.util.List;

public class Emphasis extends Paragraph {


    public Emphasis(List<Text> list) {
        super(list);
    }


    public void toMarkdown(StringBuilder stringBuilder) {
        stringBuilder.append("*");
        super.toMarkdown(stringBuilder);
        stringBuilder.append("*");
    }
}
