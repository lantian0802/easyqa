package common.db.mongodb

import com.mongodb.{MongoClient, ServerAddress, DBCollection}
import org.slf4j.LoggerFactory
import scala.collection.JavaConverters._

import scala.collection.mutable

/**
 * Created by steven on 11/11/14.
 */

class MongoDBFactoryImpl extends MongoDBFactory {

  private var addressList = new mutable.MutableList[ServerAddress]()

  private var mongoClient = null

  def setAddress(addressList : mutable.MutableList[ServerAddress]): Unit = {
      this.addressList = addressList
  }
  /**
   * bean init
   */
  def init(): Unit = {
      System.setProperty("MONGO.POOLSIZE",String.valueOf(poolSize))
      mongoClient = new MongoClient(addressList.toList.asJava)
      Runtime.getRuntime.addShutdownHook(new Thread(new Runnable() {
        override def run(): Unit = {
          mongoClient.close()
        }
      }))
  }

  /**
   * fetch collection from db
   * @param dbName
   * @param collectionName
   * @return
   */
  override def getDBCollection(dbName: String, collectionName: String): DBCollection = {
      mongoClient.getDB(dbName).getCollection(collectionName)
  }
}


object MongoDBFactoryImpl {

  private final val logger = LoggerFactory.getLogger(this.getClass.getName)

  private final val poolSize = 20
}