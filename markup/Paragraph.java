package markup;

import java.util.List;

public class Paragraph extends Text{
    public Paragraph(List<Text> singletonList) {
        super(singletonList);
    }

    public void toMarkdown(StringBuilder stringBuilder) {
        super.toMarkdown(stringBuilder);
    }
}
