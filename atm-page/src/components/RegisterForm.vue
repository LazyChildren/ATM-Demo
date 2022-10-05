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
        ></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input
          type="password"
          v-model="ruleForm.password"
          autocomplete="off"
        ></el-input>
      </el-form-item>
      <el-form-item label="确认密码" prop="confirmpassword">
        <el-input
          type="password"
          v-model="ruleForm.confirmpassword"
          autocomplete="off"
        ></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" class="confirmbutton" @click="submitForm('ruleForm')"
          >注册</el-button
        >
      </el-form-item>
    </el-form>
  </div>
</template>


<script>
export default {
  data() {
    var validateConfirmPass = (rule, value, callback) => {
  
    if (value !== this.ruleForm.password) {
     callback(new Error('两次输入密码不一致!'));
    } else {
     callback();
    }
 };
    return {
      ruleForm: {
        username: "",
        password: "",
        confirmpassword: "",
      },
        
      rules: {
        password: [{ required: true, message: "请输入密码", trigger: "blur" },
        { min: 6, max: 16, message: "密码需要由8-16位组成", trigger: "blur" },],
        username: [
          { required: true, message: "请输入用户名", trigger: "blur" },
        ],
        confirmpassword: [
            {required: true, message: "请再次输入密码", trigger: "blur"},
            { validator: validateConfirmPass, trigger: 'blur', required: true }

        ],
      },
    };
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          // const _this = this
          this.$axios.post("/ATM/register", this.ruleForm).then((res) => {
            //this.$store.commit("SET_USER", res.data.data.user);
            //this.$store.commit("SET_USERINFO", res.data.data.userinfo);
            console.log(res);
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

.confirmbutton {
  margin-left: 20%;
}
</style>