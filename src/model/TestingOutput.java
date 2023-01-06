package model;

public class TestingOutput {

    int outputId;
    int inputId;
    String result;

    public TestingOutput(int outputId, int inputId, String result) {
        this.outputId = outputId;
        this.inputId = inputId;
        this.result = result;
    }

    public int getOutputId() {
        return outputId;
    }

    public int getInputId() {
        return inputId;
    }

    public String getResult() {
        return result;
    }


    public void setOutputId(int outputId) {
        this.outputId = outputId;
    }

    public void setInputId(int inputId) {
        this.inputId = inputId;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String toCsv() {
        return outputId + "," + inputId + "," + result;
    }
}
