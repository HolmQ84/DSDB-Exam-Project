package dsdb.frontend.Service;

import dsdb.frontend.Model.LogInfoDTO;
import dsdb.frontend.Model.Session;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class LogInfoService {

    public LogInfoDTO getLogInformation(List<Session> sessionList) {
        LogInfoDTO logInfoDTO = new LogInfoDTO();
        for (Session current: sessionList) {
            logInfoDTO.avgPages = logInfoDTO.avgPages + current.pagesVisited.size();
            logInfoDTO.avgTime = logInfoDTO.avgTime + getTotalTimeOnInSeconds(current);
            if (logInfoDTO.visitTimeOfDay.containsKey(current.startTime.getHours())) {
                logInfoDTO.visitTimeOfDay.put(current.startTime.getHours(), logInfoDTO.visitTimeOfDay.get(current.startTime.getHours()) +1);
            } else {
                logInfoDTO.visitTimeOfDay.put(current.startTime.getHours(), 1);
            }
            for (String currentPage: current.pagesVisited) {
                if (logInfoDTO.pages.containsKey(currentPage)) {
                    logInfoDTO.pages.put(currentPage, logInfoDTO.pages.get(currentPage) +1);
                } else {
                    logInfoDTO.pages.put(currentPage, 1);
                }
            }
        }
        logInfoDTO.numberOfVisitors = sessionList.size();
        logInfoDTO.avgPages = (logInfoDTO.avgPages/sessionList.size());
        logInfoDTO.avgTime = (logInfoDTO.avgTime/sessionList.size());
        logInfoDTO.mostVisitedPage = Collections.max(logInfoDTO.pages.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
        return logInfoDTO;
    }

    public int getTotalTimeOnInSeconds(Session session) {
        Date startDate = session.startTime;
        Date endDate = session.endTime;
        long diffInMillies = Math.abs(endDate.getTime() - startDate.getTime());
        long diff = TimeUnit.SECONDS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        return (int) diff;
    }
}
