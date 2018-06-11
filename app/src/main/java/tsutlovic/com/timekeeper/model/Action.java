package tsutlovic.com.timekeeper.model;

public class Action {

    //region Field Variables

    //Field variables for each Action
    private String name;
    private String category;
    private String start;
    private String end;
    private int numLines;
    private long dbId;
    //endregion

    //region Constructors

    //class constructor for event class with a database id
    public Action(String name, String category, String start, String end, int numLines, long dbId){
        //initialization of the fields
        this.name = name;
        this.category = category;
        this.start = start;
        this.end = end;
        this.numLines = numLines;
        this.dbId = dbId;
    }

    //class constructor for event class without a database id
    public Action(String name, String category, String start, String end, int numLines){
        //initialization of the fields
        this.name = name;
        this.category = category;
        this.start = start;
        this.end = end;
        this.numLines = numLines;
    }

    //endregion

    //region Getters and Setters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getNumLines() {
        return numLines;
    }

    public void setNumLines(int numLines) {
        this.numLines = numLines;
    }

    public long getDbId() {
        return dbId;
    }

    public void setDbId(long dbId) {
        this.dbId = dbId;
    }

    //endregion

    //region toString

    @Override
    public String toString() {
        return name;
    }
    //endregion
}
