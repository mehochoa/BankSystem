interface Button {
    void render();
}

interface Checkbox {
    void render();
}

interface UIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

//WINDOW
class WindowsButton implements Button {
    public void render() {
        System.out.println("Vẽ nút bấm kiểu WINDOWS");
    }
}

class WindowsCheckbox implements Checkbox {
    public void render() {
        System.out.println("Vẽ ô đánh dấu kiểu WINDOWS");
    }
}

class WindowsFactory implements UIFactory {
    public Button createButton() {
        return new WindowsButton();
    }
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

//MAC
class MacButton implements Button {
    public void render() {
        System.out.println("Vẽ nút bấm kiểu MAC");
    }
}

class MacCheckbox implements Checkbox {
    public void render() {
        System.out.println("Vẽ ô đánh dấu kiểu MAC");
    }
}

class MacFactory implements UIFactory {
    public Button createButton() { return new MacButton(); }
    public Checkbox createCheckbox() { return new MacCheckbox(); }
}

public class Main {
    public static void main(String[] args) {
        String osConfig = "win";

        UIFactory factory;

        if (osConfig.equalsIgnoreCase("win")) {
            factory = new WindowsFactory();
        } else {
            factory = new MacFactory();
        }

        Button btn = factory.createButton();
        Checkbox cb = factory.createCheckbox();

        btn.render();
        cb.render();
    }
}