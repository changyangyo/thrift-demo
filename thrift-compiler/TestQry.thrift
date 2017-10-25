/**
* 文件名为TestQry.thrift
* 实现功能：创建一个查询结果struct和一个服务接口service
* 基于：thrift-0.9.2
**/
namespace java com.thrift
struct QryResult {
        /**
        *返回码, 1成功，0失败
        */
        1:i32 code;
        /**
        *响应信息
        */
        2:string msg;
}
service TestQry{
        /**
        * 测试查询接口，当qryCode值为1时返回"成功"的响应信息，qryCode值为其他值时返回"失败"的响应信息
        * @param qryCode测试参数
        */
        QryResult qryTest(1:i32 qryCode)
}