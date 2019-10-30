### 关闭eslint语法检测规则
出现如下问题
```java
  ✘  http://eslint.org/docs/rules/semi  Extra semicolon  
  src\main.js:13:22
  Vue.prototype.qs = QS;
```
在config的index.js把useEslint: false 设置为false

### 前端请求转发到后台
在config的index.js中设置
```java
proxyTable: {
      '/':{
              target:'http://localhost:80',//后台文件地址
              changeOrigin:true,
              pathRewrite:{
                '^/':''
              }
        }

    }
```
### 关于后台形参请求参数封装模式参照
```java
https://blog.csdn.net/suki_rong/article/details/80445880
```

##Jenkins token
```java
0cb9e679b21a65885e174f38f30a9d0cbcf6e6d8
```