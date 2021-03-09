<template>
  <div class="index">
    <el-menu
      :default-active="activeIndex2"
      :router="true"
      class="el-menu-demo"
      mode="horizontal"
      @select="handleSelect"
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b">
      <el-menu-item index="1">处理中心</el-menu-item>
      <el-submenu index="2">
        <template slot="title">我的工作台</template>
        <el-menu-item index="2-1">选项1</el-menu-item>
        <el-menu-item index="2-2">选项2</el-menu-item>
        <el-menu-item index="2-3">选项3</el-menu-item>
        <el-submenu index="2-4">
          <template slot="title">选项4</template>
          <el-menu-item index="2-4-1">选项1</el-menu-item>
          <el-menu-item index="2-4-2">选项2</el-menu-item>
          <el-menu-item index="2-4-3">选项3</el-menu-item>
        </el-submenu>
      </el-submenu>
      <el-menu-item index="3" disabled>消息中心</el-menu-item>
      <el-menu-item index="4"><a href="https://www.ele.me" target="_blank">订单管理</a></el-menu-item>
      <div style="float: right">
       <el-menu-item index="11" v-if="username == null"><router-link to='/login'>登录</router-link></el-menu-item>
       <el-menu-item index="12" disabled v-else>{{username}}</el-menu-item>
      </div>
    </el-menu>
    <div class="indexBackground">
    </div>
  </div>
<!--    <el-button>登录</el-button>-->
<!--    <el-image v-model="url"></el-image>-->
</template>

<script>
  import axios from  'axios'
    export default {
      name: "index",
      data() {
        return {
          activeIndex: '1',
          activeIndex2: '1',
          username:'',
          backgroundUrl:""
        };
      },
      mounted(){
        // console.log(this.$store)
        // var user =JSON.parse(window.localStorage.getItem("user"));
        this.username =  this.$store.state.user.username;
      },
      methods: {
        handleSelect(key, keyPath) {
          console.log(key, keyPath);
        }
      }
    }
</script>

<style scoped>
  /* .indexBackground{
    background-image: url("../assets/logo.png");
    background-position: top center;
    width: 200px;
    height: 200px;
  } */
</style>
