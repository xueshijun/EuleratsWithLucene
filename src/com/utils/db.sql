/**
create database yihaodian;

CREATE TABLE ITMmain(
	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	ITMid VARCHAR(16) NOT NULL,
	ITMstore int(2) NOT NULL,
	ITMtitle VARCHAR(120) CHARACTER SET utf8 NOT NULL,
	ITMprice FLOAT(6,2) NOT NULL,
	ITMmprice FLOAT(6,2) NOT NULL,
	PRIMARY KEY (id)
);

INSERT INTO ITMmain VALUES
  (NULL, '32899_1', 1, 'ȸ�� �Ż�����ˮ330ml/ƿ X 6 ���װ', 6.50, 9.00)
, (NULL, '1112265_1', 1, 'ȸ�� �Ż�����ˮ330ml/ƿ X 24 ���װ', 26.00, 36.00)
, (NULL, '26665_1', 1, 'ũ��ɽȪ ��Ȼˮ550ml', 1.30, 1.50)
, (NULL, '1041787_1', 1, 'ũ��ɽȪ ��Ȼˮ550ml/ƿ X 6 ���װ', 6.80, 12.00)
, (NULL, '23732_1', 1, 'ȸ�� �Ż�����ˮ330ml/ƿ', 1.20, 1.50)
, (NULL, '3652118_1', 1, '��¶ ������ˮ 350ml/ƿ X 24 ���װ�ɿڿ��ֹ�˾������Ʒ', 17.90, 28.80)
, (NULL, '2981892_1', 1, '��¶ ������ˮ 350ml/ƿ X 6 ���װ�ɿڿ��ֹ�˾������Ʒ', 4.50, 7.20)
, (NULL, '1114464_1', 1, '����ˮ ��Ȼ������Ȫˮ(ԭζ)330ml/ƿ(����) *24', 199.00, 326.40)
, (NULL, '900096_1', 1, '��¶ ������ˮ 350ml/ƿ�ɿڿ��ֹ�˾������Ʒ', 0.80, 1.20)
, (NULL, '1114463_1', 1, '����ˮ ��Ȼ������Ȫˮ(ԭζ)330ml/ƿ(����) *6', 45.90, 81.60)
, (NULL, '32894_1', 1, 'ũ��ɽȪ ������Ȼˮ 380ml/ƿ X 6 ���װ', 6.00, 9.00)
, (NULL, '2917758_1', 1, '��¶ ������ˮ550ml/ƿ X 24 ���װ�ɿڿ��ֹ�˾������Ʒ', 20.50, 28.80)
, (NULL, '48391_1', 1, '��¶ ������ˮ550ml/ƿ', 0.90, 1.20)
, (NULL, '23731_1', 1, 'ũ��ɽȪ ��Ȼˮ380ml', 1.20, 1.50)
, (NULL, '997126_1', 1, '�������ɽ ������Ȼ��Ȫˮ570ml/ƿ', 2.00, 2.50)
, (NULL, '2984290_1', 1, 'ȸ�� ��Ȫ����ˮ550ml/ƿ X 24 ���װ', 35.90, 48.00)
, (NULL, '1090382_1', 1, '�������ɽ ������Ȼ��Ȫˮ348ml/ƿ', 1.60, 2.00)
, (NULL, '1041736_1', 1, 'ȸ�� �Ż�����ˮ550ml/ƿ X 6 ���װ', 6.80, 10.80)
, (NULL, '13406_1', 1, 'ͳһ ALKAQUA����������Ȼˮ570ml/ƿ', 3.00, 3.90)
, (NULL, '2712279_1', 1, 'ȸ�� ��Ȫ����ˮ550ml/ƿ X 6 ���װ', 9.20, 12.00)
, (NULL, '24191_1', 1, 'ͳһ ALKAQUA�������ÿ�����ˮ570ml/ƿ X 15 ���װ', 44.95, 52.50)
, (NULL, '1122421_1', 1, '�������� ��Ȼ��Ȫˮ500ml*24', 179.00, 326.40)
, (NULL, '1041722_1', 1, '��¶ ������ˮ550ml/ƿ X 6 ���װ�ɿڿ��ֹ�˾������Ʒ', 5.20, 7.20)
, (NULL, '1381820_1', 1, 'ͳһ ALKAQUA����������Ȼˮ570ml/ƿ X 6 ���װ', 17.99, 21.00)
, (NULL, '1025106_1', 1, '����ɽ ��Ȫˮ510ml/ƿ', 4.40, 5.50)
, (NULL, '1117413_1', 1, '�������� ��Ȼ��Ȫˮ500ml*6', 57.60, 81.60)
, (NULL, '1144938_1', 1, 'ȸ�� ��Ȫ����ˮ550ml/ƿ', 1.60, 2.00)
, (NULL, '4195437_1', 1, '����ɽ ��Ȫˮ510ml/ƿ X 72 ���װ', 315.00, 396.00);


**/


