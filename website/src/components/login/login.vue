<template>
  <div class="hello">
    <el-form ref="from" :model="user" label-width="80px">
      <el-form-item label="账号">
        <el-input v-model="user.username"></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="user.password"></el-input>
      </el-form-item>
      <el-button type="primary" @click="onSubmit">登录</el-button>
      <el-button>取消</el-button>
    </el-form>
  </div>
</template>

<script>
  import axios from 'axios';
export default {
  name: 'HelloWorld',
  data () {
    return {
      msg: '测试',
      user:{
        username:"",
        password:""
      }
    }
  },
  methods:{
    onSubmit:function () {
      axios.post('/login',this.user).then(res =>{
        if(res.data == "success"){
          this.$router.push({ path:'/'});
        }
      }).catch(console.log(222));
    }
  },
  watch:{
    user:function () {
      console.log(user);
    }
  }
}
</script>

<style scoped>
h1, h2 {
  font-weight: normal;
}
.el-form{
  text-align: center;
  margin: 0 auto;
  width: 30%;
}
</style>
