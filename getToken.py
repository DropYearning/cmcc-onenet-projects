import base64
import hmac
import time
from urllib.parse import quote

# https://open.iot.10086.cn/doc/mqtt/book/manual/auth/token.html

def token(product_id, device_name, device_key):

    version = '2018-10-31'

    # 通过产品ID访问产品API
    # res格式： products/{pid}/devices/{device_name}
    res = 'products/%s/devices/%s' % (product_id, device_name)  

    # 用户自定义token过期时间
    et = str(int(time.time()) + 3600 * 24 *30)

 	# 签名方法，支持md5、sha1、sha256
    method = 'sha1'

    # 对device_key进行decode
    key = base64.b64decode(device_key)

    # 计算sign
    org = et + '\n' + method + '\n' + res + '\n' + version
    sign_b = hmac.new(key=key, msg=org.encode(), digestmod=method)
    sign = base64.b64encode(sign_b.digest()).decode()

    # value 部分进行url编码，method/res/version值较为简单无需编码
    sign = quote(sign, safe='')
    res = quote(res, safe='')

    # token参数拼接
    token = 'version=%s&res=%s&et=%s&method=%s&sign=%s' % (version, res, et, method, sign)

    return token


if __name__ == '__main__':
    product_id = input("请输入产品id: ")
    device_name = input("请输入设备名称: ")
    device_key = input("请输入设备key: ")
    
    print(token(product_id, device_name, device_key))