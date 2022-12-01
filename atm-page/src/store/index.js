import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    isLogin: false,
    user: {},
   
  },
  getters: {
    getUser: state => {
      return state.user
    },
    getState: state => {
      return state.isLogin
    },
  
  },
  mutations: {
    refresh: (state) => {

      state.user = JSON.parse(sessionStorage.getItem("user"))
      
    },
    SET_USER: (state, user) =>{
      state.user = user
      sessionStorage.setItem("user",JSON.stringify(user))
    },
    LOG_IN: (state, user) =>{
      state.isLogin = true
      state.user = user
      sessionStorage.setItem("user",JSON.stringify(user))
    },
    LOG_OUT: (state) => {
      state.isLogin = false 
      state.user = {}
      sessionStorage.removeItem("user")
    }


  },
  actions: {
  },
  modules: {
  }
})


