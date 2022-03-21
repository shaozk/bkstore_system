# 网上书店后台管理系统--书籍管理模块



## 目的和要求
* JavaEE课程设计，综合运用本课程所学习知识设计并实现一个基于 SSM 框架的 Web 应用程序
* 本课程所学知识：
  * 开发环境搭建
  
  * Spring IOC 和 Spring AOP 
  
  * SSM 框架整合
  
  * Spring 的事务管理
  
  * MyBatis 全局配置文件和 SQL 映射文件
  
  * MyBatis 与 Spring 的整合
  
  * Spring MVC 的工作流程
  
  * Spring MVC
  
  * 数据绑定（数据验证、表单标签库、JSON 数据交互等） 
  
  * Spring MVC 拦截器和统一异常处理；Spring MVC
  
  * 其他操作（包含国际化、文件上传和下载等）
    
    
## 具体实现
项目实现的主要代码文件以及功能介绍。
1. 相关配置文件：
* pom.xml
  
  * 本项目使用 maven 构建，其中 pom.xml 文件配置项目信息以及相关依赖。（jar 包--主要是SSM 整合相关）
  
* web.xml
  
  * web 项目的配置文件，配置 spring 容器的监听器（启动 Web 容器时，自动装配 applicationContext.xml 的配置信息）和 springmvc 前端控制器（DispatcherServlet），以及避免中文乱码、统
    一异常 404 处理。
  
* springmvc.xml
  
  * 配置 controller 层的注入
  * 配置静态资源映射
  * 配置视图解析器
  * 配置文件上传相关格式、限制以及文件上传拦截器
  * 配置国际化操作拦截器；配置校验器
  
* applicationContext.xml
  
  * 配置 service 层和 dao 层的注入加载数据库源文件
  * 配置 mybatis 工厂并与mybatis 整合
  * 配置事务管理器。
  
* mybatis-config.xml
  
  * mybatis 的配置文件，开启驼峰命名规则自动转换。（数据源，mapper 配置均在spring 容器总完成）
  
* BookDao.xml

  * mapper 映射文件，对书籍操作的 sql 映射语句

* TestDao.xml

  * 测试用的 mapper 文件
  
  
2. 资源文件
* db.properties

  * 外部数据源文件，配置数据库驱动、URL、用户名和密码。

* log4j.properties

  * 日志记录配置文件。

* message_en_US.properties

  * 国际化文件。（英文）

* message_zh_CN.properties

  * 国际化文件。（中文）

* ValidationMessages_en.properties

  * 数据验证国际化文件。（英文）

* ValidationMessages_zh.properties

  * 数据验证国际化文件。（中文）
  
  
3. 主文件：
   实体类：
* Book.java：书籍类，属性有 id、书名、价格、作者、类型、isbn、出版社、简介、封面。
  
  
  
  Dao 层：
  
* BookDao.java
  
  书籍的 dao 接口，定义书籍相关数据库操作，实现功能有：
  
  * int save(Book book)：保存书籍。
  * int update(Book book)：更新书籍。
  * int deleteAllById(int bookId)：通过 id 删除书籍。
  * Book findOneById(int bookId)：通过 id 查询书籍。
  * List<Book> findAll()：列出所有书籍。
  * List<Book> listBookByType(String type)：通过类型、书名、作者列出所有书籍，使用动态 SQL 语句实现，并添加模糊查询。
  * List<String> listType()：列出所有书籍类型。
  
* TestDao.java

  dao 层测试类。

  

  Service 层：

* BookService.java：书籍的 service 层接口
  
* BookServiceImpl.java
  
  书籍的 service 层实现类，实现功能有：
  
  * int addBook(Book book)：添加书籍。
  * Book getBook(String bookId)：通过 id 获取书籍。
  * List<Book> listBook()：列出所有书籍。
  * int deleteBook(String bookId)：通过 id 删除书籍。
  * String updateBook(Model model, Book book, MultipartFile file, HttpServletRequest request)：更新书籍。
  * List<String> listBookTypes()：列出所有书籍类型。
  * String listBookByType(String type, Model model)：通过类型、书名、作者模糊查找。
  * String saveFile(MultipartFile file, HttpServletRequest request)：保存文件方法，图片保存在项目路径的
    “/upload/images”文件夹下，通过 UUID 生成唯一文件名。
  
* TestService.java

  service 层测试接口。

* TestServiceImpl.java
  
  service 层测试实现类。
  
  
  
  Controller 层：
  
* BookPortalController.java
  
  书籍的 controller 层类，实现的功能有：
  
  * String search(String type, Model model)
    * 按书籍类型、书名、作者模糊查询。
  * String listBooks(Model model)
    * 获取所有书籍信息，返回一个书籍列表，通过 model 在前端页面展示。
  * String toAddBook(Model model)
    * 跳转到添加书籍页面。
  * String addBook(Book book, BindingResult bindingResult, MultipartFile file, Model model, HttpServletRequest request)
    * 添加书籍，使用 JSR303 进行数据验证。
  * showCover(String cover, HttpServletRequest request, HttpServletResponse response)
    * 通过图片名称来显示图片，鼠标右键另存为可以下载。
  * String toUpdateBook(Model model, Integer id)
    * 跳转到修改书籍页面。
  * String updateBook(Model model, Book book, MultipartFile file, HttpServletRequest request )
    * 修改书籍信息，通过数据绑定进行表单数据回填；对图片进行判空处理，为空（默认，代表不修改书籍封面）：使用原图片名称，不为空：保存该图片，并存数据库。
  * String deleteBook(String id)
    * 通过 id 删除书籍。
  
* BaseController.java：

  一个基类，使用@ExceptionHandler 注解的 exception()方法，其他类继承该类即可实现统一异常处理。

* I18nController.java

  国际化类，提供一个方法修改 locale 的值，实现国际化。

* TestController.java

  controller 层测试类。

* FileContrller.java
  
  文件上传测试类。
  
  
  
  拦截器:
  
* FileInterceptor.java
  
  在文件上传前对其进行拦截，实现后端对上传文件格式的限制。合法的文件后缀有：jpg,gif,png,ico,bmp,jpeg。（前台也有格式限制，但是不可避免用户上传违法文件）
  
  
  
  工具类：
  
* Constans.java

  存储默认图片名称（魔法值）。

* TextUtil.java

  判断文本是否为空。

  

## 附录

开发环境工具

| 环境与工具           | 名称          | 版本                 |
| -------------------- | ------------- | -------------------- |
| 操作系统             | Windows       | 10                   |
| 数据库               | MySQL         | 10.4.16-MariaDB      |
| 数据库管理和设计工具 | HeidiSQL      | 11.1.0.6116 (64 Bit) |
| Java 运行环境        | Jdk           | 1.8.0                |
| Web 应用服务器       | Tomcat        | 7.0.100              |
| 集成开发环境         | IntelliJ IDEA | 2021.3               |
| 浏览器               | Chrome        | 93.0.4553.0          |
| 绘图工具             | Diagrams      | 14.8.1               |



## 演示

![](E:\Code\IDEAProjects\bkstore\bkstore_system\images\书籍管理系统-主页.png)