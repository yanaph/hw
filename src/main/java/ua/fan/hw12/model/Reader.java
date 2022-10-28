package ua.fan.hw12.model;

public class Reader {
    public void takeBook() throws Exception {
        throw new Exception("There is no book to read");
    }

    public void read() throws Exception {
        try {
            takeBook();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        throw new Exception("Reader doesn't have reading skills yet!");
    }

    public static void main(String[] args) {
        System.out.println("---> TASK 2:");
        Reader reader = new Reader();
        try {
            reader.read();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
