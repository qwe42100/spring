import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Officetool from '@/components/Officetool'
import sss from '@/components/sss'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/abc',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/',
      name: 'Officetool',
      component: Officetool
    },
    {
      path: '/d',
      name: 'sss',
      component: sss
    }

  ]
})
