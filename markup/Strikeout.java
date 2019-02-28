package markup;

import java.util.List;

public class Strikeout extends Paragraph{
    public Strikeout(List<Text> list) {
        super(list);
    }

    public void toMarkdown(StringBuilder stringBuilder) {
        stringBuilder.append("~");
        super.toMarkdown(stringBuilder);
        stringBuilder.append("~");
    }
}
