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
      id="firstname-group"
      label="Prénom"
      label-for="firstname-input"
    >
      <b-form-input
        id="firstname-input"
        v-model="firstname"
        type="text"
        class="rounded-pill"
        @input="emitFirstname"
        required
      ></b-form-input>
    </b-form-group>
    <b-form-group
      id="lastname-group"
      label="Nom de famille"
      label-for="lastname-input"
    >
      <b-form-input
        id="lastname-input"
        v-model="lastname"
        type="text"
        class="rounded-pill"
        @input="emitLastname"
        required
      ></b-form-input>
    </b-form-group>
    <b-form-group
      id="password-group"
      label="Mot de passe"
      label-for="password-input"
    >
      <b-form-input
        id="password-input"
        v-model="password"
        type="password"
        class="rounded-pill"
        @input="emitPassword"
        :state="passwordState"
        required
      ></b-form-input>
      <b-form-invalid-feedback id="password-input-feedback">
        {{
          confirmpasswordState
            ? "Le mot de passe doit faire au minimum 6 caractères"
            : "Les deux mots de passe ne correspondent pas"
        }}
      </b-form-invalid-feedback>
    </b-form-group>
    <b-form-group
      id="confirmpassword-group"
      label="Confirmer le mot de passe"
      label-for="confirmpassword-input"
    >
      <b-form-input
        id="confirmpassword-input"
        v-model="confirmpassword"
        type="password"
        class="rounded-pill"
        @input="emitConfirmpassword"
        :state="confirmpasswordState"
        required
      ></b-form-input
      ><b-form-invalid-feedback id="confirmpassword-input-feedback">
        Les deux mots de passe ne correspondent pas
      </b-form-invalid-feedback>
    </b-form-group>
    <b-form-checkbox v-model="isManager" class="mb-2" @change="emitIsManager"
      >Je suis un manager</b-form-checkbox
    >
  </div>
</template>

<script>
export default {
  name: "RegisterForm",
  props: {
    username: String,
    firstname: String,
    lastname: String,
    password: String,
    confirmpassword: String,
    isManager: Boolean,
  },
  computed: {
    confirmpasswordState() {
      return this.password == this.confirmpassword;
    },
    passwordState() {
      return (
        this.password && this.password.length > 6 && this.confirmpasswordState
      );
    },
  },
  methods: {
    emitUsername(value) {
      this.$emit("username", value);
    },
    emitFirstname(value) {
      this.$emit("firstname", value);
    },
    emitLastname(value) {
      this.$emit("lastname", value);
    },
    emitPassword(value) {
      this.$emit("password", value);
    },
    emitConfirmpassword(value) {
      this.$emit("confirmpassword", value);
    },
    emitIsManager(value) {
      this.$emit("isManager", value);
    },
  },
};
</script>

<style>
</style>
