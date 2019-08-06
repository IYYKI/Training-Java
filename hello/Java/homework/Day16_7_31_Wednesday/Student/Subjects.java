package Day16_7_31_Wednesday.Student;

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
        return "考试信息 (名字: " + name + ", 成绩 =" +results +")";
    }
}
