// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import axios from 'axios'

// axios 配置
axios.defaults.timeout = 5000; //请求超时的时间设定
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8';  //axios默认的请求方式,可以自己设置
axios.defaults.baseURL = 'http://localhost:8088';  //axios默认的请求地址,开发时可以实际的接口地址来设置该值,去请求别人的接口(前提是后台已经帮你解决了接口的跨域问题,如果没有,请看下文,我们自己可以解决开发跨域的问题)
Vue.prototype.axios= axios

Vue.use(ElementUI)
Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
