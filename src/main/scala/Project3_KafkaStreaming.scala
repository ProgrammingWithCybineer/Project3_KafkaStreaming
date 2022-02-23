import java.sql.DriverManager
import java.sql.Connection

object QauntityType {
  def main(args: Array[String]): Unit = {
      // connect to the database named "mysql" on the localhost
      val driver = "com.mysql.jdbc.Driver"
      val url = "jdbc:mysql://localhost:3306/project3" // Modify for whatever port you are running your DB on
      val username = "root"
      val password = "monalisa.123" // Update to include your password
      var connection:Connection = null
      Class.forName(driver)
      connection = DriverManager.getConnection(url, username, password)

      val statement = connection.createStatement()
      var qt = new QuntityTypeOr()

      qt.payTy()
      qt.quantityOrder()
      println(qt.quantityOrder() + ", " + qt.payTy())
      var query= "INSERT INTO payTyQuOr (pyament_type, quantity_order) Values (" + "'" + qt.payTy().toString + "', " + qt.quantityOrder() +");"
      print(query)
      statement.executeUpdate(query)
  }
}
