import java.sql.ResultSet

/**
  * Created by zevik on 8/28/20.
  */

object QuickTour extends App{

  val client = new PSQLClient()

  val PsqlUtil = new PSQLutilities(client)


  val queryCreate = "CREATE TABLE IF NOT EXISTS emp_data (\nname text,\nage integer,\ndesignation text,\nsalary integer\n);"
  PsqlUtil.execWriteQuery(queryCreate)


  val newEmpRecord = List("ahmad", 20, null,2000000)
  val queryInsert = "insert into emp_data values ('%s',%s,%s,%s)".format(newEmpRecord(0),newEmpRecord(1),newEmpRecord(2),newEmpRecord(3))
  println(queryInsert)
  PsqlUtil.execWriteQuery(queryInsert)


  val queryRead = "select * from emp_data"
  val rs = PsqlUtil.execReadQuery(queryRead)

  while(rs.next) {
    val tmp = List(rs.getString("name"),rs.getInt("age"),rs.getInt("salary"))
    println(tmp)
  }




}
