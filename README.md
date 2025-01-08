# park-java

## 介绍
停车管理系统后端是一个基于Spring Boot框架开发的后端服务，旨在提供一个高效、可靠的停车管理解决方案。该系统支持多种功能，包括用户管理、订单管理、停车位管理、评价系统等，以满足不同用户的需求。

## 软件架构
本项目采用了分层架构设计，主要包括以下几个部分：
- 控制器层（Controller）：处理HTTP请求，调用服务层进行业务处理，并返回响应结果。
- 服务层（Service）：包含业务逻辑处理，调用数据访问层进行数据操作。
- 数据访问层（Mapper）：与数据库进行交互，执行数据的增删改查操作。
- 实体层（Pojo）：定义了系统中使用的各种实体对象。
- 配置层（Config）：包含系统的配置信息，如数据库配置、文件上传配置等。
- 工具类（Utils）：提供一些通用的工具方法，如阿里云OSS上传工具等。

## 安装教程
1. 确保您的系统已安装Java 11和Maven。
2. 克隆项目到本地：
   ```
   git clone [项目地址]
   ```
3. 进入项目目录：
   ```
   cd springboot-stop-tool
   ```
4. 使用Maven构建项目：
   ```
   mvn clean install
   ```
5. 配置数据库连接信息，修改`application.yml`文件中的数据库配置。
6. 运行项目：
   ```
   mvn spring-boot:run
   ```

## 使用说明
1. 访问系统接口文档，了解各个API的使用方法。
2. 通过Swagger UI界面测试API功能。
3. 根据业务需求调用相应的接口进行操作。

## 参与贡献
1. Fork 本仓库。
2. 新建 Feat_xxx 分支。
3. 提交代码。
4. 新建 Pull Request。

## 特技
1. 使用 `Readme_XXX.md` 来支持不同的语言，例如 `Readme_en.md`, `Readme_zh.md`。
2. Gitee 官方博客 [blog.gitee.com](https://blog.gitee.com)。
3. 了解 Gitee 上的优秀开源项目，访问 [https://gitee.com/explore](https://gitee.com/explore)。
4. [GVP](https://gitee.com/gvp) 全称是 Gitee 最有价值开源项目，是综合评定出的优秀开源项目。
5. Gitee 官方提供的使用手册 [https://gitee.com/help](https://gitee.com/help)。
6. Gitee 封面人物是一档用来展示 Gitee 会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)。

## 依赖管理
项目使用Maven进行依赖管理，`pom.xml`文件中列出了所有需要的依赖项，包括Spring Boot、MyBatis、MySQL、Swagger等。

## 开发者指南
- [MyBatis Quick Start](https://github.com/mybatis/spring-boot-starter/wiki/Quick-Start)
- [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
- [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
- [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
- [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

## 参考文档
- [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
- [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.4.0/maven-plugin)
- [Create an OCI image](https://docs.spring.io/spring-boot/3.4.0/maven-plugin/build-image.html)
- [MyBatis Framework](https://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/)
- [Spring Web](https://docs.spring.io/spring-boot/3.4.0/reference/web/servlet.html)

