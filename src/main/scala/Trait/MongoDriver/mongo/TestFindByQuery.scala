package Trait.MongoDriver.mongo

/**
  * Created by zevik on 8/27/20.
  */

import com.mongodb.BasicDBObject

object TestFindQuery extends App{

  def client = new MongoClient
  def db = client.db("mydb")
  val col = db.readOnlyCollection("test")
  val updatableCol = db.updatableCollection("test")


//  for(i <- 1 to 100) updatableCol += new BasicDBObject("i", i)

  val rangeQuery = new BasicDBObject("i", new BasicDBObject("$gt", 20))
  val richQuery = Query(rangeQuery).skip(2).limit(12)
  val cursor = col.find(richQuery)
  while(cursor.hasNext()) {
    println(cursor.next());
  }

}