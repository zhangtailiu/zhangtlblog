<template>
    <div>
      <h1>hello{{username}}</h1>
        <el-button v-if="username == ''" type="primary" @click="loginPage">登陆</el-button>
    </div>
</template>

<script>
    export default {
        name: "index",
      data(){
          return{
            username:""
          }
      },
      methods: {
        loginPage : function(){
          this.$router.push({ path:'/login'});
        }
      }
    }
</script>

<style scoped>
</style>
