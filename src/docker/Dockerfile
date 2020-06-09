FROM java:8
VOLUME /tmp
ADD book-0.0.1-SNAPSHOT.jar
RUN bash -c 'touch /app.jar'
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

# FROM openjdk:8u181-jdk-alpine ： 从docker仓库中获取基础镜像
# ARG workdir=/app ： 添加变量，该变量只在当前的dockerfile中有效，如果换成ENV，则在容器中生效。这里需要注意的是，ARG和ENV对哪些指令是起效的，可以参考  docker - Dockerfile常用指令
# VOLUME ${workdir} ： 把宿主机的目录（该目录可以通过docker inspect dockerName查看）挂载到容器中的/app这个目录，这样可以在宿主机中查看该目录的内容。还有一个很重要的原因，就是数据持久化，如果不挂载，当容器关闭删除后，数据将会跟着被删除。这里因为/app是应用所在的目录，该目录会产生日志等其它内容。
# WORKDIR ${workdir} ：指定工作目录，下面的指令操作将在这个指定目录中执行。还有一点是，当通过交互模式的exec命令进入到该容器时，默认当前路径是/app
# ADD springboot-docker-1.0.jar app.jar ： 添加文件到WORKDIR
# EXPOSE 8080 ： 暴露8080端口，需要通过容器IP和端口访问应用。如果想通过宿主机的IP和端口访问应用，需要在RUN容器的时候绑定。可以参考docker - Dockerfile常用指令 的run命令
# ENTRYPOINT： 运行容器后执行的第一条命令，这里通过java -jar命令运行应用。