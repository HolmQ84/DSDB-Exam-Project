package dsdb.logger.Repository;

import dsdb.logger.Model.LoggerInfo;
import dsdb.logger.Model.SongInfo;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoggerRepository extends MongoRepository<LoggerInfo, Integer> {


    @Aggregation(pipeline = qureyForGettingTime)
    List<LoggerInfo> getTimeLog();



    String qureyForGettingTime = "{\n" +
            "        $match: {\n" +
            "           'start': {\n" +
            "              $gte: ISODate('2022-05-20'), $lt: ISODate('2022-05-22')\n" +
            "           }\n" +
            "        }\n" +
            "     },\n" +
            "     {\n" +
            "        $set: {\n" +
            "           Duration: {\n" +
            "              $dateToString: {\n" +
            "                 date: {\n" +
            "                    $dateFromParts: {\n" +
            "                       year: 1970,\n" +
            "                       millisecond: { $subtract: [ \"$end\", \"$start\" ] }\n" +
            "                    }\n" +
            "                 },\n" +
            "                 format: \"%H:%M:%S\"\n" +
            "              }\n" +
            "           }\n" +
            "        }\n" +
            "     }\n";



}
