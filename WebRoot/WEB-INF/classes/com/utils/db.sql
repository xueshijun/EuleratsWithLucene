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
  (NULL, '32899_1', 1, '雀巢 优活饮用水330ml/瓶 X 6 组合装', 6.50, 9.00)
, (NULL, '1112265_1', 1, '雀巢 优活饮用水330ml/瓶 X 24 组合装', 26.00, 36.00)
, (NULL, '26665_1', 1, '农夫山泉 天然水550ml', 1.30, 1.50)
, (NULL, '1041787_1', 1, '农夫山泉 天然水550ml/瓶 X 6 组合装', 6.80, 12.00)
, (NULL, '23732_1', 1, '雀巢 优活饮用水330ml/瓶', 1.20, 1.50)
, (NULL, '3652118_1', 1, '冰露 矿物质水 350ml/瓶 X 24 组合装可口可乐公司荣誉出品', 17.90, 28.80)
, (NULL, '2981892_1', 1, '冰露 矿物质水 350ml/瓶 X 6 组合装可口可乐公司荣誉出品', 4.50, 7.20)
, (NULL, '1114464_1', 1, '巴黎水 天然有气矿泉水(原味)330ml/瓶(法国) *24', 199.00, 326.40)
, (NULL, '900096_1', 1, '冰露 矿物质水 350ml/瓶可口可乐公司荣誉出品', 0.80, 1.20)
, (NULL, '1114463_1', 1, '巴黎水 天然有气矿泉水(原味)330ml/瓶(法国) *6', 45.90, 81.60)
, (NULL, '32894_1', 1, '农夫山泉 饮用天然水 380ml/瓶 X 6 组合装', 6.00, 9.00)
, (NULL, '2917758_1', 1, '冰露 矿物质水550ml/瓶 X 24 组合装可口可乐公司荣誉出品', 20.50, 28.80)
, (NULL, '48391_1', 1, '冰露 矿物质水550ml/瓶', 0.90, 1.20)
, (NULL, '23731_1', 1, '农夫山泉 天然水380ml', 1.20, 1.50)
, (NULL, '997126_1', 1, '景田百岁山 饮用天然矿泉水570ml/瓶', 2.00, 2.50)
, (NULL, '2984290_1', 1, '雀巢 深泉饮用水550ml/瓶 X 24 组合装', 35.90, 48.00)
, (NULL, '1090382_1', 1, '景田百岁山 饮用天然矿泉水348ml/瓶', 1.60, 2.00)
, (NULL, '1041736_1', 1, '雀巢 优活饮用水550ml/瓶 X 6 组合装', 6.80, 10.80)
, (NULL, '13406_1', 1, '统一 ALKAQUA优质饮用天然水570ml/瓶', 3.00, 3.90)
, (NULL, '2712279_1', 1, '雀巢 深泉饮用水550ml/瓶 X 6 组合装', 9.20, 12.00)
, (NULL, '24191_1', 1, '统一 ALKAQUA优质饮用矿物质水570ml/瓶 X 15 组合装', 44.95, 52.50)
, (NULL, '1122421_1', 1, '法国依云 天然矿泉水500ml*24', 179.00, 326.40)
, (NULL, '1041722_1', 1, '冰露 矿物质水550ml/瓶 X 6 组合装可口可乐公司荣誉出品', 5.20, 7.20)
, (NULL, '1381820_1', 1, '统一 ALKAQUA优质饮用天然水570ml/瓶 X 6 组合装', 17.99, 21.00)
, (NULL, '1025106_1', 1, '昆仑山 矿泉水510ml/瓶', 4.40, 5.50)
, (NULL, '1117413_1', 1, '法国依云 天然矿泉水500ml*6', 57.60, 81.60)
, (NULL, '1144938_1', 1, '雀巢 深泉饮用水550ml/瓶', 1.60, 2.00)
, (NULL, '4195437_1', 1, '昆仑山 矿泉水510ml/瓶 X 72 组合装', 315.00, 396.00);


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
  (NULL, '176924', 3, '【节能补贴】三洋（SANYO）43英寸LED液晶电视43CE660LED', 3149.00, 0.00)
