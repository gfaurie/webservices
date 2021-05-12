import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/Login.vue'
import HomeDev from '../views/HomeDev.vue'

Vue.use(VueRouter)

const routes = [{
        path: '/',
        redirect: () => {
            // TODO Etienne : si pas auth -> login, si auth dev -> dev, si auth manager -> manager
            return '/login';
        }
    }, {
        path: '/login',
        name: 'Login',
        component: Login,
    }, {
        path: "/homedev",
        name: "HomeDev",
        component: HomeDev,
        // TODO Etienne : si pas les droits redirige vers login
    }
    // {
    //     path: '/about',
    //     name: 'About',
    //     // route level code-splitting
    //     // this generates a separate chunk (about.[hash].js) for this route
    //     // which is lazy-loaded when the route is visited.
    //     component: () =>
    //         import ( /* webpackChunkName: "about" */ '../views/About.vue')
    // }
]

const router = new VueRouter({
    routes
})

export default router