package common.db.mongodb

import com.mongodb.DBCollection

/**
 * Created by steven on 11/11/14.
 * fetch mongoDB collection
 */
trait MongoDBFactory {
  /**
   * fetch collection from db
   * @param dbName
   * @param collectionName
   * @return
   */
    def getDBCollection(dbName:String,collectionName:String) : DBCollection
}
