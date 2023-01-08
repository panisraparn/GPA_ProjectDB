package service;

public interface Database<T, C> {

    //ใส่ object --> insert ข้อมูลใน table
    void insertBoundaryOutput(T t);

    //ใส่ object --> insert ข้อมูลใน table
    void insertRobustnessOutput(T t);

    void insertWorstCaseBoundaryOutput(T t);

    void insertWorstCaseRobustnessOutput(T t);

    T readRecord(String query);

    //ใส่ query return เป็น list
    C readDatabase(String q);

    //ใส่ query --> update table
    void updateDatabase(String q);

    void deleteAllBoundaryValueRecord();
}
