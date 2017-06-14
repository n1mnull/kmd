package kmd.model;


public class Error {

    private String errorMsg;

    public Error() {
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    @Override
    public String toString() {
        return "Error{" +
                "errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
