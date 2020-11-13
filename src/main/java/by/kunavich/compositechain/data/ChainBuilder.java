package by.kunavich.compositechain.data;

public class ChainBuilder {
    Parser build(){
        AbstractParser sentence= new SentenceParser();
        AbstractParser paragrph = new ParagraphParser();
        paragrph.setSuccessor(sentence);
        AbstractParser text = new TextParser();
        text.setSuccessor(paragrph);
        return text;
    }
}
