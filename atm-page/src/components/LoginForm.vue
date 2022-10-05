<template>
    <div class="cent">
      <el-form
        :model="ruleForm"
        status-icon
        :rules="rules"
        ref="ruleForm"
        label-width=auto
        class="demo-ruleForm"
      >
        <el-form-item label="用户名" prop="username">
          <el-input
            type="text"
            v-model="ruleForm.username"
            autocomplete="off"
            placeholder="请输入用户名"
          ></el-input>
        </el-form-item>

        <el-form-item label="密码" prop="password">
          <el-input
            type="password"
            v-model="ruleForm.password"
            autocomplete="off"
          ></el-input>
        </el-form-item>

        <el-form-item>
          <el-button
            type="primary"
            class="button"
            @click="submitForm('ruleForm')"
            >登陆</el-button
          >
        </el-form-item>
      </el-form>
    </div>

</template>


<script>
export default {
  data() {
    return {
      ruleForm: {
        username: "zhangsan",
        password: "123456",
      },
      rules: {
        username: [
          { required: true, message: "请输入用户名", trigger: "blur" },
        ],
        password: [{ required: true, message: "请输入密码", trigger: "blur" }],
        
      },
    };
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          // const _this = this
          this.$axios
            .post("/ATM/login", this.ruleForm)
            .then((res) => {
              //this.$store.commit("SET_USER", res.data.data.user);
              //this.$store.commit("SET_USERINFO", res.data.data.userinfo);
              console.log(res);
              this.$store.commit("LOG_IN", res.data.data);
              
              if(res.data.data.priority === 'cust')
              {
                this.$message({
                type: 'success',
                message: '登陆成功！欢迎您,尊敬的' + res.data.data.username + '客户' ,
              })
              this.$router.push("/index")

              }
              else
                this.$router.push("/admin")
            });
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
  },
};
</script>

<style scoped>
.cent {
  height: auto;
  width: auto;
  margin-top: 5%;
  margin-left: 0%;
}

.button {
  margin-left: 26%;
}



</style>