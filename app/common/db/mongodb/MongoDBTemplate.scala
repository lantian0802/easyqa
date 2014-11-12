package common.db.mongodb

import com.mongodb.DBCollection

/**
 * Created by steven on 11/4/14.
 * @author steven
 * @since 2014-11-03
 */
class MongoDBTemplate[T](mongoDBFactory:MongoDBFactory) extends MongoDBOperators[T]{

  override def doExecute(dbName: String, collectionName: String, action: (DBCollection) => T): T = {
      val collection = mongoDBFactory.getDBCollection(dbName,collectionName)
      action(collection)
  }
}
