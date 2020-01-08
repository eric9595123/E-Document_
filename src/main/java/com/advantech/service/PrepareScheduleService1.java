/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advantech.service;

import com.advantech.dao.BabSettingHistoryDAO;
import com.advantech.dao.LineDAO;
import com.advantech.dao.LineUserReferenceDAO;
import com.advantech.model.PrepareSchedule;
import com.advantech.dao.PrepareScheduleDAO;
import com.advantech.model.BabSettingHistory;
import com.advantech.model.Floor;
import com.advantech.model.Line;
import com.advantech.model.LineUserReference;
import com.advantech.model.User;
import static com.google.common.collect.Lists.newArrayList;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import static java.util.Comparator.comparing;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import java.util.stream.IntStream;
import org.apache.commons.lang3.SerializationUtils;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.Minutes;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Wei.Cheng
 */
@Service
@Transactional
public class PrepareScheduleService1 {

    @Autowired
    private PrepareScheduleDAO dao;

    @Autowired
    private LineUserReferenceDAO lineUserRefDAO;

    @Autowired
    private LineDAO lineDAO;

    @Autowired
    private BabSettingHistoryDAO settingHistoryDAO;

    private Interval rest1;
    private Interval rest2;
    private Interval rest3;
    private DateTime scheduleStartTime;
    private DateTime scheduleEndTime;

    DateTimeFormatter df = DateTimeFormat.forPattern("yyyy/MM/dd HH:mm:ss");

    Line emptyLine;

    public List<PrepareSchedule> findAll() {
        return dao.findAll();
    }

    public PrepareSchedule findByPrimaryKey(Object obj_id) {
        return dao.findByPrimaryKey(obj_id);
    }

    public List<PrepareSchedule> findPrepareSchedule(Floor f, DateTime d) {
        /*
            Auto schedule line at 6:00 am
            Refresh schedule time & people when user change line schedule priority or user's setting
         */
 /*
            Get all user in line setting << how to group as Map<Line, List<LineUserReference>> result?
            Foreach schedule
            Find best user setting & last finished time not > 21:30
            Set schedule line
        
            Where to decide schedule order?
         */

        updateDateParamater(d);

        List<Line> line = lineDAO.findBySitefloorAndLineType(f.getName(), 1);

        List<PrepareSchedule> l = dao.findByFloorAndDate(f, d);
        l = l.stream().sorted(comparing(PrepareSchedule::getTimeCost).reversed()).collect(toList());
        List<LineUserReference> users = lineUserRefDAO.findByLines(line);

        emptyLine = lineDAO.findByPrimaryKey(7);

        if (!l.isEmpty()) {
            l = setScheduleLine(users, l);
        }
        return l;
    }

    private void updateDateParamater(DateTime d) {
        scheduleStartTime = new DateTime(d).withTime(8, 30, 0, 0);
//        scheduleEndTime = new DateTime(d).withTime(21, 0, 0, 0);
        scheduleEndTime = new DateTime(d).withTime(23, 59, 59, 0);
        rest1 = new Interval(new DateTime(d).withTime(12, 0, 0, 0), new DateTime(d).withTime(12, 50, 0, 0));
        rest2 = new Interval(new DateTime(d).withTime(15, 30, 0, 0), new DateTime(d).withTime(15, 40, 0, 0));
        rest3 = new Interval(new DateTime(d).withTime(17, 30, 0, 0), new DateTime(d).withTime(18, 0, 0, 0));
    }

