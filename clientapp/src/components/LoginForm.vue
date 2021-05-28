<template>
  <div>
    <b-form-group
      id="username-group"
      label="Nom d'utilisateur : "
      label-for="username-input"
    >
      <b-form-input
        id="username-input"
        v-model="username"
        type="text"
        class="rounded-pill"
        @input="emitUsername"
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
        v-model="password"
        type="password"
        class="rounded-pill"
        @input="emitPassword"
        required
      ></b-form-input>
    </b-form-group>
  </div>
</template>

<script>
export default {
  name: "LoginForm",
  props: {
    username: String, 
    password: String,
  },
  methods: {
    emitUsername(value) {
      this.$emit("username", value);
    },
    emitPassword(value) {
      this.$emit("password", value);
    },
  },
};
</script>

<style>
</style>
