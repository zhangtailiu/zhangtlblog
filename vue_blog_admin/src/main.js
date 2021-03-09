// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue' //vue 模块在 node_modules 中
import App from './App' //App 即 App.vue 里定义的组件
import router from './router' // 即 router 文件夹里定义的路由
import ElementUI from 'element-ui' //饿了吗UI
import 'element-ui/lib/theme-chalk/index.css'
import axios from 'axios'
import store from './store' //引入store 的vuex配置
// axios 配置 已经在http.js中进行设置了所以这里的设置没有什么用
// axios.defaults.timeout = 5000 //请求超时的时间设定
// axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8' //axios默认的请求方式,可以自己设置
// axios.defaults.baseURL = 'http://localhost:8088' //axios默认的请求地址,开发时可以实际的接口地址来设置该值,去请求别人的接口(前提是后台已经帮你解决了接口的跨域问题,如果没有,请看下文,我们自己可以解决开发跨域的问题)
Vue.prototype.axios= axios

Vue.use(ElementUI)
Vue.config.productionTip = false //阻止vue 在启动时生成生产提示

//路由加载之前判断钩子 未登录则跳转到能录页面
router.beforeEach((to, from, next) => {
  if (to.meta.requireAuth) {
    if (store.state.user.username) {
      next()
    } else {
      next({
        path: 'login',
        query: {redirect: to.fullPath}
      })
    }
  } else {
    next()
  }
}
)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
