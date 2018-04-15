# spring-boot-with-activiti
# 工作流整合 springboot demo

1.启动  
&#8194;&#8194;1)执行process-center.sql导入数据  
&#8194;&#8194;2)运行com.jerryl.SpringBootWithActivitiApplication下的主函数  
&#8194;&#8194;3)项目默认访问80端口,http://localhost 配置文件是resource/application.yml

2.界面  
&#8194;&#8194;1)模型列表_操作页面  
![image](https://github.com/FlanceVoV/SpringCloud_Activity/blob/master/img/model_list.png)
&#8194;&#8194;2)模型列表_编辑页面  
![image](https://github.com/FlanceVoV/SpringCloud_Activity/blob/master/img/model_edit.png)

3.操作说明  
(数据库里有默认数据，只需配合activityDemo使用https://github.com/FlanceVoV/ActivityDemo)
1)创建流程  
2)发布流程  
流程发布了就可以执行  
发布过得流程如果在运行中是无法更改和删除的。