, (NULL, '203570', 3, '三星（SAMSUNG）46英寸智能LED液晶电视UA46ES5500RXXZ ', 6199.00, 0.00)
, (NULL, '180992', 3, '【节能补贴】创维（Skyworth）32英寸互联网3D LED液晶电视32E7BRD（黑色）', 2099.00, 0.00)
, (NULL, '178548', 3, '【节能补贴】索尼（SONY）55英寸全高清3D LED液晶电视KDL-55HX750（黑色）', 8799.00, 0.00)
, (NULL, '308535', 3, '夏普(SHARP) 46英寸LED电视LCD-46LX235A', 5799.00, 0.00)
, (NULL, '308540', 3, '夏普（SHARP）46英寸LED电视LCD-46LX640A', 7888.00, 0.00)
, (NULL, '426179', 3, '三星（SAMSUNG）39英寸LED电视UA39EH5003RXXZ', 3499.00, 0.00)
, (NULL, '487042', 3, '【节能补贴】三洋（SANYO）43英寸3DLED电视43CE680LED', 4199.00, 0.00)
, (NULL, '426187', 3, '三星（SAMSUNG）32英寸智能LED液晶电视UA32ES5500RXXZ', 3399.00, 0.00)
, (NULL, '426181', 3, '三星（SAMSUNG）50英寸智能LED液晶电视UA50ES5500RXXZ', 7999.00, 0.00)
, (NULL, '487041', 3, '【节能补贴】三洋（SANYO）42英寸3D LED电视42CE536LED', 3999.00, 0.00)
, (NULL, '426565', 3, '【节能补贴】康佳（KONKA）39英寸电视LED39R5100DE', 3399.00, 0.00)
, (NULL, '426567', 3, '【节能补贴】康佳（KONKA）50英寸电视LED50R5100DE', 5499.00, 0.00)
, (NULL, '426563', 3, '【节能补贴】康佳（KONKA）32英寸3D LED电视LED32R5200PDE', 2499.00, 0.00)
, (NULL, '428215', 3, '【节能补贴】清华同方（THTF）32寸LED电视LC-32TL2800', 1699.00, 0.00)
, (NULL, '426566', 3, '【节能补贴】康佳（KONKA）42英寸电视LED42R5100DE', 3699.00, 0.00)
, (NULL, '426564', 3, '【节能补贴】康佳（KONKA）47英寸3D LED电视LED47R5200PDE', 5399.00, 0.00)
, (NULL, '431008', 3, '【节能补贴】海尔（Haier）39英寸LED电视LE39A70W', 2699.00, 0.00)
, (NULL, '330200', 3, '【节能补贴】创维（skyworth）39英寸LED电视39E6BRN-P', 2699.00, 0.00)
, (NULL, '208607', 3, 'LG 42英寸3D 液晶电视42CM540-CA', 2799.00, 0.00)
, (NULL, '173248', 3, '【节能补贴】海信（Hisense）42英寸全高清3D LED液晶电视LED42K310X3D（黑色）', 3599.00, 0.00)
, (NULL, '211263', 3, '东芝（TOSHIBA）46英寸3D LED液晶电视46TD100C', 5699.00, 0.00)
, (NULL, '315076', 3, '东芝（TOSHIBA）46英寸LED电视46HL150C', 5299.00, 0.00)
, (NULL, '144875', 3, 'LG 55英寸全高清3D LED液晶电视55LW5500-CA', 8999.00, 0.00)
, (NULL, '249945', 3, '【节能补贴】LG 42英寸全高清LED液晶电视42LS4100-CE', 4199.00, 0.00)
, (NULL, '263594', 3, '【节能补贴】东芝（TOSHIBA）46英寸全高清LED液晶电视46EL100CS', 4099.00, 0.00)
, (NULL, '141877', 3, 'LG 55英寸全高清LED液晶电视55LV4500-CA', 7199.00, 0.00)
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
  (NULL, 'B001OI25BY', 2, '金士顿手机存储卡microSD 8GB （TF卡）', 32.90, 59.00)
, (NULL, 'B0062WDTUS', 2, 'SanDisk 闪迪 手机存储卡microSDHC Class4 16GB TF卡', 59.00, 99.00)
, (NULL, 'B0062WDTL2', 2, 'SanDisk 闪迪 手机存储卡microSDHC Class4 8GB TF卡', 32.90, 69.00)
, (NULL, 'B006BT2NB8', 2, 'SAMSUNG 三星 8G microSDHC Class6 标准版 TF卡 MB-MS8GA/CN', 37.00, 168.00)
, (NULL, 'B0085J1AOS', 2, 'SanDisk 闪迪 microSDHC Class10 8GB至尊高速移动存储卡 UHS-1制式 读写速度最高可达30MB/s', 43.00, 99.00)
, (NULL, 'B003V8AK58', 2, '诺基亚N1280(NOKIA N1280)简约超长待机直板手机(黑色)', 138.00, 218.00)
, (NULL, 'B001OI25C8', 2, '金士顿手机存储卡microSD 16GB （TF卡）', 59.00, 99.00)
, (NULL, 'B0044UIYRS', 2, 'Kingston 金士顿 16G microSDHC Class4 TF卡', 59.00, 199.00)
, (NULL, 'B007XZL7PC', 2, 'SanDisk 闪迪 microSDHC Class10 16GB至尊高速移动存储卡 UHS-1制式 读写速度最高可达30MB/s', 89.00, 199.00)
, (NULL, 'B005MV1V64', 2, 'NOKIA 诺基亚 1010 双SIM卡 音乐手机(黑色 非定制机)', 196.00, 358.00)
, (NULL, 'B002PDODUS', 2, '三星B309(Samsung B309)时尚镜面直板CDMA手机(黑 电信定制)', 147.00, 199.00)
, (NULL, 'B0062WDT7G', 2, 'SanDisk 闪迪 手机存储卡microSDHC Class4 4GB TF卡', 25.00, 59.00)
, (NULL, 'B008I3GRV2', 2, '高性价比！爱高 10400mAh 超大容量 多功能 充电宝 移动电源 双USB输出（适用MP3 MP4 PSP NDS iPod iPhone iPad2 照相机以及各品牌手机等所有 USB接口设备）', 149.00, 399.00)
, (NULL, 'B006FTG9NW', 2, 'PISEN 品胜 苹果充电数据线(标准版 适用iPad2 iPhone3GS iPhone4 4S TOUCH4 NANO)', 14.50, 19.00)
, (NULL, 'B0062WDUA2', 2, 'SanDisk 闪迪 手机存储卡microSDHC Class4 32GB TF卡', 119.00, 189.00)
, (NULL, 'B005HMRTN2', 2, 'YOOBAO羽博YB-642 移动电源 11200毫安时（适用iPhone 4 IPAD2等智能手机及平板电脑）', 225.00, 258.00)
, (NULL, 'B008VOY3RI', 2, 'HUAWEI 华为 Ascend G330D(U8825D) 双卡双待智能3G手机(深灰色 联通定制)', 996.00, 1299.00);
*/
 