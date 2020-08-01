# -*- coding: UTF-8 -*-
import time
from onenet_http_api import OneNetHTTPHandle

h = OneNetHTTPHandle()
DEVICE_ID = "614460785"  # 设备id
MASTER_KEY = "FWZQ4rS0ZGOd6Q0MyhHwNdZ=PMg="  # master-key
# time_now = time.strftime('%Y-%m-%dT%H:%M:%S', time.localtime(time.time()))

if __name__ == '__main__':
    tm_sec = time.localtime(time.time()).tm_sec
    # 以当前时刻的秒数作为温度和湿度数据上报
    datapoints = {
        "testDatapoints": {
            "temperature": tm_sec,
            "humidity": tm_sec
        }
    }
    res = h.post_datapoints(MASTER_KEY, DEVICE_ID, datapoints)
    print(tm_sec, ":", res)

