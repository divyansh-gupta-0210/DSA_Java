package LLDPractise;

import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;

interface DocumentElement{
    public abstract String render();
}

class TextElement implements DocumentElement{
    private String text;
    public TextElement(String text){
        this.text = text;
    }

    @Override
    public String render(){
        return text;
    }
}

class ImageElement implements DocumentElement{
    private String path;
    public ImageElement(String path){
        this.path = path;
    }

    @Override
    public String render(){
        return path;
    }
}

interface Persistence {
    void save(String data);
}

class SaveToMongo implements Persistence {
    @Override
    public void save(String data){
        //Save to db
    }
}

class FileStorage implements Persistence {
    @Override
    public void save(String data){
        try{
            FileWriter outFile = new FileWriter("doc.txt");
            outFile.write(data);
            outFile.close();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}

class Document{
    private final List<DocumentElement> documentElements = new ArrayList<>();

    public void addElement(DocumentElement documentElement){
        documentElements.add(documentElement);
    }

    public List<DocumentElement> getDocumentElements(){
        return documentElements;
    }
}

class DocumentRender{
    public String render(Document document){
        StringBuilder sb = new StringBuilder();
        for(DocumentElement documentElement : document.getDocumentElements()){
            sb.append(documentElement.render());
        }
        return sb.toString();
    }
}

class DocumentEditor{
    Document document;
    Persistence persistence;
    DocumentRender documentRender;

    public DocumentEditor(Document document, Persistence persistence, DocumentRender documentRender){
        this.document = document;
        this.persistence = persistence;
        this.documentRender = documentRender;
    }

    public void addText(String text){
        document.addElement(new TextElement(text));
    }

    public void addImage(String path){
        document.addElement(new ImageElement(path));
    }

    public void saveDocument(){
        String renderedContent = documentRender.render(document);
        persistence.save(renderedContent);
    }
}

public class DocumentEditorClient {

    public static void main(String[] args) {

//        Good Design
        Document document = new Document();
        DocumentRender documentRender = new DocumentRender();
        Persistence persistence = new FileStorage();
        DocumentEditor documentEditor = new DocumentEditor(document, persistence, documentRender);

        documentEditor.addText("Hi Divyansh!");
        documentEditor.addImage("/image.jpeg");
        documentEditor.saveDocument();

//        Bad Design
//        DocumentEditor editor = new DocumentEditor();
//        editor.addText("Hello, world!");
//        editor.addImage("picture.jpg");
//        editor.addText("This is a document editor.");
//
//        System.out.println(editor.renderDocument());
//
//        editor.saveToFile();
    }

//   BAD DESIGN
//    class DocumentEditor {
//        private List<String> documentElements;
//        private String renderedDocument;
//
//        public DocumentEditor() {
//            documentElements = new ArrayList<>();
//            renderedDocument = "";
//        }
//
//        public void addText(String text) {
//            documentElements.add(text);
//        }
//
//        // Adds an image represented by its file path
//        public void addImage(String imagePath) {
//            documentElements.add(imagePath);
//        }
//
//        public String renderDocument() {
//            if (renderedDocument.isEmpty()) {
//                StringBuilder result = new StringBuilder();
//                for (String element : documentElements) {
//                    if (element.length() > 4 &&
//                            (element.endsWith(".jpg") || element.endsWith(".png"))) {
//                        result.append("[Image: ").append(element).append("]\n");
//                    } else {
//                        result.append(element).append("\n");
//                    }
//                }
//                renderedDocument = result.toString();
//            }
//            return renderedDocument;
//        }
//
//        public void saveToFile() {
//            try {
//                FileWriter writer = new FileWriter("document.txt");
//                writer.write(renderDocument());
//                writer.close();
//                System.out.println("Document saved to document.txt");
//            } catch (IOException e) {
//                System.out.println("Error: Unable to open file for writing.");
//            }
//        }
//    }

}
