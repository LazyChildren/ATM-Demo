import axios from 'axios'
import ElementUI from 'element-ui'
import store from '@/store'
import router from '@/router'

axios.defaults.baseURL='http://120.46.154.76:9091'
axios.defaults.withCredentials = true



//前置拦截
axios.interceptors.request.use(config => {
    
    return config
})

axios.interceptors.response.use(response => {
    let res = response.data
    console.log(res)

    if (res.code === 200) {
        console.log('ok')
        return response
    }
    else if(res.code === 401)
    {
        ElementUI.Message.error(response.data.msg, { duration: 3000 });
        store.commit("REMOVE_INFO");
        router.push("/login")
        return Promise.reject(response.data.msg)
    }
    else {
        ElementUI.Message.error(response.data.msg, { duration: 3000 });
        return Promise.reject(response.data.msg)
    }



})