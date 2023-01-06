
public class BoundaryValueMain {

    public static void main(String args[])
    {
        //อ่าน database ของ document
        Database<DocumentTOB, DocumentTOBList> database = new DocumentTOB_DBConnect();
        String query1 = " Select * FROM documenttransactionofborrow WHERE Dtb_status = '0' ORDER BY Dtb_date DESC;  ";
        //เอาที่อ่านจาก database มาใส่ list
        documentTOBList = database.readDatabase(query1); //ได้ documentTob list

    }
}
