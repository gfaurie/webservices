<template>
  <div class="login">
    <div class="container">
      <b-form class="form-reg" @submit="onSubmit">
        <b-form-group
          id="username-group"
          label="Nom d'utilisateur : "
          label-for="username-input"
        >
          <b-form-input
            id="username-input"
            v-model="loginForm.username"
            type="text"
            required
          ></b-form-input>
        </b-form-group>
        <b-form-group
          id="password-group"
          label="Mot de passe : "
          label-for="password-input"
        >
          <b-form-input
            id="password-input"
            v-model="loginForm.password"
            type="password"
            required
          ></b-form-input>
        </b-form-group>

        <b-button type="submit" class="primary">Se connecter</b-button>
        <b-button type="button" class="secondary">S'inscrire</b-button>
      </b-form>
    </div>
  </div>
</template>

<script>
// @ is an   to /src
// import UserService from '@/services/userService.js';

export default {
  name: "Login",
  data() {
    return {
      loginForm: {
        username: "",
        password: "",
      },
    };
  },
  methods: {
    onSubmit(event) {
      event.preventDefault();
      console.log(this.loginForm);
    },
  },
};
</script>

<style>
body, .container {
  height: 100%;
}
.form-reg {
  margin: auto;
  max-width: 400px;
}
</style>