<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD//EN"
        "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">

<hibernate-configuration>
  <session-factory>
     <property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
     <property name="hibernate.connection.url">jdbc:mysql:///ssh</property>
     <property name="hibernate.connection.username">root</property>
     <property name="hibernate.connection.password">123456</property>
     
     <!-- 方言 -->
     <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
      <!-- 打印 -->
      <property name="hibernate.show_sql">true</property>
       <property name="hibernate.format_sql">true</property>
       
       <property name="hibernate.hbm2ddl.auto">update</property>
      
      
      <mapping resource="com/spring/domain/User.hbm.xml"/>
  </session-factory>


</hibernate-configuration>
