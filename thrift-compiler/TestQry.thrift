/**
* �ļ���ΪTestQry.thrift
* ʵ�ֹ��ܣ�����һ����ѯ���struct��һ������ӿ�service
* ���ڣ�thrift-0.9.2
**/
namespace java com.thrift
struct QryResult {
        /**
        *������, 1�ɹ���0ʧ��
        */
        1:i32 code;
        /**
        *��Ӧ��Ϣ
        */
        2:string msg;
}
service TestQry{
        /**
        * ���Բ�ѯ�ӿڣ���qryCodeֵΪ1ʱ����"�ɹ�"����Ӧ��Ϣ��qryCodeֵΪ����ֵʱ����"ʧ��"����Ӧ��Ϣ
        * @param qryCode���Բ���
        */
        QryResult qryTest(1:i32 qryCode)
}