    private List<PrepareSchedule> setScheduleLine(List<LineUserReference> users, List<PrepareSchedule> l) {

        //Find modelName fit in settings
        List<String> modelNames = l.stream().map(s -> s.getModelName()).collect(toList());
        List<BabSettingHistory> settings = settingHistoryDAO.findByBabModelNames(modelNames);

        //Find jobnumber fit in settings
//        List<BabSettingHistory> jSettings = settings.stream().filter(s -> {
//            LineUserReference fitSettings = users.stream()
//                    .filter(fw -> fw.getId().getUser().getJobnumber().equals(s.getJobnumber()) && fw.getStation() == s.getStation())
//                    .findFirst().orElse(null);
//            return fitSettings != null;
//        }).collect(toList());
        List<BabSettingHistory> jSettings = settings.stream().filter(s -> {
            LineUserReference fitSettings = users.stream()
                    .filter(fw -> fw.getId().getUser().getJobnumber().equals(s.getJobnumber()))
                    .findFirst().orElse(null);
            return fitSettings != null;
        }).collect(toList());

        Map<Line, List<PrepareSchedule>> result = new HashMap();
        List<Line> lines = users.stream().map(u -> u.getId().getLine()).distinct().collect(toList());
        lines = lines.stream().sorted(comparing(Line::getName)).collect(toList());

        //Add empty List into result
        lines.forEach((line) -> {
            result.put(line, new ArrayList());
        });

        result.put(emptyLine, new ArrayList());

        for (PrepareSchedule s : l) {
//            HibernateObjectPrinter.print(s);

            String modelName = s.getModelName();
            List<BabSettingHistory> modelNameFitSetting = jSettings.stream()
                    .filter(bsh -> bsh.getBab().getModelName().equals(modelName))
                    .collect(toList());

            //jSettings group by line & find max number of model experience
            //Map<Line, Integer cnt of users>
            Map<Line, List<Boolean>> historyFitUserSetting = users.stream()
                    .collect(groupingBy(x -> x.getId().getLine(), mapping(f -> {
                        BabSettingHistory obj = modelNameFitSetting.stream()
                                .filter(bsh -> bsh.getJobnumber().equals(f.getId().getUser().getJobnumber()))
                                .findFirst().orElse(null);
                        return obj != null;
                    }, toList())));

            //Check line to add schedule(must schedule time and before 21:30)
            findFitLineSetting(s, historyFitUserSetting, result, new ArrayList());
        }

        List<PrepareSchedule> result2 = new ArrayList();

        result.forEach((k, v) -> {
            int i = 1;
            for (PrepareSchedule p : v) {
                p.setPriority(i++);
            }

            List<User> settingUsers = users.stream().filter(u -> u.getId().getLine().equals(k))
                    .map(u -> u.getId().getUser())
                    .collect(toList());

            v.forEach(s -> {
                s.setUsers(settingUsers);
            });

            result2.addAll(v);
        });

        return result2;
    }

    private void findFitLineSetting(PrepareSchedule currentSchedule, Map<Line, List<Boolean>> lineUserSetting, Map<Line, List<PrepareSchedule>> result, List<Line> removeLine) {

        Map<Line, List<Boolean>> settingClone = new HashMap(lineUserSetting);

        removeLine.forEach((line) -> {
            settingClone.remove(line);
        });

        if (settingClone.isEmpty()) {
            currentSchedule.setLine(emptyLine);
            currentSchedule.setStartDate(null);
            currentSchedule.setEndDate(null);
            currentSchedule.setUsers(null);
            currentSchedule.setOtherInfo(null);
            result.get(emptyLine).add(currentSchedule);
            return;
        }

        //Find best line setting
        Line line = settingClone.entrySet()
                .stream()
                .max((Map.Entry<Line, List<Boolean>> e1, Map.Entry<Line, List<Boolean>> e2) -> {
                    int v1 = e1.getValue().stream().mapToInt(b -> b == true ? 1 : 0).sum();
                    int v2 = e2.getValue().stream().mapToInt(b -> b == true ? 1 : 0).sum();
                    int c1 = Integer.compare(v1, v2);
                    if (c1 != 0) {
                        return c1;
                    } else {
                        return e1.getKey().getName().compareTo(e2.getKey().getName());
                    }
                })
                .get()
                .getKey();

        if (result.isEmpty() || line == null) {
            return;
        }

        //Test and check last schedule time
        List<PrepareSchedule> lineSchedule = result.get(line);
        int usersCnt = lineUserSetting.get(line).size();
        List<PrepareSchedule> testScheduleList = newArrayList(lineSchedule);
        List<Boolean> fitStatus = lineUserSetting.get(line);
        Map<Integer, Boolean> fitStatusMap = IntStream.range(0, fitStatus.size())
                .boxed()
                .collect(toMap(i -> i, fitStatus::get));
        currentSchedule.setLine(line);
        currentSchedule.setOtherInfo(fitStatusMap);
        testScheduleList.add(currentSchedule);
        testScheduleList = scheduleTime(usersCnt, testScheduleList);

        //If last schedule finish time is after 21:30, remove line choose in map
        Date lastScheduleDate = testScheduleList.get(testScheduleList.size() - 1).getEndDate();
        if (new DateTime(lastScheduleDate).isAfter(scheduleEndTime)) {
            removeLine.add(line);
            findFitLineSetting(currentSchedule, lineUserSetting, result, removeLine);
        } else {
            result.replace(line, testScheduleList);
        }
    }

