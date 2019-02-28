package markup;

import java.util.ArrayList;
import java.util.List;

public class Text {
    private String text = "";

    public Text(String text) {
        this.text = text;
    }

    private List<Text> list = new ArrayList<>();

    Text(List<Text> singletonList) {
        list = singletonList;
    }
    void toMarkdown(StringBuilder stringBuilder) {
        stringBuilder.append(text);
        for (Text item:list) {
            item.toMarkdown(stringBuilder);
        }
    }
}
