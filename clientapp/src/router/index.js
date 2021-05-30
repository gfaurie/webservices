import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/Login.vue'
import HomeDev from '../views/HomeDev.vue'
import HomeManager from '../views/HomeManager.vue'

Vue.use(VueRouter)

const routes = [{
        path: '/',
        redirect: () => {
            return '/login';
        }
    }, {
        path: '/login',
        name: 'Login',
        component: Login,
        props: { isRegister: false }
    },
    {
        path: '/register',
        name: 'Register',
        component: Login,
        props: { isRegister: true }
    },
    {
        path: "/homedev",
        name: "HomeDev",
        component: HomeDev,
        // Si pas les droits redirige vers login/register
        beforeEnter: (to, from, next) => {
            if (localStorage.getItem("authenticatedUser") == null) {
                next({ name: "Login" });
            } else {
                if (localStorage.getItem("authenticatedUserIsManager") == "true") {
                    next({ name: "HomeManager" });
                } else {
                    next()
                }
            }
        }
    },
    {
        path: "/homemanager",
        name: "HomeManager",
        component: HomeManager,
        // Si pas les droits redirige vers login/register
        beforeEnter: (to, from, next) => {
            if (localStorage.getItem("authenticatedUser") == null) {
                next({ name: "Login" });
            } else {
                if (localStorage.getItem("authenticatedUserIsManager") == "false") {
                    next({ name: "HomeDev" });
                } else {
                    next()
                }
            }
        }
    }
]

const router = new VueRouter({
    routes
})

export default router