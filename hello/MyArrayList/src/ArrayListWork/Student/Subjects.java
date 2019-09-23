package ArrayListWork.Student;

public class Subjects {
    private String name;
    private  int results;
    public Subjects(String name , int results){
        this.name = name;
        this.results = results;
    }

    public String getName() {
        return name;
    }

    public int getResults() {
        return results;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setResults(int results) {
        this.results = results;
    }
    public String toString(){
        return "������Ϣ (����: " + name + ", �ɼ� =" +results +")";
    }
}
