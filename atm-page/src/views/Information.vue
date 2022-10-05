<template>
    <div class="block">
        <div class="cent">
      <el-form
        :model="ruleForm"
        status-icon
        :rules="rules"
        ref="ruleForm"
        label-width=auto
        class="demo-ruleForm"
      >
        <el-form-item label="旧密码" prop="oldpassword" >
          <el-input
            type="password"
            v-model="ruleForm.oldpassword"
            autocomplete="off"
            placeholder="请输入您当前的密码"
          ></el-input>
        </el-form-item>

        <el-form-item label="新密码" prop="newpassword">
          <el-input
            type="password"
            v-model="ruleForm.newpassword"
            autocomplete="off"
            placeholder="请输入您的新密码"
          ></el-input>
        </el-form-item>


        <el-form-item label="确认密码" prop="againpassword">
          <el-input
            type="password"
            v-model="ruleForm.againpassword"
            autocomplete="off"
            placeholder="请再次输入您的新密码"
          ></el-input>
        </el-form-item>

        <el-form-item>
          <el-button
            type="primary"
            class="button"
            @click="change()"
            >修改密码</el-button
          >
        </el-form-item>
      </el-form>
    </div>
    </div>
    

</template>


<script>
export default {
  data() {
    var validateConfirmPass = (rule, value, callback) => {
  
  if (value !== this.ruleForm.newpassword) {
   callback(new Error('两次输入密码不一致!'));
  } else {
   callback();
  }
};
var validateOldPass = (rule, value, callback) => {
  
  if (value !== this.$store.state.user.password) {
   callback(new Error('密码错误!'));
  } else {
   callback();
  }
};
    return {
      ruleForm: {
        oldpassword: "",
        newpassword: "",
        againpassword: "",
      },
      rules: {
        oldpassword: [
          { required: true, message: "请输入当前密码", trigger: "blur" },
          { validator: validateOldPass, trigger: 'blur', required: true }
        ],
        newpassword: [{ required: true, message: "请输入新密码", trigger: "blur" },
                        {min: 6, max:16, message:"密码需要为6-16位",trigger:"blur"}
                    ],
        againpassword: [{ required: true, message: "请输入新密码", trigger: "blur" },
        { validator: validateConfirmPass, trigger: 'blur', required: true }
    ],
        
      },
    };
  },
  methods: {
    change() {
      this.$refs['ruleForm'].validate((valid) => {
        if (valid) {
          // const _this = this
          this.$axios
            .post("/ATM/change", this.ruleForm)
            .then((res) => {
              //this.$store.commit("SET_USER", res.data.data.user);
              //this.$store.commit("SET_USERINFO", res.data.data.userinfo);
              console.log(res);
              this.$store.state.user = res.data.data;
              sessionStorage.setItem("user", JSON.stringify(res.data.data));
              this.$message({
                type: 'success',
                message: '密码修改成功',
              })
              this.$router.push('/index')

            });
        } else {
          console.log("修改失败!!");
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

.block {
  margin: 0 auto;
  margin-top: 50px;
  height: 400px;
  width: 60%;
  border-radius: 6px;
  background-color: rgba(255, 255, 255, 0.7);
  padding: 50px;
}


</style>