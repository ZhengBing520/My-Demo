package com.zb.service.dao;

import com.zb.service.dto.AlarmCountResponse;
import com.zb.service.entity.JacAlarmRecord;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

/**
 * Created by bzheng on 2018/12/17.
 */
public interface JacAlarmRecordDao {

    int insertList(@Param("list") List<JacAlarmRecord> list);

    @Update("UPDATE jac_alarm_record SET alarm_start_time = #{date} WHERE #{start} < id and id <= #{end}")
    int update(@Param("date") Date date, @Param("start") Long start, @Param("end") Long end);

    @Select("select date_format(t.alarm_start_time, '%Y-%m-%d') AS `date` ,t.alarm_type as alarmType,count(t.id) as alarmCount" +
            "        FROM jac_alarm_record t " +
            " WHERE t.`alarm_start_time` >= #{start} AND t.`alarm_start_time` <= #{end}" +
            " GROUP BY `date`,alarmType" +
            "        ORDER BY `date` asc")
    List<AlarmCountResponse> groupBy(@Param("start") Date start, @Param("end") Date end);

    @Select("select id,vin,alarm_content as alarmContent,alarm_start_time as alarmStartTime from jac_alarm_record limit  #{pageStart},#{pageSize}")
    List<JacAlarmRecord> selectIdAll(@Param("pageStart") int pageStart, @Param("pageSize") int pageSize);
}
