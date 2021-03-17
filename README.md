### XCGLXT
本项目名为“薪酬管理系统”，是一个基于MVC架构并使用windowsbuilder插件设计界面的小系统，数据文件采用以MySQL数据库为基础设计表结构及数据，该系统主要用于演示学校的薪酬发放和课时结算等功能


MVC是Model View Controller的缩写，所谓的MVC架构把复杂的程序分成Model（模型）、View（视图）、Controller（控制器）三个部分，各部分的功能相互独立，实现了高内聚低耦合的设计理念。
- Model（模型）部分主要负责数据基础对象的创建，为实体类，与数据库数据产生连接
- View（视图）部分主要主要负责系统界面的显示
- Controller（控制器）部分主要负责连接MySQL数据库，读取数据库数据传到界面中显示


### 系统基本简介（具体内容在代码调试过程中有所改变，以代码为主）
1、 工资的构成
       1.1 专任教师的工资 由 ： 岗位工资 + 基础绩效+课酬+临时性加班报酬+补/扣  （5部分组成）

              岗位工资：教授2000元，副教授1800元，讲师1500元，助教1200元；
              基础绩效工资：教授1000元，副教授800元，讲师600元，助教500元；
              课酬= 职称系数×节数×学生系数×单位课筹 
                         职称系数：教授职称系数为1.5，副教授为1.3，讲师为1.2，助教和其他人员为1.0；
                         学生系数 =学生人数/60，不足1的按1来计算，单位课酬为35元/节

         1.2 非专任教师的工资： 岗位工资 + 基础绩效+管理岗绩效+岗位补助+临时性加班报酬+补/扣
                岗位工资：院长/书记：2000元，副院长/副书记： 1800元，系\部\中心主任：1500元，系\部\中心副主任：1200元，其他：1000元
                基础绩效工资：院长/书记：1100元，副院长/副书记： 900元，系\部\中心主任：700元，系\部\中心副主任：600元，其他：500元
                管理岗绩效：院长/书记：AV*2，副院长/副书记：AV*1.8，系\部\中心主任：AV*1.5，系\部\中心副主任：AV*1.2，其他：AV 。(Av为全院所有专任教师课酬的平均值)
                岗位补助：从事管理工作又承担教学任务的非专任教师享受岗位补助。岗位补助标准为：课酬的一半。课酬计算标准与专任教师相同。
          1.3  既从事教学工作又从事管理工作的（如院长），由个人选择按专任教师岗或非专任教师岗来计算工资。       
          1.4 临时性加班报酬和补/扣 必须提供备注信息对补/扣进行说明。              

  2、每学期开学初由录入专任教师的课时后，每次月发工资时 ，除了临时性补/扣、加班工资需要每次手动录入外，其它工资项由系统根据参数自动生成。

  3、系统提供一个参数设置模块，构成工资各项的参数，可以由管理员在软件的设置界面设定。设定后，下次发放工资时，自动调用新参数，但是已经发过的工资是不变。

  4、薪酬管理系统会根据数据的系统时间进行判断，财务人员只能在当月10日期发放当月的工作。其他时段不能发工资。

