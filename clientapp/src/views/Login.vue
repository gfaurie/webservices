<template>
  <div class="login">
    <div class="container">
      <div class="text-center py-4">
        <h3>{{ isRegister ? "Inscription" : "Connexion" }}</h3>
      </div>
      <b-form class="form-reg" @submit="onSubmit">
        <login-form
          v-if="!isRegister"
          v-on:username="(e) => (logForm.username = e)"
          v-on:password="(e) => (logForm.password = e)"
        />
        <register-form
          v-if="isRegister"
          v-on:username="(e) => (regForm.username = e)"
          v-on:firstname="(e) => (regForm.firstname = e)"
          v-on:lastname="(e) => (regForm.lastname = e)"
          v-on:password="(e) => (regForm.password = e)"
          v-on:confirmpassword="(e) => (regForm.confirmpassword = e)"
          v-on:isManager="(e) => (regForm.isManager = e)"
        />
        <div class="text-center">
          <b-button type="submit" variant="primary" class="mx-1 rounded-pill">{{
            isRegister ? "S'inscrire" : "Se connecter"
          }}</b-button>
        </div>
      </b-form>
      <div class="text-center">
        <div class="mt-3" v-if="isRegister">
          Déjà un compte ?
          <a class="form-link" v-on:click="gotoLogin()">Connectez-vous</a>
        </div>
        <div class="mt-3" v-if="!isRegister">
          Pas encore de compte ?
          <a class="form-link" v-on:click="gotoRegister()">Inscrivez-vous</a>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
// @ is an   to /src
import UserService from "@/services/userService.js";
import LoginForm from "@/components/LoginForm";
import RegisterForm from "@/components/RegisterForm";

export default {
  name: "Login",
  components: {
    LoginForm,
    RegisterForm,
  },
  props: {
    isRegister: Boolean,
  },
  data() {
    return {
      userService: new UserService(this.$router),
      logForm: {
        username: "",
        password: "",
      },
      regForm: {
        username: "",
        firstname: "",
        lastname: "",
        password: "",
        confirmpassword: "",
        isManager: false,
      },
    };
  },
  methods: {
    onSubmit(event) {
      event.preventDefault();
      if (!this.isRegister) {
        console.log(this.logForm);
        this.userService.authenticate(this.logForm);
      } else {
        console.log(this.regForm);
      }
    },
    gotoRegister() {
      this.isRegister = true;
    },
    gotoLogin() {
      this.isRegister = false;
    },
  },
};
</script>

<style>
.form-reg {
  margin: auto;
  max-width: 400px;
}
.form-link:hover {
  color: #854d4d; /*10% darkened*/
  cursor: pointer;
}
.form-link {
  color: #945656;
}
</style>