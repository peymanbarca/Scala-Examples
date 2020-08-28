/**
  * Created by zevik on 8/28/20.
  */

import java.sql.{Connection, DriverManager, ResultSet}

class PSQLClient(val host:String, val db:String, val user:String, val password:String) {

  println("Postgres connector Initialized ...")

  classOf[org.postgresql.Driver]
  val con_str = "jdbc:postgresql://" + host + ":5432/" + db + "?user=" + user + "&password=" + password
  val conn = DriverManager.getConnection(con_str)
  private val underlying = conn

  def this() = this("localhost", db="postgres" , user="postgres",password="1234")

}
