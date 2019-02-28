package markup;

import java.util.List;

public class Strong extends Paragraph {
    public Strong(List<Text> list) {
        super(list);
    }

    public void toMarkdown(StringBuilder stringBuilder) {
        stringBuilder.append("_");
        super.toMarkdown(stringBuilder);
        stringBuilder.append("_");
    }
}
