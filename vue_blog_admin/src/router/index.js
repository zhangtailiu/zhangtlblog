import Vue from "vue";
import Router from "vue-router";
import login from "@/components/login";
import index from "@/components/index";
import home from "@/components/home";

Vue.use(Router);

export default new Router({
  mode: "history",
  routes: [
    {
      path: "/home",
      name: "home",
      component: home,
      redirect: "/index",
      children: [
        {
          path: "/index",
          name: "index",
          component: index,
          meta: {
            requireAuth: true,
          },
        },
      ],
    },
    {
      path: "/login",
      name: "login",
      component: login,
    },
  ],
});
