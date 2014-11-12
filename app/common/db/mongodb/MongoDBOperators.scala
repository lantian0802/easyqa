package common.db.mongodb

import java.util

import com.mongodb.DBCollection
/**
 * Created by steven on 11/4/14.
 */
trait MongoDBOperators[T] {
    def doExecute(dbName:String,collectionName:String,action:DBCollection => T):T
}
