package model;

public class Expected {
    int expect_id;
    int input_id;
    String expect_result;

    public Expected(int expect_id, int input_id, String expect_result) {
        this.expect_id = expect_id;
        this.input_id = input_id;
        this.expect_result = expect_result;
    }

    public int getExpect_id() {
        return expect_id;
    }

    public int getInput_id() {
        return input_id;
    }

    public String getExpect_result() {
        return expect_result;
    }

    public void setExpect_id(int expect_id) {
        this.expect_id = expect_id;
    }

    public void setInput_id(int input_id) {
        this.input_id = input_id;
    }

    public void setExpect_result(String expect_result) {
        this.expect_result = expect_result;
    }

    public String toCsv(){
        return expect_id + "," + input_id + "," +expect_result;
    }
}