    private List<PrepareSchedule> scheduleTime(int users, List<PrepareSchedule> l) {

        int maxPeopleCnt = users;

        PrepareSchedule prev = null;
        int cnt = 0;

        for (PrepareSchedule w : l) {
            DateTime start = new DateTime(scheduleStartTime);
            if (cnt != 0 && prev != null) {
                start = new DateTime(prev.getEndDate());
            }
            BigDecimal addTime = w.getTimeCost().setScale(0, RoundingMode.UP);
            DateTime end = start.plusMinutes(addTime.divide(new BigDecimal(maxPeopleCnt), 0, BigDecimal.ROUND_UP).intValue());

            Interval timeAdjust = byPassRestTime(new Interval(start, end));

            w.setStartDate(timeAdjust.getStart().toDate());
            w.setEndDate(timeAdjust.getEnd().toDate());

            prev = w;
            cnt++;
        }
        return l;
    }

    private Interval byPassRestTime(Interval i) {
        int rest1Min = Minutes.minutesBetween(rest1.getStart(), rest1.getEnd()).getMinutes();
        int rest2Min = Minutes.minutesBetween(rest2.getStart(), rest2.getEnd()).getMinutes();
        int rest3Min = Minutes.minutesBetween(rest3.getStart(), rest3.getEnd()).getMinutes();
        if (isInRestTime(i.getStart())) {
            return new Interval(rest1.getStart(), rest1.getStart().plusMinutes(rest1Min));
        }
        if (isInRestTime2(i.getStart())) {
            return new Interval(rest2.getStart(), rest2.getStart().plusMinutes(rest2Min));
        }
        if (isInRestTime3(i.getStart())) {
            return new Interval(rest3.getStart(), rest3.getStart().plusMinutes(rest2Min));
        }
        if (hasOverlap(i, rest1)) {
            return new Interval(i.getStart(), i.getEnd().plusMinutes(rest1Min));
        }
        if (hasOverlap(i, rest2)) {
            return new Interval(i.getStart(), i.getEnd().plusMinutes(rest2Min));
        }
        if (hasOverlap(i, rest3)) {
            return new Interval(i.getStart(), i.getEnd().plusMinutes(rest3Min));
        }

        return i;
    }

    private boolean hasOverlap(Interval t1, Interval t2) {
        return !t1.getEnd().isBefore(t2.getStart()) && !t1.getStart().isAfter(t2.getEnd());
    }

    private boolean isInRestTime(DateTime d) {
        return rest1.getStart().compareTo(d) * d.compareTo(rest1.getEnd()) >= 0;
    }

    private boolean isInRestTime2(DateTime d) {
        return rest2.getStart().compareTo(d) * d.compareTo(rest2.getEnd()) >= 0;
    }

    private boolean isInRestTime3(DateTime d) {
        return rest3.getStart().compareTo(d) * d.compareTo(rest3.getEnd()) >= 0;
    }

    public int separateCnt(PrepareSchedule pojo, List<Integer> cnt) {
        int rowCnt = 0;
        int baseCnt = pojo.getScheduleQty();
        BigDecimal baseTimeCost = pojo.getTimeCost();

        Integer sum = cnt.stream().reduce(0, Integer::sum);
        if (baseCnt - sum > 0) {
            cnt.add(baseCnt - sum);
        } else if (sum > baseCnt) {
            return 1;
        }

        for (int c : cnt) {
            if (rowCnt++ == 0) {
                pojo.setScheduleQty(c);
                pojo.setTimeCost(baseTimeCost.divide(new BigDecimal(baseCnt), 2, BigDecimal.ROUND_UP)
                        .multiply(new BigDecimal(c))
                        .setScale(2, BigDecimal.ROUND_UP));
                dao.update(pojo);
            } else {
                PrepareSchedule clone = SerializationUtils.clone(pojo);
                clone.setId(0);
                clone.setScheduleQty(c);
                clone.setTimeCost(baseTimeCost.divide(new BigDecimal(baseCnt), 2, BigDecimal.ROUND_UP)
                        .multiply(new BigDecimal(c))
                        .setScale(2, BigDecimal.ROUND_UP));
                dao.insert(clone);
            }
        }

        return 1;
    }

    public int insert(PrepareSchedule pojo) {
        return dao.insert(pojo);
    }

    public int update(PrepareSchedule pojo) {
        return dao.update(pojo);
    }

    public int delete(PrepareSchedule pojo) {
        return dao.delete(pojo);
    }

}
