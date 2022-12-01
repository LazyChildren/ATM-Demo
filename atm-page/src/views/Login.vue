<template>
    <div class="formarea">
      <el-tabs v-model="activeName" @tab-click="handleClick" class="tabs">
        <el-tab-pane label="登录" name="login"><Form /></el-tab-pane>

        <!-- <el-tab-pane label="注册" name="register"><Register/></el-tab-pane> -->
      </el-tabs>
    </div>
</template>

<script>
import Form from "../components/LoginForm.vue"
import Register from "../components/RegisterForm.vue"

export default {
  name: "login",
  components: {
    Form,Register,
  },
  data() {
    return {
      activeName: "login",
    };
  },
  methods: {
    created() {
      //自动加载indexs方法
    },
  },
};
</script>



<style scoped>


.formarea{
  margin: 0 auto;
  background-color: rgba(255, 255, 255, 0.5);
  height: auto;
  width: 33.3%;
  left: 33.3%;
  margin-top: 100px;
}


.tabs {
  padding-top: 20px;
  margin-left:10%;
  margin-right: 10%;
  height: 20%;
}

</style>