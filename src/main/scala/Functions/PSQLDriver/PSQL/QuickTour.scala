import java.sql.ResultSet

/**
  * Created by zevik on 8/28/20.
  */

object QuickTour extends App{

  val client = new PSQLClient()

  def execReadQuery(query:String): ResultSet = {

    val conn = client.conn

    try {
      val stm = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)
      val rs = stm.executeQuery(query)
      return rs
    } finally {
      conn.close()
    }

  }

  def execWriteQuery(query:String) = {
    val conn = client.conn
    val stm = conn.createStatement()
    stm.execute(query)
  }


  val queryCreate = "CREATE TABLE IF NOT EXISTS emp_data (\nname text,\nage integer,\ndesignation text,\nsalary integer\n);"
  execWriteQuery(queryCreate)


  val newEmpRecord = List("ahmad", 20, null,2000000)
  val queryInsert = "insert into emp_data values ('%s',%s,%s,%s)".format(newEmpRecord(0),newEmpRecord(1),newEmpRecord(2),newEmpRecord(3))
  println(queryInsert)
  execWriteQuery(queryInsert)


  val queryRead = "select * from emp_data"
  val rs = execReadQuery(queryRead)

  while(rs.next) {
    val tmp = List(rs.getString("name"),rs.getInt("age"),rs.getInt("salary"))
    println(tmp)
  }




}