/**
create database jingdong;

CREATE TABLE ITMmain(
	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	ITMid VARCHAR(16) NOT NULL,
	ITMstore int(2) NOT NULL,
	ITMtitle VARCHAR(120) CHARACTER SET utf8 NOT NULL,
	ITMprice FLOAT(6,2) NOT NULL,
	ITMmprice FLOAT(6,2) NOT NULL,
	PRIMARY KEY (id)
);


**/






/**
create database coo8;
CREATE TABLE ITMmain(
	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	ITMid VARCHAR(16) NOT NULL,
	ITMstore int(2) NOT NULL,
	ITMtitle VARCHAR(120) CHARACTER SET utf8 NOT NULL,
	ITMprice FLOAT(6,2) NOT NULL,
	ITMmprice FLOAT(6,2) NOT NULL,
	PRIMARY KEY (id)
);

INSERT INTO ITMmain VALUES
  (NULL, '176924', 3, '�����ܲ���������SANYO��43Ӣ��LEDҺ������43CE660LED', 3149.00, 0.00)
, (NULL, '203570', 3, '���ǣ�SAMSUNG��46Ӣ������LEDҺ������UA46ES5500RXXZ ', 6199.00, 0.00)
, (NULL, '180992', 3, '�����ܲ�������ά��Skyworth��32Ӣ�绥����3D LEDҺ������32E7BRD����ɫ��', 2099.00, 0.00)
, (NULL, '178548', 3, '�����ܲ��������ᣨSONY��55Ӣ��ȫ����3D LEDҺ������KDL-55HX750����ɫ��', 8799.00, 0.00)
, (NULL, '308535', 3, '����(SHARP) 46Ӣ��LED����LCD-46LX235A', 5799.00, 0.00)
, (NULL, '308540', 3, '���գ�SHARP��46Ӣ��LED����LCD-46LX640A', 7888.00, 0.00)
, (NULL, '426179', 3, '���ǣ�SAMSUNG��39Ӣ��LED����UA39EH5003RXXZ', 3499.00, 0.00)
, (NULL, '487042', 3, '�����ܲ���������SANYO��43Ӣ��3DLED����43CE680LED', 4199.00, 0.00)
, (NULL, '426187', 3, '���ǣ�SAMSUNG��32Ӣ������LEDҺ������UA32ES5500RXXZ', 3399.00, 0.00)
, (NULL, '426181', 3, '���ǣ�SAMSUNG��50Ӣ������LEDҺ������UA50ES5500RXXZ', 7999.00, 0.00)
, (NULL, '487041', 3, '�����ܲ���������SANYO��42Ӣ��3D LED����42CE536LED', 3999.00, 0.00)
, (NULL, '426565', 3, '�����ܲ��������ѣ�KONKA��39Ӣ�����LED39R5100DE', 3399.00, 0.00)
, (NULL, '426567', 3, '�����ܲ��������ѣ�KONKA��50Ӣ�����LED50R5100DE', 5499.00, 0.00)
, (NULL, '426563', 3, '�����ܲ��������ѣ�KONKA��32Ӣ��3D LED����LED32R5200PDE', 2499.00, 0.00)
, (NULL, '428215', 3, '�����ܲ������廪ͬ����THTF��32��LED����LC-32TL2800', 1699.00, 0.00)
, (NULL, '426566', 3, '�����ܲ��������ѣ�KONKA��42Ӣ�����LED42R5100DE', 3699.00, 0.00)
, (NULL, '426564', 3, '�����ܲ��������ѣ�KONKA��47Ӣ��3D LED����LED47R5200PDE', 5399.00, 0.00)
, (NULL, '431008', 3, '�����ܲ�����������Haier��39Ӣ��LED����LE39A70W', 2699.00, 0.00)
, (NULL, '330200', 3, '�����ܲ�������ά��skyworth��39Ӣ��LED����39E6BRN-P', 2699.00, 0.00)
, (NULL, '208607', 3, 'LG 42Ӣ��3D Һ������42CM540-CA', 2799.00, 0.00)
, (NULL, '173248', 3, '�����ܲ��������ţ�Hisense��42Ӣ��ȫ����3D LEDҺ������LED42K310X3D����ɫ��', 3599.00, 0.00)
, (NULL, '211263', 3, '��֥��TOSHIBA��46Ӣ��3D LEDҺ������46TD100C', 5699.00, 0.00)
, (NULL, '315076', 3, '��֥��TOSHIBA��46Ӣ��LED����46HL150C', 5299.00, 0.00)
, (NULL, '144875', 3, 'LG 55Ӣ��ȫ����3D LEDҺ������55LW5500-CA', 8999.00, 0.00)
, (NULL, '249945', 3, '�����ܲ�����LG 42Ӣ��ȫ����LEDҺ������42LS4100-CE', 4199.00, 0.00)
, (NULL, '263594', 3, '�����ܲ�������֥��TOSHIBA��46Ӣ��ȫ����LEDҺ������46EL100CS', 4099.00, 0.00)
, (NULL, '141877', 3, 'LG 55Ӣ��ȫ����LEDҺ������55LV4500-CA', 7199.00, 0.00)
*/


 
/**create database amazon;
CREATE TABLE ITMmain(
	id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	ITMid VARCHAR(16) NOT NULL,
	ITMstore int(2) NOT NULL,
	ITMtitle VARCHAR(120) CHARACTER SET utf8 NOT NULL,
	ITMprice FLOAT(6,2) NOT NULL,
	ITMmprice FLOAT(6,2) NOT NULL,
	PRIMARY KEY (id)
);
INSERT INTO ITMmain VALUES
  (NULL, 'B001OI25BY', 2, '��ʿ���ֻ��洢��microSD 8GB ��TF����', 32.90, 59.00)
, (NULL, 'B0062WDTUS', 2, 'SanDisk ���� �ֻ��洢��microSDHC Class4 16GB TF��', 59.00, 99.00)
, (NULL, 'B0062WDTL2', 2, 'SanDisk ���� �ֻ��洢��microSDHC Class4 8GB TF��', 32.90, 69.00)
, (NULL, 'B006BT2NB8', 2, 'SAMSUNG ���� 8G microSDHC Class6 ��׼�� TF�� MB-MS8GA/CN', 37.00, 168.00)
, (NULL, 'B0085J1AOS', 2, 'SanDisk ���� microSDHC Class10 8GB��������ƶ��洢�� UHS-1��ʽ ��д�ٶ���߿ɴ�30MB/s', 43.00, 99.00)
, (NULL, 'B003V8AK58', 2, 'ŵ����N1280(NOKIA N1280)��Լ��������ֱ���ֻ�(��ɫ)', 138.00, 218.00)
, (NULL, 'B001OI25C8', 2, '��ʿ���ֻ��洢��microSD 16GB ��TF����', 59.00, 99.00)
, (NULL, 'B0044UIYRS', 2, 'Kingston ��ʿ�� 16G microSDHC Class4 TF��', 59.00, 199.00)
, (NULL, 'B007XZL7PC', 2, 'SanDisk ���� microSDHC Class10 16GB��������ƶ��洢�� UHS-1��ʽ ��д�ٶ���߿ɴ�30MB/s', 89.00, 199.00)
, (NULL, 'B005MV1V64', 2, 'NOKIA ŵ���� 1010 ˫SIM�� �����ֻ�(��ɫ �Ƕ��ƻ�)', 196.00, 358.00)
, (NULL, 'B002PDODUS', 2, '����B309(Samsung B309)ʱ�о���ֱ��CDMA�ֻ�(�� ���Ŷ���)', 147.00, 199.00)
, (NULL, 'B0062WDT7G', 2, 'SanDisk ���� �ֻ��洢��microSDHC Class4 4GB TF��', 25.00, 59.00)
, (NULL, 'B008I3GRV2', 2, '���Լ۱ȣ����� 10400mAh �������� �๦�� ��籦 �ƶ���Դ ˫USB���������MP3 MP4 PSP NDS iPod iPhone iPad2 ������Լ���Ʒ���ֻ������� USB�ӿ��豸��', 149.00, 399.00)
, (NULL, 'B006FTG9NW', 2, 'PISEN Ʒʤ ƻ�����������(��׼�� ����iPad2 iPhone3GS iPhone4 4S TOUCH4 NANO)', 14.50, 19.00)
, (NULL, 'B0062WDUA2', 2, 'SanDisk ���� �ֻ��洢��microSDHC Class4 32GB TF��', 119.00, 189.00)
, (NULL, 'B005HMRTN2', 2, 'YOOBAO��YB-642 �ƶ���Դ 11200����ʱ������iPhone 4 IPAD2�������ֻ���ƽ����ԣ�', 225.00, 258.00)
, (NULL, 'B008VOY3RI', 2, 'HUAWEI ��Ϊ Ascend G330D(U8825D) ˫��˫������3G�ֻ�(���ɫ ��ͨ����)', 996.00, 1299.00);
*/
 