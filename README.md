# Time Converter
Exemplo de uso:
```java
final Calendar calendar = Calendar.getInstance();
this.logger.info(Converter.toDate(calendar, new Date()));
```
**Output**: (*java.util.Date*) Wed Apr 12 15:51:44 BRT 2017
```java
final LocalDate date = null;
this.logger.info(Converter.toDate(date, new Date()));
```
**Output:** (*java.util.Calendar*) java.util.GregorianCalendar[time=1492023104441,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="America/Sao_Paulo",offset=-10800000,dstSavings=3600000,useDaylight=true,transitions=129,lastRule=java.util.SimpleTimeZone[id=America/Sao_Paulo,offset=-10800000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=9,startDay=15,startDayOfWeek=1,startTime=0,startTimeMode=0,endMode=3,endMonth=1,endDay=15,endDayOfWeek=1,endTime=0,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2017,MONTH=3,WEEK_OF_YEAR=15,WEEK_OF_MONTH=3,DAY_OF_MONTH=12,DAY_OF_YEAR=102,DAY_OF_WEEK=4,DAY_OF_WEEK_IN_MONTH=2,AM_PM=1,HOUR=3,HOUR_OF_DAY=15,MINUTE=51,SECOND=44,MILLISECOND=441,ZONE_OFFSET=-10800000,DST_OFFSET=0]
