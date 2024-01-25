from datetime import datetime


def toTimeStamp(te_time_p: str) -> int:
    datetime_current_l = datetime.strptime("01.01.2020 " + te_time_p, '%d.%m.%Y %H:%M:%S,%f')
    return datetime.timestamp(datetime_current_l)


def toMinute(te_time_p: str) -> int:
    datetime_current_l = datetime.strptime("01.01.2020 " + te_time_p, '%d.%m.%Y %H:%M:%S,%f')
    return datetime_current_l.minute

