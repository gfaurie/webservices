<template>
  <div id="navbar">
    <b-navbar>
      <b-navbar-brand href="#">Time Management</b-navbar-brand>
      <!-- Align items to the left -->
      <b-navbar-nav class="ml-auto">
        <b-nav-item v-if="isAuthenticated" v-on:click="onChangeAuth()">
          Se déconnecter
        </b-nav-item>
        <b-nav-item v-if="!isAuthenticated" v-on:click="onChangeAuth()">
          Se connecter
        </b-nav-item>
      </b-navbar-nav>
    </b-navbar>
  </div>
</template>

<script>
export default {
  name: "Navbar",
  props: {
    isAuthenticated: Boolean,
  },
  methods: {
    onChangeAuth() {
      this.isAuthenticated = !this.isAuthenticated;
    },
  },
};
</script>

<style>
.navbar {
  background-color: #7799dd;
}
a.nav-link {
  padding-left: 10px;
  padding-right: 10px;
  color: black !important;
}
a.nav-link:hover {
  text-decoration: none;
  border-radius: 5px;
  background: linear-gradient(rgba(0, 0, 0, 0.1), rgba(0, 0, 0, 0.1));
}
</style>

