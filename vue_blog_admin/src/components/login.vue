<template>
  <div class="login">
    <div class="login-form">
      <el-form>
        <el-form-item>
          <el-row>
            <h2>登录</h2>
          </el-row>
          <el-row type="flex">
            <el-col :span="4"><span style="width: 100px" :span="3">账号:</span></el-col>
            <el-col :span="20">
              <el-input
                placeholder="请输入内容"
                v-model="user.username"
                clearable>
              </el-input>
            </el-col>
          </el-row>
        </el-form-item>
        <el-form-item>
          <el-col :span="4"><span>密码:</span></el-col>
          <el-col :span="20">
            <el-input
              placeholder="请输入内容"
              v-model="user.password"
              type="password"
              clearable>
            </el-input>
          </el-col>
        </el-form-item>
        <div>
          <el-button type="primary" @click="login()">登录</el-button>
        </div>
      </el-form>
    </div>
  </div>
</template>

<script>
  import { get, post } from '../request/http'
  export default {
    name: 'HelloWorld',
    data() {
      return {
        user:{
          username: "",
          password: ""
        }
      }
    },
    methods: {
      login: function () {
        post('/login?',this.user).then(res =>{
          this.$router.push({path: '/?username='+res.username})
        }).catch(error=>{
          alert(error);
        })
      }
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .demo-input-suffix {
    margin-bottom: 15px;
  }

  .login-form {
    width: 500px;
    margin: 0 auto;
  }

  body {
    font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
    font-weight: 400;
    font-size: $--font-size-base;
    color: $--color-black;
    -webkit-font-smoothing: antialiased;
  }
</style>
