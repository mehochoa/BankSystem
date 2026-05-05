import java.util.ArrayList;
import java.util.List;

interface FileSystemItem {
    void print(String indent);
    String getPath();
}

//FileItem
class FileItem implements FileSystemItem {
    private String name;
    private int size;
    private String path;
    //constructor
    public FileItem(String name, int size, String path) {
        this.name = name;
        this.size = size;
        this.path = path;
    }
    @Override
    public void print(String indent){
        System.out.println(indent + "File: " + name + " (" + size + "KB)" );
    }
    @Override
    public String getPath(){
        return path; //tra ve duong dan
    }
}

//Shortcut
class Shortcut implements FileSystemItem {
    private String name;
    private FileSystemItem target;
    //constructor
    public Shortcut(String name, FileSystemItem target) {
        this.name = name;
        this.target = target;
    }
    @Override
    public void print(String indent) {
        System.out.println(indent + "Shortcut: " + name + " -> " + target.getPath());
    }
    @Override
    public String getPath() {
        return "Shortcut/" + name;
    }
}

//Folder
class Folder implements FileSystemItem {
    private String name;
    private List<FileSystemItem> children;
    private String path;
    //constructor
    public Folder(String name, String path) {
        this.name = name;
        this.path = path;
        this.children = new ArrayList<>();
    }
    //them phan tu con
    public void add(FileSystemItem item) {
        children.add(item);
    }
    //in folder va cac phan tu con
    @Override
    public void print(String indent) {
        System.out.println(indent + "Folder: " + name);
        for (FileSystemItem item: children) {
            item.print(indent + "  ");
        }
    }
    @Override
    public String getPath() {
        return path;
    }
}

public class Main {
    public static void main(String[] args) {
        Folder root = new Folder("root", "/root");
        Folder docs = new Folder("docs", "/root/docs");
        FileItem fileA = new FileItem("a.txt", 12, "/root/docs/a.txt");
        FileItem fileB = new FileItem("b.txt", 20, "/root/docs/b.txt");
        docs.add(fileA);
        docs.add(fileB);
        Shortcut shortcut = new Shortcut("a-shortcut", fileA);
        docs.add(shortcut);
        FileItem readme = new FileItem("readme.md", 4, "/root/readme.md");
        root.add(docs);
        root.add(readme);
        root.print("");
    }
}