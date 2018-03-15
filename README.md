# rent

## 项目介绍

基于Spring + SpringMVC + Mybatis简单开发的租赁系统，该项目使用restful风格，前后端分离

### 业务逻辑
- 登录
- 普通用户
    - 开始租用
        - 查看可租物品列表
        - 申请租用
    - 我的租用
        - 查看可租用物品
        - 取消申请租用
- 管理员
    - 类别管理(CRUD)
    - 物品管理(CRUD)
    - 租用管理
        - 查看租用清单
        - 审核租用（批准/否定）
        - 归还

### 组织结构

```
├── rent-common -- ssm框架公共模块
├── rent-dao -- 代码生成模块，无需开发
├── rent-service -- 服务的接口及实现
├── rent-web -- 网站前台
├── project-datamodel -- 项目数据库相关文件
└── project-docs -- 项目文档
```

### 技术选型

#### 后端技术

- Spring Framework
- SpringMVC
- MyBatis
- MyBatis Generator
- Apache Shiro
- Velocity
- Swagger2
- Log4J2
- Maven

#### 前端技术

- Bootstrap
- AngularJS
- jQuery

### 模块依赖

```
rent-web -> rent-service -> rent-dao -> rent-common
```

### 编程规约

后台参照`阿里巴巴Java开发手册`

## 项目运行

1. 下载项目并构建： git clone xxx; mvn clean install

2. 新建数据库: project-datamodel/favorisites.sql

3. 修改数据库配置文件: rent-service/src/main/resources/jdbc-config.properties

4. mvn jetty run

5. 打开页面: http://localhost:6688/login.html & http://localhost:6688/swagger-ui.html

## 项目预览

### 数据模型

![数据模型图](/project-datamodel/rent.png)

### 界面

![start-rent](/project-docs/images/start-rent.png)
![my-rent](/project-docs/images/my-rent.png)
![category](/project-docs/images/category.png)
![stuff](/project-docs/images/stuff.png)
![rent](/project-docs/images/rent.png)

### restful api

![restful](/project-docs/images/restful.png)

## 许可证

[Apache-2.0](http://www.apache.org/licenses/LICENSE-2.0)
