import java.sql.ResultSet

/**
  * Created by zevik on 8/28/20.
  */

trait utils {
  def execReadQuery(query:String):ResultSet
  def execWriteQuery(query:String)
}

class PSQLutilities(client: PSQLClient) extends utils {


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

}

